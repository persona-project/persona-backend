package org.persona.backend.configuration

import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.{PathSelectors, RequestHandlerSelectors}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerConfig {

  def productApi(): Docket = new Docket(DocumentationType.SWAGGER_2)
    .select()
    .apis(RequestHandlerSelectors.basePackage("me.tanglizi.persona"))
    .paths(PathSelectors.any())
    .build()
}
