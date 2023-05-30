package com.fiap.global.solution;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API AgroSonar",
                version = "1.0.0",
                description = "A AgroSonic foi criada com objetivo de maximizar as produções agrícolas verticais e reduzir desperdícios. Utilizando tecnologias como inteligência artificial (IA) generativa, internet das coisas (IoT) e microfones ultrassônicos, a empresa realiza o mapeamento sonoro de espécies cultivadas.\n",
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
        ),
        servers = @Server(url = "http://localhost:8080")
)
public class SwaggerConfig {


}
