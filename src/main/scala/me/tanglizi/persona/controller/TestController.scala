package me.tanglizi.persona.controller

import org.springframework.web.bind.annotation._

@RestController
class TestController {

  @GetMapping(Array("/hello"))
  def hello(): String = "hello, scala with spring!"

}
