package br.com.fiap.client_management.client_management.infra.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setName("Hackathon (08/2024) - Turma: 2ADJT - Grupo 57");
        contact.setUrl("https://github.com/brunolimadev/fiap-hackathon-client-management");

        Info info = new Info()
                .title("Microservico de Gerenciamento de Clientes")
                .contact(contact)
                .version("1.0")
                .description("Responsável por operações de inclusão e leitura de clientes.");

        return new OpenAPI()
                .info(info);
    }
}
