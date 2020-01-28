package org.persona.backend.controller

import org.persona.backend.`enum`.Entity
import org.persona.backend.model.{Response, TypeCountPair}
import org.persona.backend.service.TypeCountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/reply"))
class ReplyController (@Autowired override val typeCountService: TypeCountService)
  extends BaseController(typeCountService, Entity.REPLY) {

  @GetMapping(Array("/anonymous"))
  def anonymous(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "anonymous"))

  @GetMapping(Array("/countVote"))
  def countVote(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(countGroup(group, "countVote"))

  @GetMapping(Array("/countComment"))
  def countComment(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(countGroup(group, "countComment"))

  @GetMapping(Array("/replyTime"))
  def replyTime(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countGroup(group, "replyTime"))

  @GetMapping(Array("/deleted"))
  def deleted(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "deleted"))

  @GetMapping(Array("/tagAgree"))
  def tagAgree(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "tagAgree"))

  @GetMapping(Array("/tagTop"))
  def tagTop(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "tagTop"))

  @GetMapping(Array("/activeFlag"))
  def activeFlag(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "activeFlag"))
}
