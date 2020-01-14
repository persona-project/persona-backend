package me.tanglizi.persona.util

import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._

object UserGroupUtil {
  val ALL: Column = col("id") > 0
  val MALE: Column = col("sex").equalTo("男")
  val FEMALE: Column = col("sex").notEqual("男")
  val NOT_ADULT: Column = datediff(add_months(col("birth"), 18*12), current_date()) > 0
  val ADULT: Column = datediff(add_months(col("birth"), 18*12), current_date()) <= 0

  val map: Map[String, Column] = Map(
    "all" -> ALL,
    "male" -> MALE,
    "female" -> FEMALE,
    "not_adult" -> NOT_ADULT,
    "adult" -> ADULT
  )

  def getGroupFilter(filter: String): Column = map.getOrElse(filter, ALL)
}

