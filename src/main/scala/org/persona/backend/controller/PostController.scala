package org.persona.backend.controller

import org.persona.backend.`enum`.Entity
import org.persona.backend.model.{Response, TypeCountPair}
import org.persona.backend.service.TypeCountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/post"))
class PostController (@Autowired override val typeCountService: TypeCountService)
  extends BaseController(typeCountService, Entity.POST) {

  @GetMapping(Array("/anonymous"))
  def anonymous(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "anonymous"))

  @GetMapping(Array("/countVote"))
  def countVote(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(countGroup(group, "countVote"))

  @GetMapping(Array("/countReply"))
  def countReply(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(countGroup(group, "countReply"))

  @GetMapping(Array("/countBrowse"))
  def countBrowse(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(countGroup(group, "countBrowse"))

  @GetMapping(Array("/postTime"))
  def postTime(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countGroup(group, "postTime"))

  @GetMapping(Array("/lastReplyTime"))
  def lastReplyTime(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countGroup(group, "lastReplyTime"))

  @GetMapping(Array("/deleted"))
  def deleted(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "deleted"))

  @GetMapping(Array("/tagSolve"))
  def tagSolve(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "tagSolve"))

  @GetMapping(Array("/tagAgree"))
  def tagAgree(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "tagAgree"))

  @GetMapping(Array("/tagLector"))
  def tagLector(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "tagLector"))

  @GetMapping(Array("/tagTop"))
  def tagTop(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "tagTop"))

  @GetMapping(Array("/activeFlag"))
  def activeFlag(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(countGroup(group, "activeFlag"))

}
