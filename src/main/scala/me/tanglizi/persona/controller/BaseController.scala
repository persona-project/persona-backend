package me.tanglizi.persona.controller

import me.tanglizi.persona.`enum`.{Entity, UserGroup}
import me.tanglizi.persona.model.TypeCountPair
import me.tanglizi.persona.service.TypeCountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

class BaseController(val typeCountService: TypeCountService, val entity: Entity.Value) {

  implicit private[BaseController] val stringIdentity: String => String = identity[String]

  def count[A](group: String, key: String)(implicit converter: String => A): Array[TypeCountPair[A]] = typeCountService.count(
    UserGroup.withName(group.toUpperCase), entity, key
  )

}
