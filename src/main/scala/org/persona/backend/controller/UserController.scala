package org.persona.backend.controller

import org.persona.backend.model.{Response, TypeCountPair}
import org.persona.backend.service.TypeCountService
import org.persona.backend.`enum`.Entity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/user"))
class UserController (@Autowired override val typeCountService: TypeCountService)
  extends BaseController(typeCountService, Entity.USER) {

  @GetMapping(Array("/age"))
  def age(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(countGroup[Int](group, "age"))

  @GetMapping(Array("/sex"))
  def sex(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countGroup(group, "sex"))

  @GetMapping(Array("/area"))
  def area(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countGroup(group, "area"))

}

