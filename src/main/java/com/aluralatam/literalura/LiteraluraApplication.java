package com.aluralatam.literalura;

import com.aluralatam.literalura.model.DatosGutendex;
import com.aluralatam.literalura.service.ConsumoAPI;
import com.aluralatam.literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ConsumoAPI consumoAPI;

	@Autowired
	private ConvierteDatos conversor;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var json = consumoAPI.obtenerDatos("https://gutendex.com/books/?search=cien+anos+de+soledad");
		var datos = conversor.obtenerDatos(json, DatosGutendex.class);
		System.out.println("*************** DATOS DESERIALIZADOS ***************");
		System.out.println(datos);
		System.out.println("****************************************************");
	}
}
