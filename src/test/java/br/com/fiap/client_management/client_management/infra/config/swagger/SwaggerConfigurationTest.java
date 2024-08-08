package br.com.fiap.client_management.client_management.infra.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
class SwaggerConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void testMyOpenAPIBeanExists() {
        OpenAPI openAPI = context.getBean(OpenAPI.class);
        assertThat(openAPI).isNotNull();
    }

    @Test
    void testMyOpenAPIBeanProperties() {
        OpenAPI openAPI = context.getBean(OpenAPI.class);
        Info info = openAPI.getInfo();

        assertThat(info).isNotNull();
        assertThat(info.getTitle()).isEqualTo("Microservico de Gerenciamento de Clientes");
        assertThat(info.getVersion()).isEqualTo("1.0");
        assertThat(info.getDescription()).isEqualTo("Responsável por operações de inclusão e leitura de clientes.");

        Contact contact = info.getContact();
        assertThat(contact).isNotNull();
        assertThat(contact.getName()).isEqualTo("Hackathon (08/2024) - Turma: 2ADJT - Grupo 57");
        assertThat(contact.getUrl()).isEqualTo("https://github.com/brunolimadev/fiap-hackathon-client-management");
    }
}


