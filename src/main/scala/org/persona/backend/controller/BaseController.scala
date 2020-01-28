package org.persona.backend.controller

import org.persona.backend.`enum`.{Entity, TimeGroup, UserGroup}
import org.persona.backend.model.TypeCountPair
import org.persona.backend.service.TypeCountService

class BaseController(val typeCountService: TypeCountService, val entity: Entity.Value) {

  implicit val intConverter: String => Int = Integer.parseInt
  implicit val booleanConverter: String => Boolean = {case "0" => false; case "1" => true}

  def countGroup[A](group: String, key: String)(implicit converter: String => A): Array[TypeCountPair[A]] =
    typeCountService.countGroup(UserGroup.withName(group.toUpperCase), entity, key)

  def countDuration[A](group: String, key: String)(implicit converter: String => A): Array[TypeCountPair[A]] =
    typeCountService.countDuration(TimeGroup.withName(group.toUpperCase), entity, key)
}
