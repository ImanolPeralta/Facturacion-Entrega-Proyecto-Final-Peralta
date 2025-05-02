package com.comercioonline;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.comercioonline.dao.DaoFactory;
import com.comercioonline.models.Cliente;
import com.comercioonline.models.Producto;

@SpringBootApplication
public class SistemaFacturacionApplication implements CommandLineRunner {
	
	@Autowired
	private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(SistemaFacturacionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			Producto producto1 = Producto.builder()
				    .nombre("Notebook MacBook Pro 4")
				    .precio(1450000)
				    .descripcion("MacBook Pro con chip M3, pantalla Retina de 14 pulgadas, 16GB RAM, 512GB SSD")
				    .stock(10)
				    .build();

				Producto producto2 = Producto.builder()
				    .nombre("Teclado mecánico Logitech G915")
				    .precio(210000)
				    .descripcion("Teclado inalámbrico mecánico de bajo perfil con retroiluminación RGB")
				    .stock(15)
				    .build();

				Producto producto3 = Producto.builder()
				    .nombre("Mouse Ergonómico Logitech MX Master 3")
				    .precio(145000)
				    .descripcion("Mouse inalámbrico con diseño ergonómico, ideal para trabajo prolongado")
				    .stock(20)
				    .build();

				Producto producto4 = Producto.builder()
				    .nombre("Silla Ergonómica Homestool")
				    .precio(250000)
				    .descripcion("Silla ejecutiva ergonómica con soporte lumbar y apoyabrazos ajustables")
				    .stock(12)
				    .build();

				Producto producto5 = Producto.builder()
				    .nombre("Monitor ultrawide LG 34WN80C")
				    .precio(620000)
				    .descripcion("Monitor de 34 pulgadas ultrawide QHD con USB-C y tecnología IPS")
				    .stock(8)
				    .build();

				Producto producto6 = Producto.builder()
				    .nombre("Auriculares Gamer Sony WH-1000XM5")
				    .precio(390000)
				    .descripcion("Auriculares con cancelación de ruido activa, bluetooth y micrófono integrado")
				    .stock(18)
				    .build();

				Producto producto7 = Producto.builder()
				    .nombre("Brazo Articulado para Monitor Ergotron LX")
				    .precio(135000)
				    .descripcion("Soporte ajustable premium para monitores hasta 34 pulgadas")
				    .stock(10)
				    .build();

				Producto producto8 = Producto.builder()
				    .nombre("Tiras LED Govee")
				    .precio(45000)
				    .descripcion("Luces LED inteligentes RGB con control desde app móvil")
				    .stock(30)
				    .build();

				Producto producto9 = Producto.builder()
				    .nombre("PC Armada Ryzen 9 9950X3D | 32GB DDR5 | 1TB NVMe")
				    .precio(1890000)
				    .descripcion("PC de alta gama para desarrollo y gaming extremo, con GPU RTX 4080")
				    .stock(5)
				    .build();

				Producto producto10 = Producto.builder()
				    .nombre("Pack de 2 cuadros desarrollador Front-End / Back-End")
				    .precio(30000)
				    .descripcion("Decoración temática para espacios de trabajo de desarrolladores")
				    .stock(25)
				    .build();

			
			Cliente cliente1 = Cliente.builder()
				    .nombre("Imanol")
				    .apellido("Peralta")
				    .domicilio("25 De Mayo 1973, Corrientes, Argentina")
				    .codigoPostal(3500)
				    .email("imanolaugusto18@gmail.com")
				    .dni(40818163)
				    .telefono(3735636568L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente2 = Cliente.builder()
				    .nombre("Lucía")
				    .apellido("Gómez")
				    .domicilio("San Martín 1024, Resistencia, Chaco")
				    .codigoPostal(3600)
				    .email("lucia.gomez@gmail.com")
				    .dni(40123456)
				    .telefono(3624789123L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente3 = Cliente.builder()
				    .nombre("Martín")
				    .apellido("Rodríguez")
				    .domicilio("Belgrano 854, Formosa")
				    .codigoPostal(3700)
				    .email("martinr@hotmail.com")
				    .dni(39876543)
				    .telefono(3701234567L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente4 = Cliente.builder()
				    .nombre("Camila")
				    .apellido("López")
				    .domicilio("Av. Rivadavia 300, Buenos Aires")
				    .codigoPostal(1000)
				    .email("camilopez@yahoo.com")
				    .dni(42345678)
				    .telefono(1145637890L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente5 = Cliente.builder()
				    .nombre("Juan")
				    .apellido("Fernández")
				    .domicilio("Sarmiento 999, Mendoza")
				    .codigoPostal(5500)
				    .email("juan.fer@gmail.com")
				    .dni(41234567)
				    .telefono(2613344556L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente6 = Cliente.builder()
				    .nombre("Sofía")
				    .apellido("Martínez")
				    .domicilio("Maipú 455, Córdoba")
				    .codigoPostal(5000)
				    .email("sofi.martinez@gmail.com")
				    .dni(41789456)
				    .telefono(3517896541L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente7 = Cliente.builder()
				    .nombre("Diego")
				    .apellido("Sosa")
				    .domicilio("Italia 1830, Salta")
				    .codigoPostal(4400)
				    .email("dsosa@gmail.com")
				    .dni(39001234)
				    .telefono(3876677889L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente8 = Cliente.builder()
				    .nombre("Florencia")
				    .apellido("Torres")
				    .domicilio("Mitre 77, Tucumán")
				    .codigoPostal(4000)
				    .email("flor.torres@gmail.com")
				    .dni(40567891)
				    .telefono(3814455667L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente9 = Cliente.builder()
				    .nombre("Carlos")
				    .apellido("Ramírez")
				    .domicilio("España 1880, Santa Fe")
				    .codigoPostal(3000)
				    .email("cramirez@outlook.com")
				    .dni(42233445)
				    .telefono(3427788990L)
				    .createdAt(LocalDateTime.now())
				    .build();

				Cliente cliente10 = Cliente.builder()
				    .nombre("Valentina")
				    .apellido("Morales")
				    .domicilio("Av. Libertador 1200, San Juan")
				    .codigoPostal(5400)
				    .email("valenmorales@gmail.com")
				    .dni(41889900)
				    .telefono(2645566778L)
				    .createdAt(LocalDateTime.now())
				    .build();


			dao.persistirProducto(producto1);
			dao.persistirProducto(producto2);
			dao.persistirProducto(producto3);
			dao.persistirProducto(producto4);
			dao.persistirProducto(producto5);
			dao.persistirProducto(producto6);
			dao.persistirProducto(producto7);
			dao.persistirProducto(producto8);
			dao.persistirProducto(producto9);
			dao.persistirProducto(producto10);
			
			dao.persistirCliente(cliente1);
			dao.persistirCliente(cliente2);
			dao.persistirCliente(cliente3);
			dao.persistirCliente(cliente4);
			dao.persistirCliente(cliente5);
			dao.persistirCliente(cliente6);
			dao.persistirCliente(cliente7);
			dao.persistirCliente(cliente8);
			dao.persistirCliente(cliente9);
			dao.persistirCliente(cliente10);
			
		} catch(Exception err) {
			err.getMessage();
		}
		
		
	}

	
}
