package me.tanglizi.persona.service

import java.util

import me.tanglizi.persona.`enum`.{Entity, UserGroup}
import me.tanglizi.persona.model.TypeCountPair
import me.tanglizi.persona.util.TryWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import redis.clients.jedis.{Jedis, JedisPool}

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

@Service
class TypeCountService(@Autowired val jedisPool: JedisPool) {

  def count[A](group: UserGroup.Value, entity: Entity.Value, key: String)(implicit converter: String => A ): Array[TypeCountPair[A]] = {
    TryWith( jedisPool.getResource: Jedis ) { jedis: Jedis =>
      val keySet: util.Set[String] = jedis.keys(s"$group:$entity:$key:*".toLowerCase)

      println(s"$group:$entity:$key:*".toLowerCase)
      println(keySet.asScala)

      // var pairs: Array[TypeCountPair[A]] = Array()
      val pairs: ArrayBuffer[TypeCountPair[A]] = ArrayBuffer()
      for (key <- keySet.asScala)
        pairs += TypeCountPair(converter(key.split(":").last), jedis.hget(key, "count").toLong)
      println(pairs.mkString(", "))
      pairs.toArray
    }
  }

}
