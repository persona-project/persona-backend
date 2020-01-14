package me.tanglizi.persona.model

import java.time.Instant

case class Response[A](payload: A,
                       success: Boolean,
                       message: String,
                       timestamp: Instant = Instant.now()) {
}

object Response {
  def ok[A](payload: A) = new Response[A](payload, true, "success")
  def fail[A](payload: A, message: String) = new Response[A](payload, false, message)
}
