package me.tanglizi.persona.controller

import me.tanglizi.persona.model.{Response, TypeCountPair}
import me.tanglizi.persona.service.TypeCountService
import me.tanglizi.persona.`enum`.Entity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/user"))
class UserController (@Autowired override val typeCountService: TypeCountService)
  extends BaseController(typeCountService, Entity.USER) {

  @GetMapping(Array("/age"))
  def age(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(count[Int](group, "age"))

  @GetMapping(Array("/sex"))
  def sex(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(count(group, "sex"))

  @GetMapping(Array("/area"))
  def area(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(count(group, "area"))

}

