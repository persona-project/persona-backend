package me.tanglizi.persona.controller

import me.tanglizi.persona.`enum`.{Entity, UserGroup}
import me.tanglizi.persona.model.TypeCountPair
import me.tanglizi.persona.service.TypeCountService

class BaseController(val typeCountService: TypeCountService, val entity: Entity.Value) {

  implicit val intConverter: String => Int = Integer.parseInt
  implicit val booleanConverter: String => Boolean = {case "0" => false; case "1" => true}

  def count[A](group: String, key: String)(implicit converter: String => A): Array[TypeCountPair[A]] =
    typeCountService.count(UserGroup.withName(group.toUpperCase), entity, key)

}
