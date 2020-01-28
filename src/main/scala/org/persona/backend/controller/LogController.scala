package org.persona.backend.controller

import org.persona.backend.`enum`.Entity
import org.persona.backend.model.{Response, TypeCountPair}
import org.persona.backend.service.TypeCountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/log"))
class LogController (@Autowired override val typeCountService: TypeCountService)
  extends BaseController(typeCountService, Entity.Log) {

  @GetMapping(Array("/time"))
  def time(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "time"))

  @GetMapping(Array("/loginType"))
  def loginType(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "loginType"))

  @GetMapping(Array("/version"))
  def version(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "version"))

  @GetMapping(Array("/hostname"))
  def hostname(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "hostname"))

  @GetMapping(Array("/characterSet"))
  def characterSet(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "characterSet"))

  @GetMapping(Array("/screenResolution"))
  def screenResolution(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "screenResolution"))

  @GetMapping(Array("/screenColor"))
  def screenColor(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "screenColor"))

  @GetMapping(Array("/language"))
  def language(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "language"))

  @GetMapping(Array("/flashVersion"))
  def flashVersion(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "flashVersion"))

  @GetMapping(Array("/operationSystem"))
  def operationSystem(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "operationSystem"))

  @GetMapping(Array("/browserType"))
  def browserType(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "browserType"))

  @GetMapping(Array("/browserVersion"))
  def browserVersion(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "browserVersion"))

  @GetMapping(Array("/ip"))
  def ip(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "ip"))

  @GetMapping(Array("/region"))
  def region(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "region"))

  @GetMapping(Array("/searchKeyword"))
  def searchKeyword(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "searchKeyword"))

  @GetMapping(Array("/searchEngine"))
  def searchEngine(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "searchEngine"))

  @GetMapping(Array("/url"))
  def url(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "url"))

  @GetMapping(Array("/referer"))
  def referer(@RequestParam("duration") duration: String): Response[Array[TypeCountPair[String]]] =
    Response.ok(countDuration(duration, "referer"))
}
