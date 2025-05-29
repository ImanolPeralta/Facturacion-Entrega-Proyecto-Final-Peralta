package com.comercioonline.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
	@Bean
	OpenAPI custonOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("API Sistema de Facturación | Java | Coderhouse")
						.version("1.0.0")
						.description("La API REST proporciona endpoints para administrar productos, clientes, ventas y detalles de venta en un sistema de facturación. "
						        + "Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre cada entidad. "
						        + "Los endpoints permiten listar, agregar, mostrar, editar y eliminar productos y clientes, así como registrar ventas y consultar sus detalles. "
						        + "La API está documentada utilizando Swagger, lo que facilita la comprensión y el uso de los diferentes endpoints.")
						.contact(new Contact()
								.name("Imanol Augusto Peralta")
								.email("imanolaugusto18@gmail.com")
								.url("https://github.com/ImanolPeralta"))
						.license(new License()
								.name("Licencia")
								.url("https://github.com/ImanolPeralta/Sistema-de-Facturacion-primera-entrega-Peralta.git"))
						)
				.servers(List.of(new Server()
								.url("http://localhost:8080")
								.description("Servidor Local")));
	}
}
