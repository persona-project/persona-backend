package org.persona.backend.service

import java.util

import org.persona.backend.`enum`.{Entity, UserGroup}
import org.persona.backend.model.TypeCountPair
import org.persona.backend.util.TryWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import redis.clients.jedis.{Jedis, JedisPool}

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

@Service
class TypeCountService(@Autowired val jedisPool: JedisPool) {

  def count[A](group: UserGroup.Value, entity: Entity.Value, key: String)(implicit converter: String => A ): Array[TypeCountPair[A]] = {
    TryWith( jedisPool.getResource: Jedis ) { jedis: Jedis =>
      val table: String = s"$group:$entity".toLowerCase
      val keySet: util.Set[String] = jedis.keys(s"$table:$key:*")

      val pairs: ArrayBuffer[TypeCountPair[A]] = ArrayBuffer()
      for (key <- keySet.asScala)
        pairs += TypeCountPair(converter(key.split(":").last), jedis.hget(key, "count").toLong)
      pairs.toArray
    }
  }

}
