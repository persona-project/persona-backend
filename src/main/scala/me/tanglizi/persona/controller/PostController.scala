package me.tanglizi.persona.controller

import me.tanglizi.persona.`enum`.Entity
import me.tanglizi.persona.model.{Response, TypeCountPair}
import me.tanglizi.persona.service.TypeCountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/post"))
class PostController (@Autowired override val typeCountService: TypeCountService)
  extends BaseController(typeCountService, Entity.POST) {

  @GetMapping(Array("/anonymous"))
  def anonymous(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(count(group, "anonymous"))

  @GetMapping(Array("/countVote"))
  def countVote(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(count(group, "countVote"))

  @GetMapping(Array("/countReply"))
  def countReply(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(count(group, "countReply"))

  @GetMapping(Array("/countBrowse"))
  def countBrowse(@RequestParam("group") group: String): Response[Array[TypeCountPair[Int]]] =
    Response.ok(count(group, "countBrowse"))

  @GetMapping(Array("/postTime"))
  def postTime(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(count(group, "postTime"))

  @GetMapping(Array("/lastReplyTime"))
  def lastReplyTime(@RequestParam("group") group: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(count(group, "lastReplyTime"))

  @GetMapping(Array("/deleted"))
  def deleted(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(count(group, "deleted"))

  @GetMapping(Array("/tagSolve"))
  def tagSolve(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(count(group, "tagSolve"))

  @GetMapping(Array("/tagAgree"))
  def tagAgree(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(count(group, "tagAgree"))

  @GetMapping(Array("/tagLector"))
  def tagLector(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(count(group, "tagLector"))

  @GetMapping(Array("/tagTop"))
  def tagTop(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(count(group, "tagTop"))

  @GetMapping(Array("/activeFlag"))
  def activeFlag(@RequestParam("group") group: String): Response[Array[TypeCountPair[Boolean]]] =
    Response.ok(count(group, "activeFlag"))

}
