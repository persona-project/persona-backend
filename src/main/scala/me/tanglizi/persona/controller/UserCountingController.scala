package me.tanglizi.persona.controller

import me.tanglizi.persona.util.DataUtil
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/user"))
class UserCountingController {

  @GetMapping(Array("/age"))
  def age(): String = {
    DataUtil.userDataset
      .groupBy("birth")
      .count()
      .show

    "uncompleted"
  }
}

