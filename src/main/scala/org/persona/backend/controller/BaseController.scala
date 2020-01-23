package org.persona.backend.controller

import org.persona.backend.`enum`.{Entity, UserGroup}
import org.persona.backend.model.TypeCountPair
import org.persona.backend.service.TypeCountService

class BaseController(val typeCountService: TypeCountService, val entity: Entity.Value) {

  implicit val intConverter: String => Int = Integer.parseInt
  implicit val booleanConverter: String => Boolean = {case "0" => false; case "1" => true}

  def count[A](group: String, key: String)(implicit converter: String => A): Array[TypeCountPair[A]] =
    typeCountService.count(UserGroup.withName(group.toUpperCase), entity, key)

}
