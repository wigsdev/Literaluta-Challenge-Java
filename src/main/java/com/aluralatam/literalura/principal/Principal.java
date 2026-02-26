package com.aluralatam.literalura.principal;

import com.aluralatam.literalura.service.ConsumoAPI;
import com.aluralatam.literalura.service.ConvierteDatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

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
                        System.out.println("Opción 1 en construcción...");
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
}
