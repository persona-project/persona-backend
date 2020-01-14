package me.tanglizi.persona

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

object PersonaApp {
   def main(args: Array[String]): Unit = SpringApplication.run(classOf[PersonaApp], args : _*)
}

@SpringBootApplication
class PersonaApp{}

