package me.tanglizi.persona.model

import scala.beans.BeanProperty

case class TypePair[T](@BeanProperty `type`: T, @BeanProperty count: Long) {}
