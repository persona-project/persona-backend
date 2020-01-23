package org.persona.backend.model

import java.time.Instant

import scala.beans.BeanProperty

case class Response[A](@BeanProperty payload: A,
                       @BeanProperty success: Boolean,
                       @BeanProperty message: String,
                       @BeanProperty timestamp: Long = Instant.now().getEpochSecond) {
}

object Response {
  def ok[A](payload: A) = new Response[A](payload, true, "success")
  def fail[A](payload: A, message: String) = new Response[A](payload, false, message)
}
