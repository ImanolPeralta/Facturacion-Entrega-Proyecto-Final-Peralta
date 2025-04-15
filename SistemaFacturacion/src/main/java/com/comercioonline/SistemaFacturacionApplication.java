package com.comercioonline;

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
			
			Producto producto1 = new Producto("Notebook MacBook Pro 4", 1450000, "MacBook Pro con chip M3, pantalla Retina de 14 pulgadas, 16GB RAM, 512GB SSD", 10);
			Producto producto2 = new Producto("Teclado mecánico Logitech G915", 210000, "Teclado inalámbrico mecánico de bajo perfil con retroiluminación RGB", 15);
			Producto producto3 = new Producto("Mouse Ergonómico Logitech MX Master 3", 145000, "Mouse inalámbrico con diseño ergonómico, ideal para trabajo prolongado", 20);
			Producto producto4 = new Producto("Silla Ergonómica Homestool", 250000, "Silla ejecutiva ergonómica con soporte lumbar y apoyabrazos ajustables", 12);
			Producto producto5 = new Producto("Monitor ultrawide LG 34WN80C", 620000, "Monitor de 34 pulgadas ultrawide QHD con USB-C y tecnología IPS", 8);
			Producto producto6 = new Producto("Auriculares Gamer Sony WH-1000XM5", 390000, "Auriculares con cancelación de ruido activa, bluetooth y micrófono integrado", 18);
			Producto producto7 = new Producto("Brazo Articulado para Monitor Ergotron LX", 135000, "Soporte ajustable premium para monitores hasta 34 pulgadas", 10);
			Producto producto8 = new Producto("Tiras LED Govee", 45000, "Luces LED inteligentes RGB con control desde app móvil", 30);
			Producto producto9 = new Producto("PC Armada Ryzen 9 9950X3D | 32GB DDR5 | 1TB NVMe", 1890000, "PC de alta gama para desarrollo y gaming extremo, con GPU RTX 4080", 5);
			Producto producto10 = new Producto("Pack de 2 cuadros desarrollador Front-End / Back-End", 30000, "Decoración temática para espacios de trabajo de desarrolladores", 25);
			
			Cliente cliente1 = new Cliente("Imanol", "Peralta", "25 De Mayo 1973, Corrientes, Argentina", 3500, "imanolaugusto18@gmail.com", 40818163, 3735636568L);
			Cliente cliente2 = new Cliente("Lucía", "Gómez", "San Martín 1024, Resistencia, Chaco", 3600, "lucia.gomez@gmail.com", 40123456, 3624789123L);
			Cliente cliente3 = new Cliente("Martín", "Rodríguez", "Belgrano 854, Formosa", 3700, "martinr@hotmail.com", 39876543, 3701234567L);
			Cliente cliente4 = new Cliente("Camila", "López", "Av. Rivadavia 300, Buenos Aires", 1000, "camilopez@yahoo.com", 42345678, 1145637890L);
			Cliente cliente5 = new Cliente("Juan", "Fernández", "Sarmiento 999, Mendoza", 5500, "juan.fer@gmail.com", 41234567, 2613344556L);
			Cliente cliente6 = new Cliente("Sofía", "Martínez", "Maipú 455, Córdoba", 5000, "sofi.martinez@gmail.com", 41789456, 3517896541L);
			Cliente cliente7 = new Cliente("Diego", "Sosa", "Italia 1830, Salta", 4400, "dsosa@gmail.com", 39001234, 3876677889L);
			Cliente cliente8 = new Cliente("Florencia", "Torres", "Mitre 77, Tucumán", 4000, "flor.torres@gmail.com", 40567891, 3814455667L);
			Cliente cliente9 = new Cliente("Carlos", "Ramírez", "España 1880, Santa Fe", 3000, "cramirez@outlook.com", 42233445, 3427788990L);
			Cliente cliente10 = new Cliente("Valentina", "Morales", "Av. Libertador 1200, San Juan", 5400, "valenmorales@gmail.com", 41889900, 2645566778L);

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
