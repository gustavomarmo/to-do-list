package br.com.gustavomarmo.to_do_list.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
            info = @Info(
                    contact = @Contact(
                            name = "Gustavo Marmo",
                            email = "gustavo.marmo@tivit.com",
                            url = "https://www.tivit.com"
                    ),
                    description = "API para gerenciamento de tarefas To-do List.",
                    title = "Documentação da API To-do List",
                    version = "1.0",
                    license = @License(
                            name = "Licença Exemplo",
                            url = "https://www.tivit.com"
                    ),
                    termsOfService = "Termos de serviço"
            ),
            servers = {
                    @Server(
                            description = "Local Env",
                            url = "http://localhost:8080"
                    )
            }
)
public class OpenApiConfig {
}
