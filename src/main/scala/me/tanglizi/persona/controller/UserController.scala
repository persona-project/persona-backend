package me.tanglizi.persona.controller

import java.sql.Date
import java.time.{Duration, Instant, LocalDate, Period}

import me.tanglizi.persona.model.{Response, TypePair}
import me.tanglizi.persona.util.{DataUtil, UserGroupUtil}
import org.apache.spark.sql.Row
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/user"))
class UserController {

  @GetMapping(Array("/age"))
  def age(@RequestParam("group") group: String): Response[Array[TypePair[Int]]] = Response.ok(
    DataUtil.grouping(DataUtil.userDataset, "birth",
      UserGroupUtil.getGroupFilter(group), {
      case Row(birth: Date, count: Long) =>
        TypePair(Period.between(birth.toLocalDate, LocalDate.now).getYears, count)
    })
  )

  @GetMapping(Array("/sex"))
  def sex(@RequestParam("group") group: String): Response[Array[TypePair[String]]] = Response.ok(
    DataUtil.grouping(DataUtil.userDataset, "sex",
      UserGroupUtil.getGroupFilter(group), {
      case Row(sex: String, count: Long) =>
        TypePair(sex, count)
    })
  )

  @GetMapping(Array("/area"))
  def area(@RequestParam("group") group: String): Response[Array[TypePair[String]]] = Response.ok(
    DataUtil.grouping(DataUtil.userDataset, "area",
      UserGroupUtil.getGroupFilter(group), {
      case Row(area: String, count: Long) =>
        TypePair(area, count)
    })
  )
}

