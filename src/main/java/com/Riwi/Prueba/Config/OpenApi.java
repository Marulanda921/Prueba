package com.Riwi.Prueba.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "gestión de encuestas", version = "1.0", description = "Documentación api de administración de empresas y vacantes"))
public class OpenApi {
}
