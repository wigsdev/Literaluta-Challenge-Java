package com.aluralatam.literalura;

import com.aluralatam.literalura.service.ConsumoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ConsumoAPI consumoAPI;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var json = consumoAPI.obtenerDatos("https://gutendex.com/books/?search=cien+anos+de+soledad");
		System.out.println("*************** RESPUESTA DE LA API GUTENDEX ***************");
		System.out.println(json);
		System.out.println("************************************************************");
	}
}
