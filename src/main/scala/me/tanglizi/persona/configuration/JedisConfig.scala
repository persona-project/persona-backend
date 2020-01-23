package me.tanglizi.persona.configuration

import org.springframework.context.annotation.{Bean, Configuration}
import redis.clients.jedis.{JedisPool, JedisPoolConfig}

@Configuration
class JedisConfig {

  @Bean
  def jedisPoolConfig(): JedisPoolConfig = {
    val config = new JedisPoolConfig()
    config.setMaxTotal(32)
    config
  }

  @Bean
  def jedisPool(jedisPoolConfig: JedisPoolConfig): JedisPool =
    new JedisPool(jedisPoolConfig, JedisConfig.HOST, JedisConfig.PORT, JedisConfig.TIMEOUT, JedisConfig.PASSWORD);
}

object JedisConfig {
  val HOST = "localhost"
  val PORT = 6379
  val TIMEOUT = 2000
  val PASSWORD = "redis"
}
