package com.aluralatam.literalura.principal;

import com.aluralatam.literalura.model.Autor;
import com.aluralatam.literalura.model.DatosAutor;
import com.aluralatam.literalura.model.DatosGutendex;
import com.aluralatam.literalura.model.DatosLibro;
import com.aluralatam.literalura.model.Libro;
import com.aluralatam.literalura.repository.AutorRepository;
import com.aluralatam.literalura.repository.LibroRepository;
import com.aluralatam.literalura.service.ConsumoAPI;
import com.aluralatam.literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    \n
                    ==========================================
                    📚 BIENVENIDO A LITERALURA 📚
                    ==========================================
                    Elija una opción válida del menú:

                    1 - Buscar libro por título
                    2 - Listar todos los libros buscados
                    3 - Listar autores guardados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma

                    0 - Salir
                    ==========================================
                    """;
            System.out.println(menu);
            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        System.out.println("Opción 2 en construcción...");
                        break;
                    case 3:
                        System.out.println("Opción 3 en construcción...");
                        break;
                    case 4:
                        System.out.println("Opción 4 en construcción...");
                        break;
                    case 5:
                        System.out.println("Opción 5 en construcción...");
                        break;
                    case 0:
                        System.out.println("Cerrando la aplicación... ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("⚠️ Opción inválida. Por favor, introduzca un número del menú.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrada inválida. Por favor, introduzca un número entero (0-5).");
                teclado.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar:");
        var titulo = teclado.nextLine();

        // 1. Verificar si ya existe en la BD local
        Optional<Libro> libroLocal = libroRepository.findByTituloIgnoreCase(titulo);
        if (libroLocal.isPresent()) {
            System.out.println("El libro ya existe en la base de datos local:");
            System.out.println(libroLocal.get());
            return;
        }

        // 2. Buscar en la API Gutendex
        var json = consumoAPI.obtenerDatos(URL_BASE + titulo.replace(" ", "%20"));
        var datosGutendex = conversor.obtenerDatos(json, DatosGutendex.class);

        if (datosGutendex.resultados().isEmpty()) {
            System.out.println("⚠️ Libro no encontrado en la API de Gutendex.");
            return;
        }

        // 3. Tomar el primer libro
        DatosLibro datosLibro = datosGutendex.resultados().get(0);
        Libro libro = new Libro(datosLibro);

        // 4. Mapear y guardar el Autor si existe
        if (!datosLibro.autores().isEmpty()) {
            DatosAutor datosAutor = datosLibro.autores().get(0);
            Autor autor = autorRepository.findByNombreIgnoreCase(datosAutor.nombre())
                    .orElseGet(() -> autorRepository.save(new Autor(datosAutor)));
            libro.setAutor(autor);
        }

        // 5. Guardar el Libro
        libroRepository.save(libro);
        System.out.println("\n✅ Libro guardado exitosamente: ");
        System.out.println(libro);
    }
}
