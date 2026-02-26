# Ciclo de Vida del Desarrollo de Software (SDLC) - Literalura

El proceso que estamos siguiendo para el **Challenge Literalura** se enmarca en un proceso estructurado del Ciclo de Vida del Desarrollo de Software (SDLC, por sus siglas en inglés) que consta de 7 fases clave. 

Nuestra metodología se mapea de la siguiente manera:

## 1. Planificación
En esta fase inicial, extrajimos y comprendimos todos los requisitos brindados por Alura. Formateamos las Historias de Usuario, asignamos etiquetas, construimos el **Backlog del Proyecto** y definimos las metas a corto plazo (Sprints). Se seleccionaron las tecnologías base: Java 25, Spring Boot 3.3.x, PostgreSQL y Maven.

## 2. Análisis
Se estudió la arquitectura de la API externa (Gutendex). Identificamos qué datos son devueltos por el servidor remoto en formato JSON, cuáles son críticos para nuestra aplicación (Título, Autores, Idiomas, Descargas), y determinamos el modelo de datos más apto para evitar redundancias de autores.

## 3. Diseño
Proyectamos la arquitectura del sistema:
* **Capa de Configuración:** Aplicación Spring Boot CLI vía `CommandLineRunner`.
* **Capa de Comunicación:** Componentes usando `HttpClient` y `Jackson (ObjectMapper)`.
* **Capa de Persistencia:** JPA Repositories con anotaciones de Entidades y de Relacionamiento.
* **Interfaz:** Consola interactiva a base de ciclos transaccionales controlados.

## 4. Desarrollo
Corresponde a la fase de programación (el código puro y duro). Es aquí donde entraremos a satisfacer cada una de las Historias de Usuario:
* Escribir entidades y servicios.
* Realizar peticiones HTTP.
* Enlazar el sistema con PostgreSQL e insertar data.

## 5. Pruebas (QA)
Parte íntegra obligatoria de nuestro documento de "Flujo de trabajo". Cada bloque de código y cada funcionalidad CLI (Menú iterativo) pasará por un filtro de depuración manual para confirmar que reacciona limpiamente frente a "Happy Paths" y "Unhappy Paths" (ingreso de datos erróneo por usuarios).

## 6. Implementación (Despliegue)
Comprende la solidificación del proyecto para que pueda ser ejecutado por terceros (el equipo evaluador). Esto incluyó armar el archivo `README.md` pulido, garantizar la creación del *.jar*, empaquetar en GitHub y documentar las instrucciones necesarias para montar la base de datos local exigida.

## 7. Mantenimiento
Una vez el proyecto base esté construido y en fase Beta, esta etapa contemplará refinamientos basados en las misiones "Extras/Opcionales": 
* Nuevas funciones agregadas modularmente al sistema.
* Mejora en el formato de salida por consola.
* Optimización de nuevas consultas JPA y reparación de posibles Bugs no detectados.
