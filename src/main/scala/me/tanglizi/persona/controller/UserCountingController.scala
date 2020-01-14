package me.tanglizi.persona.controller

import java.sql.Date
import java.time.{Duration, Instant, LocalDate, Period}

import me.tanglizi.persona.model.{Response, TypePair}
import me.tanglizi.persona.util.DataUtil
import org.apache.spark.sql.Row
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/user"))
class UserCountingController {

  @GetMapping(Array("/age"))
  def age(): Response[Array[TypePair[Int]]] = Response.ok(
    DataUtil.grouping(DataUtil.userDataset, "birth", {
      case Row(birth: Date, count: Long) =>
        TypePair(Period.between(birth.toLocalDate, LocalDate.now).getYears, count)
    })
  )

  @GetMapping(Array("/sex"))
  def sex(): Response[Array[TypePair[String]]] = Response.ok(
    DataUtil.grouping(DataUtil.userDataset, "sex", {
      case Row(sex: String, count: Long) =>
        TypePair(sex, count)
    })
  )
}

