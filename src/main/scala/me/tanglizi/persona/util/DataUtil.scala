package me.tanglizi.persona.util

import java.time.Instant

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrameReader, Dataset, SparkSession}

object DataUtil {
  var url: String = _
  var username: String = _
  var password: String = _

  private val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Persona")
  private val session: SparkSession = SparkSession.builder().config(conf).getOrCreate()
  import session.implicits._

  private val dataFrameReader: DataFrameReader = session.read.format("jdbc")
    .option("url", url)
    .option("user", username)
    .option("password", password)


  lazy val userDataset: Dataset[User] = dataFrameReader.load().as[User]
}

case class User(id: Int, name: String, birth: Instant, sex: String,
                area: String, lastLoginTime: Instant, termId: Int,
                courseId: Int, selectCourseTime: Instant)
