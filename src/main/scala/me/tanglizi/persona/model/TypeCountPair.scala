package me.tanglizi.persona.model

import scala.beans.BeanProperty

case class TypeCountPair[T](@BeanProperty `type`: T, @BeanProperty count: Long) {}
