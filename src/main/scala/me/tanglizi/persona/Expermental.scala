package me.tanglizi.persona

import java.sql.Date

import me.tanglizi.persona.util.DataUtil
import org.apache.spark.sql.Row

object Expermental extends App {

  val res = DataUtil.userDataset
      .groupBy("birth")
      .count()
      .collect()
      .map{
        case Row(a: Date, b: Long) =>
          (a.toString, b)
      }

  println("#################")
  println(res.mkString("\n\n"))
  println("#################")
}
