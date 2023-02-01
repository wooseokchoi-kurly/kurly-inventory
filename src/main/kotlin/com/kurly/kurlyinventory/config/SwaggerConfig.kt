package com.kurly.kurlyinventory.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.SwaggerUiConfigProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun springShopOpenAPI(): OpenAPI? {
        return OpenAPI()
                .info(
                        Info().title("Inventory")
                                .description("Inventory application")
                                .version("v0.0.1")
                                .license(License().name("Apache 2.0").url("http://springdoc.org"))
                )
    }

    @Bean
    fun swaggerUiConfig(config: SwaggerUiConfigProperties): SwaggerUiConfigProperties {
        // 하단 schemas 제거
        config.defaultModelsExpandDepth = -1
        config.isDisableSwaggerDefaultUrl = true
        config.url = "/v3/api-docs"
        config.configUrl = "/v3/api-docs/swagger-config"

        return config
    }
}
