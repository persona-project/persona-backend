package me.tanglizi.persona.util

import com.google.common.base.CaseFormat
import me.tanglizi.persona.entity.User
import me.tanglizi.persona.model.TypePair
import org.apache.spark.SparkConf
import org.apache.spark.sql.{Column, DataFrame, DataFrameReader, Dataset, Row, SparkSession}

object DataUtil {
  var url: String = "jdbc:mysql://localhost:3306/persona"
  var username: String = "root"
  var password: String = "1234"

  private val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Persona")
  private val session: SparkSession = SparkSession.builder().config(conf).getOrCreate()
  import session.implicits._

  private val dataFrameReader: DataFrameReader = session.read.format("jdbc")
    .option("url", url)
    .option("user", username)
    .option("password", password)

  val userDataset: Dataset[User] = camelDataFrame("User").as[User]

  private def underscoresToCamel(str: String): String =
    CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str)

  private def camelDataFrame(table: String): DataFrame = {
    var df: DataFrame = dataFrameReader.option("dbtable", table).load()
    for (name <- df.columns)
      df = df.withColumnRenamed(name, underscoresToCamel(name))
    df
  }

  def grouping[T, U](ds: Dataset[T],
                     column: String,
                     filter: Column,
                     map: Row => TypePair[U]): Array[TypePair[U]] = ds
      .filter(filter)
      .groupBy(column)
      .count()
      .collect()
      .map(map(_))
}

