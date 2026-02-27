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

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.InputMismatchException;
import java.util.List;
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
                    6 - Generar estadísticas de descargas (Extra)
                    7 - Top 10 libros más descargados (Extra)
                    8 - Buscar autor por nombre (Extra)
                    9 - Buscar autores contemporáneos (Extra)

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
                        mostrarLibrosBuscados();
                        break;
                    case 3:
                        mostrarAutoresGuardados();
                        break;
                    case 4:
                        buscarAutoresVivosPorAnio();
                        break;
                    case 5:
                        buscarLibrosPorIdioma();
                        break;
                    case 6:
                        generarEstadisticas();
                        break;
                    case 7:
                        buscarTop10Libros();
                        break;
                    case 8:
                        buscarAutorPorNombre();
                        break;
                    case 9:
                        buscarAutoresContemporaneos();
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

    private void buscarLibrosPorIdioma() {
        System.out.println("""
                Ingrese el idioma para buscar los libros:
                es - español
                en - inglés
                fr - francés
                pt - portugués
                """);
        var idioma = teclado.nextLine().toLowerCase();

        List<Libro> librosPorIdioma = libroRepository.findByIdioma(idioma);

        if (librosPorIdioma.isEmpty()) {
            System.out.println("❌ No se encontraron libros registrados en ese idioma.");
        } else {
            System.out.println("\n📚 *** LIBROS EN IDIOMA '" + idioma.toUpperCase() + "' ***");
            librosPorIdioma.forEach(System.out::println);
            System.out.println("\n📊 Cantidad total de libros encontrados en ese idioma: " + librosPorIdioma.size());
        }
    }

    private void generarEstadisticas() {
        var libros = libroRepository.findAll();

        if (libros.isEmpty()) {
            System.out.println("❌ No hay libros registrados en la base de datos para generar estadísticas.");
            return;
        }

        System.out.println("\n📊 *** ESTADÍSTICAS DE DESCARGAS (Registros Locales) ***");
        DoubleSummaryStatistics est = libros.stream()
                .filter(l -> l.getNumeroDeDescargas() != null && l.getNumeroDeDescargas() > 0)
                .mapToDouble(Libro::getNumeroDeDescargas)
                .summaryStatistics();

        System.out.println("Total de libros evaluados: " + est.getCount());
        System.out.println("Promedio de descargas: " + Math.round(est.getAverage() * 100.0) / 100.0);
        System.out.println("Mayor cantidad de descargas: " + est.getMax());
        System.out.println("Menor cantidad de descargas: " + est.getMin());
        System.out.println("**********************************************************\n");
    }

    private void buscarTop10Libros() {
        var libros = libroRepository.findAll();

        if (libros.isEmpty()) {
            System.out.println("❌ No hay libros registrados en la base de datos.");
            return;
        }

        System.out.println("\n🏆 *** TOP 10 LIBROS MÁS DESCARGADOS ***");
        libros.stream()
                .filter(l -> l.getNumeroDeDescargas() != null)
                .sorted(Comparator.comparing(Libro::getNumeroDeDescargas).reversed())
                .limit(10)
                .forEach(l -> System.out
                        .println("▶ " + l.getTitulo() + " (" + l.getNumeroDeDescargas() + " descargas)"));
        System.out.println("*****************************************\n");
    }

    private void buscarAutoresVivosPorAnio() {
        System.out.println("Ingrese el año vivo de autor(es) que desea buscar:");
        try {
            var anio = teclado.nextInt();
            teclado.nextLine(); // Consumir buffer

            List<Autor> autoresVivos = autorRepository
                    .findByFechaDeNacimientoLessThanEqualAndFechaDeFallecimientoGreaterThanEqual(anio, anio);

            if (autoresVivos.isEmpty()) {
                System.out.println("❌ No se encontraron autores vivos en nuestra base de datos para el año " + anio);
            } else {
                System.out.println("\n✍️ *** AUTORES VIVOS EN " + anio + " ***");
                autoresVivos.forEach(System.out::println);
            }
        } catch (InputMismatchException e) {
            System.out.println("⚠️ Entrada inválida. Por favor, introduzca un año en formato numérico (ej: 1940).");
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void buscarAutorPorNombre() {
        System.out.println("Escriba el nombre (o parte del nombre) del autor literario a buscar en el sistema local:");
        var parteNombre = teclado.nextLine();

        List<Autor> autoresCoincidentes = autorRepository.findByNombreContainingIgnoreCase(parteNombre);

        if (autoresCoincidentes.isEmpty()) {
            System.out.println("❌ No hallamos ningún autor guardado cuyo nombre contenga '" + parteNombre + "'.");
        } else {
            System.out.println("\n🔍 *** COINCIDENCIAS LOCALES ENCONTRADAS ***");
            autoresCoincidentes.forEach(System.out::println);
            System.out.println("******************************************\n");
        }
    }

    private void buscarAutoresContemporaneos() {
        System.out.println("\nBuscando autores contemporáneos (fecha de fallecimiento desconocida o nula)...");
        List<Autor> contemporaneos = autorRepository.findByFechaDeFallecimientoIsNull();

        if (contemporaneos.isEmpty()) {
            System.out.println("❌ No se encontraron autores contemporáneos registrados.");
        } else {
            System.out.println("\n🌟 *** AUTORES CONTEMPORÁNEOS ***");
            contemporaneos.forEach(System.out::println);
            System.out.println("***********************************\n");
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

    private void mostrarLibrosBuscados() {
        var libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("❌ No hay libros registrados en la base de datos aún.");
        } else {
            System.out.println("\n📚 *** LIBROS REGISTRADOS ***");
            libros.forEach(System.out::println);
        }
    }

    private void mostrarAutoresGuardados() {
        var autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("❌ No hay autores registrados en la base de datos aún.");
        } else {
            System.out.println("\n✍️ *** AUTORES REGISTRADOS ***");
            autores.forEach(System.out::println);
        }
    }
}
