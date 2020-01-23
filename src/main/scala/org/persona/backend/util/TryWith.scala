package org.persona.backend.util

object TryWith {

  def apply[A <: AutoCloseable, B](resource: A)(function: (A) => B): B = {
    try
      function(resource)
    finally
      resource.close()
  }

}
