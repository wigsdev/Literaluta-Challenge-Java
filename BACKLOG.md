# Backlog del Proyecto: Challenge Literalura

## HU 00: Crear el repositorio de tu proyecto en GitHub

**Etiquetas:** `Git/GitHub`

### Descripción
Git y GitHub son herramientas muy útiles para cualquier desarrollador, por lo que deberías acostumbrarte a trabajar con ellas.

En este desafío queremos proponerte que el primer paso a realizar sea la creación de este repositorio en GitHub, aunque aún no hayas desarrollado ningún código. Lo importante es que tengas al menos una carpeta específica para tu proyecto y puedas actualizarlo gradualmente. 

**Nota importante sobre el README:**
Vale la pena destacar que en esta oportunidad no podremos ver nuestro proyecto funcionando con GitHub Pages. Sin embargo, tenemos un desafío diferente: **usemos nuestro `README.md` para dejar bien detalladas las funcionalidades de nuestro sistema, capturas de pantalla e inclusive un video de tu aplicación funcionando**. De esta manera aún conseguirás mostrar tu proyecto a la comunidad 😄

---

## HU 01: Configurando el entorno Java y Spring

**Etiquetas:** `Java`, `Configuración del entorno`, `Spring`

### Descripción
En esta primera fase, nos sumergiremos en la configuración del entorno de desarrollo Java para nuestro desafío de construcción del LiterAlura en un proyecto Spring.

### Requisitos del entorno
Asegúrate de contar con los siguientes programas, archivos y versiones instalados:
- **Java JDK:** Versión 25 (LTS) o superior.
- **Maven:** Versión 4 en adelante.
- **Postgres:** Versión 16 en adelante.
- **IDE:** IntelliJ IDEA (opcional) u otro de preferencia.

### Configuración del Proyecto (Spring Initializr)
- **Generador:** [Spring Initializr](https://start.spring.io/)
- **Lenguaje:** Java (versión 25)
- **Tipo de proyecto:** Maven (Initializr utiliza la versión 4)
- **Spring Boot:** Versión 3.3.0 o superior (estable)
- **Empaquetado:** Proyecto en JAR
- **Dependencias a incluir:**
  - `Spring Data JPA`
  - `Postgres Driver`

---

### Checklist de finalización
- [x] Validar variables de entorno de Java JDK (v25+).
- [x] Validar variables de entorno de Maven (v4+).
- [x] Crear base de datos PostgreSQL local (v16+).
- [x] Generar el proyecto base estructurado desde Spring Initializr con los requerimientos exactos indicados.
- [x] Importar el proyecto generado al IDE (ej: IntelliJ IDEA).
- [x] Verificar que el proyecto compila y levanta correctamente al ejecutarlo.

---

## HU 02: Conociendo la API para traer datos

**Etiquetas:** `API`, `Configuración del entorno`

### Descripción
La API Gutendex es un catálogo de información de más de 70.000 libros presentes en Project Gutenberg (biblioteca en línea y gratuita).

En este paso crucial, es fundamental comprender mejor la API de los libros, revisar su documentación y aprender cómo realizar las consultas en la API. En este desafío no es necesario obtener una clave de acceso, solo realizar consultas como se describe en el sitio web oficial.

Asegúrate de seguir cuidadosamente las instrucciones proporcionadas por la API Gutendex.

### Referencias y Enlaces
- **Enlace de API:** [Gutendex](https://gutendex.com/)
- **Repositorio de API:** [GitHub - garethbjohnson/gutendex: Web API for Project Gutenberg ebook metadata](https://github.com/garethbjohnson/gutendex) *(Dejamos el código oficial si tienes curiosidad sobre cómo se hizo)*

---

### Checklist de finalización
- [x] Revisar la documentación o el sitio oficial de la API de Gutendex.
- [x] Aprender cómo realizar consultas a la API (estructura de los endpoints, paginación, filtros).
- [x] Realizar pruebas de consultas HTTP a la API (por ejemplo, con herramientas como Postman, Hoppscotch o desde el navegador) para ver la estructura de respuesta (JSON).

---

## HU 03: Construyendo una solicitud de API

**Etiquetas:** `Consumo de la API`, `Java`

### Descripción
En esta fase del desafío, nos enfocaremos en escribir el código en Java necesario para interactuar con la API de Gutendex utilizando las clases HTTP introducidas en Java 11.

- **Construyendo el Cliente para Solicitudes (`HttpClient`)**:
  Emplearemos la clase `HttpClient` para realizar solicitudes a la API de libros y obtener datos esenciales. El uso de `HttpClient` en Java facilita la conexión y la obtención de respuestas de manera eficiente. Proporciona una base sólida para realizar operaciones HTTP de manera estructurada y versátil. 

- **Construyendo la Solicitud (`HttpRequest`)**:
  Nos sumergiremos en el uso de la clase `HttpRequest` para configurar y personalizar nuestras solicitudes a la API. Esta nos brinda un control detallado sobre los parámetros de nuestras solicitudes (como URIs, headers, métodos GET), esencial para adaptar la consulta a nuestras necesidades específicas. 

- **Construyendo la Respuesta (`HttpResponse`)**:
  Finalmente, nos enfocaremos en el uso de la interfaz `HttpResponse` para gestionar las respuestas recibidas. Esta ofrece una estructura que permite analizar y acceder a los diferentes elementos de una respuesta HTTP (códigos de estado, encabezados y el cuerpo de la respuesta, que normalmente se presenta en formato JSON).

---

### Checklist de finalización
- [x] Crear un componente/servicio en Java dedicado al consumo de APIs.
- [x] Instanciar un `HttpClient`.
- [x] Construir un `HttpRequest` apuntando a la URL de Gutendex (ej. buscar un libro por título).
- [x] Enviar la solicitud y recibir un `HttpResponse`.
- [x] Imprimir o capturar el `body` de la respuesta (JSON) en la consola para validar que funciona la conexión.

---

## HU 04: Analizando la respuesta en formato JSON

**Etiquetas:** `Java`, `Jackson`

### Descripción
En la cuarta fase de nuestro desafío, nos sumergimos en el análisis de la respuesta JSON utilizando la biblioteca **Jackson** en Java. La manipulación de datos JSON es esencial, ya que la mayoría de las respuestas de las API se presentan en este formato.

Para facilitar el análisis de los datos que se obtendrán de la API, recomendamos el uso del sitio de API para realizar consulta de libros o autores.

Con la biblioteca Jackson, puedes realizar el mapeo eficiente de los datos JSON a objetos Java, facilitando así la extracción y manipulación de la información necesaria.

**Nota:** No olvides agregar la biblioteca Jackson al proyecto como dependencia del archivo `pom.xml` (sugerimos usar la versión 2.17 o la última estable compatible). 
Recuerda utilizar las clases proporcionadas por Jackson, como `ObjectMapper`, para acceder a las distintas propiedades de la respuesta JSON.

---

### Checklist de finalización
- [x] Incorporar la dependencia de Jackson (v2.17+) en el `pom.xml`.
- [x] Definir los Records/Clases (DTOs) en Java que representen la estructura del JSON que devuelve Gutendex.
- [x] Utilizar la clase `ObjectMapper` de Jackson para convertir (deserializar) la cadena JSON obtenida de la API en objetos Java.
- [x] Validar que los datos se mapean correctamente y pueden ser mostrados en consola accediendo a las propiedades del objeto Java.

---

## HU 05: Convirtiendo los datos

**Etiquetas:** `Java`

### Descripción
En esta etapa, llevaremos a cabo las conversiones con los datos de libros y autores, ahora que contamos con la información en nuestro poder. 🙌

Experimenta utilizando clases Java para recibir los datos obtenidos mediante la API, transformar los atributos del cuerpo JSON a una clase Java y mostrar los resultados.

Es fundamental crear métodos específicos para manejar estos datos, lo que hará que el código sea más modular y fácil de entender, como `getters`, `setters` y `toString()`.

**Nota importante:** No olvides utilizar las anotaciones `@JsonIgnoreProperties` y `@JsonAlias` (de Jackson) para mapear correctamente y obtener solo los atributos que deseamos del cuerpo de respuesta JSON.

---

### Checklist de finalización
- [x] Mapear los datos de las respuestas a Clases Base (Ej: `Libro`, `Autor`).
- [x] Usar `@JsonAlias` para asociar las claves del JSON con los nombres de variables en Java (si difieren).
- [x] Usar `@JsonIgnoreProperties(ignoreUnknown = true)` para ignorar los datos del JSON que no necesitamos en nuestro modelo.
- [x] Implementar métodos `toString()` amigables para la visualización de datos.
- [x] Comprobar que los objetos instanciados contienen los datos correctos tras la deserialización.

---

## HU 06: Interactuando con el usuario

**Etiquetas:** `Java`, `Pruebas finales`

### Descripción
En esta etapa del desafío, nos adentraremos en la interacción con el usuario. El método `main` (o clase principal de Spring Boot) debe implementar la interfaz `CommandLineRunner` y en su método `run()` deberás llamar a un método para exhibir el menú.

En este método, debes crear un bucle (ej. `while`) para presentar a tu usuario las opciones numéricas de inserción y consulta de libros y autores. El usuario deberá seleccionar un número que corresponderá a la opción numérica, proporcionando los datos que la aplicación recibirá utilizando la clase `Scanner` para capturar la entrada del usuario.

Recuerda exhibirle al usuario la información que ha demandado e informarle cuando hay un error o dato inválido. Además, es fundamental realizar pruebas exhaustivas para garantizar el correcto funcionamiento del programa, simulando diversas situaciones para identificar y corregir posibles errores.

---

### Checklist de finalización
- [x] Implementar `CommandLineRunner` en la clase principal de la app Spring Boot.
- [x] Instanciar un objeto `Scanner` para leer las entradas de la cónsola.
- [x] Diseñar y mostrar un menú interactivo ciclico (con un `while` o `do-while`).
- [x] Desarrollar un bloque condicional (ej. `switch-case`) que administre las opciones numéricas del menú.
- [x] Mostrar mensajes claros de salida y manejar de forma controlada los posibles errores de entrada de datos (ej. usuario escribe una letra en lugar de número).
- [x] Realizar pruebas manuales navegando por el menú para comprobar que no haya ciclos infinitos ni cierres inesperados.

---

## HU 07: Consultar libros

**Etiquetas:** `API`, `Java`, `Libro`

### Descripción
Bien, ahora vamos a empezar a construir nuestro catálogo de libros y autores. En esta etapa realizaremos consultas de libros en la API utilizando la URL base: `https://gutendex.com/books/`. 

Realizaremos la búsqueda por título del libro en la API, reteniendo únicamente el **primer resultado obtenido**.

Cada libro dentro de nuestro sistema debe contemplar y guardar (al menos) los siguientes atributos:
- Título
- Autor
- Idiomas
- Número de Descargas

Con esta funcionalidad lista, se requerirá presentar en la consola un **listado de todos los libros que ya fueron buscados** previamente.

Adicionalmente, se debe posibilitar al usuario ver un listado con base en el idioma en que uno o más libros fueron escritos, apoyándonos en *derived queries* de Spring Data JPA. **Nota para simplificar:** Vamos a considerar que un libro posee **solo un idioma**. Es decir, nos quedaremos únicamente con el primer idioma de la lista enviada por la API.

**Funcionalidades obligatorias requeridas en esta historia:**
1. Búsqueda de libro por título a través de la API.
2. Listado de todos los libros (almacenados localmente).

---

### Checklist de finalización
- [x] Configurar Entidad `@Entity` Libro en JPA con los atributos necesarios (título, autor, idioma único, descargas).
- [x] Implementar la búsqueda de un libro por su título hacia la API de Gutendex.
- [x] Extraer el primer resultado de la lista de libros devuelta por la API y guardar solo su primer idioma.
- [x] Guardar el libro consultado en la base de datos PostgreSQL usando un `Repository`.
- [ ] Implementar y probar la funcionalidad del menú: "Lista de todos los libros buscados/guardados".
- [ ] Implementar *derived query* en Repository para buscar libros por Idioma localmente.

---

## HU 08: Consultar autores

**Etiquetas:** `API`, `Java`, `Autor`

### Descripción
Como podemos ver en el sitio web de la API, cada libro tiene datos relacionados con sus autores, en este caso el cuerpo del JSON recibe una lista de autores por libro. Cada autor tiene (al menos) tres características fundamentales:
- Nombre
- Año de nacimiento
- Año de fallecimiento

Al igual que con el modelo de Libro, vamos a considerar que un libro posee **solo un autor** para que las consultas sean más comprensibles y sencillas (nos quedaremos solo con el primer resultado de autor del array).

Al guardar los datos de los autores en conjunto con los libros, se tendrá la opción de ver el listado de los autores ya almacenados en la base de datos local.

Además, pensando en los años de nacimiento y fallecimiento, es posible incluir una búsqueda avanzada que permita listar los autores vivos en un determinado año usando JPA.

**Funcionalidades obligatorias requeridas:**
1. Lista de autores (historizados de las búsquedas previas).
2. Listar autores vivos en determinado año ingresado por el usuario.

---

### Checklist de finalización
- [x] Configurar Entidad `@Entity` Autor en JPA con los atributos (nombre, año nacimiento, año fallecimiento).
- [x] Establecer la relación (`@OneToMany` o `@ManyToMany` simplificada a un autor por libro -> `@ManyToOne` en Libro) entre las entidades `Libro` y `Autor`.
- [x] Extraer el primer autor detectado en el JSON de Gutendex y mapearlo al objeto en Java para guardarlo/asociarlo al Libro.
- [x] Guardar en Base de Datos (PostgreSQL) garantizando que no se dupliquen autores si buscamos dos libros del mismo autor.
- [x] Implementar y probar funcionalidad del menú: "Lista de todos los autores (locales)".
- [x] Implementar *derived query* en Repository de Autor (ej: `findByAñoNacimientoLessThanEqualAndAñoFallecimientoGreaterThanEqual`) o su `@Query(JPQL)` equivalente, para buscar los autores vivos en un determinado año.
- [x] Implementar y probar la funcionalidad interactiva en el menú para autores vivos por año.

---

## HU 09: Persistencia de datos

**Etiquetas:** `Base de datos`, `Java`

### Descripción
Ha llegado el momento de enfocarnos en construir una base de datos, con tablas y atributos relacionados a nuestros objetos de interés: `Libro` y `Autor`.

En este desafío vamos a utilizar la base de datos llamada **PostgreSQL**, una de las bases de datos open source más utilizadas en el mercado (si se tiene más experiencia con MySQL se puede usar sin problemas).

Se sugiere la creación de clases de entidad/modelo para `Libro` y `Autor`, así como también sus respectivas interfaces de repositorio para manejar inserción y consultas en la base de datos.
No olvides usar las anotaciones correctas (ej. `@Entity`, `@Id`, `@GeneratedValue`) y extender de `JpaRepository` en las interfaces. Spring Data JPA manejará las funciones necesarias para la persistencia.

Al crear los repositorios, recuerda realizar la conversión de los atributos del JSON obtenido de la API hacia un objeto Java de entidad.

**IMPORTANTE:** Al insertar un libro en la base, también deberás insertar/asegurar su autor y así mantener una relación entre los dos objetos vía atributo de identificación (`ID`).

---

### Checklist de finalización
- [x] Verificar conexión a BD PostgreSQL en `application.properties`.
- [x] Crear las clases modelo/entidad `@Entity` `Libro` y `Autor` con la información deserializada.
- [x] Configurar correctamente las relaciones JPA (`@ManyToOne`, `@OneToMany`) y el comportamiento de las llaves primarias (`@Id`).
- [x] Crear las interfaces `LibroRepository` y `AutorRepository` extendiendo de `JpaRepository`.
- [x] Construir lógica para evitar la inserción de autores y/o libros duplicados (Manejo de Optional o validación manual extra antes de `.save()`).
- [x] Asegurarse de realizar la persistencia en "cascada" (CascadeType/Persist/Merge) o guardar primero el autor y luego asignarlo al libro antes de guardarlo.

---

## HU 10: Listando libros por idiomas

**Etiquetas:** `Base de datos`, `Java`, `Libro`

### Descripción
Una vez que ya tienes libros y autores guardados en tu base de datos, ¿qué tal exhibir estadísticas sobre ellos a tu usuario? Aprovecha los recursos de Streams de Java y *derived queries* para brindar a tu usuario estadísticas sobre la cantidad de libros en un determinado idioma en la base de datos.

No es necesario crear opciones para todos los idiomas de la API. Elija como **mínimo dos idiomas** (Por ejemplo: Español `es` e Inglés `en`).

**Funcionalidad obligatoria:**
- Exhibir cantidad de libros en un determinado idioma.

---

### Checklist de finalización
- [x] Implementar opción en el menú consultando los idiomas habilitados al usuario.
- [x] Realizar una *derived query* en el `LibroRepository` (ej. `countByIdioma(String idioma)` o `findByIdioma(String idioma)`).
- [x] Procesar y mostrar al usuario en la consola cuántos o cuáles libros se tienen registrados bajo ese idioma elegido.
- [x] Manejar opción de error si un usuario introduce un idioma inválido.

---

## HU 11: Listando autores vivos en determinado año

**Etiquetas:** `Base de datos`, `Autor`

### Descripción
Ahora que ya has avanzado en el uso de la base de datos, te invitamos a consolidar el método para listar los autores vivos en un determinado año (comentado previamente en la HU 08). Para eso, debes utilizar las *derived queries* para recuperar todos los autores que estaban vivos en el año que el usuario te informará.

Recuerda hacer pruebas exhaustivas para recibir adecuadamente los datos numéricos (años reales, no strings ni negativos), porque esto te ayudará a lidiar con los valores inválidos que el usuario pueda ingresar en el sistema.

---

### Checklist de finalización
- [x] Verificar o ajustar la *derived query* en `AutorRepository` que busca autores vivos en un año determinado (Año de muerte mayor igual al año buscado Y Año de nacimiento menor igual al año buscado).
- [x] Capturar el dato numérico del año en la consola mediante `Scanner`.
- [x] Validar con `try-catch` o lógica condicional que el usuario haya escrito realmente un número válido y no letras.
- [x] Mostrar adecuadamente la lista de autores vivos rescatada por JPA, o un mensaje amigable si la base de datos no tiene autores vivos en ese año específico.

---

## HU 12: Haz un README

**Etiquetas:** `Git/GitHub`, `README`

### Descripción
Uno de los pasos más importantes al participar en una selección de trabajo es resolver un desafío propuesto por la empresa con la información de la resolución, y generalmente esto debe estar en el README (archivo con extensión `.md` con la descripción del proyecto).

Ahora que estamos en la recta final del programa ONE, comencemos a desarrollar archivos README asombrosos para nuestros últimos desafíos.

**Referencia:**
- Cómo escribir un README increíble en tu Github | Alura Cursos Online

---

### Checklist de finalización
- [x] Documentar el nombre del proyecto y dar un contexto claro (Literalura).
- [x] Explicar cuáles tecnologías, frameworks y librerías externas se utilizaron (Java 25, Spring Boot, Spring Data JPA, PostgreSQL, Jackson).
- [x] Describir las características y funcionalidades principales de la aplicación.
- [x] Proveer instrucciones claras de cómo levantar y ejecutar el proyecto localmente.
- [ ] (Opcional pero muy recomendado) Insertar capturas de pantalla, GIFs o video del menú funcionando en la consola.

---

## HU 13: Terminar el Curso

**Etiquetas:** `Envio del Enlace`

### Descripción
Ahora que tu proyecto ya está listo, recuerda enviar el enlace del repositorio en GitHub al curso del challenge y descargar tu certificado.

**Enlace de entrega:**
- [Entrega del Challenge Literalura](https://app.aluracursos.com/course/challenge-spring-boot-literalura/task/87631)

---

### Checklist de finalización
- [x] Asegurarse que todos los *commits* están subidos al repositorio remoto (`git push`).
- [x] Comprobar que el repositorio sea Público o accesible para el equipo revisor.
- [x] Ingresar al enlace proporcionado en la plataforma de Alura.
- [x] Pegar el link del repositorio GitHub.
- [x] ¡Descargar tu certificado de conclusión! 🎉

---

## Extras (Opcionales)

**Etiquetas:** `Base de datos`, `Java`, `Opcional`

### Descripción
¡Has finalizado tu proyecto! En caso de que quieras desafiarte aún más y proporcionar a los usuarios una experiencia más rica y personalizada, hay diversas funcionalidades interesantes que puedes explorar:

- **Generando estadísticas:** Recordando la clase `DoubleSummaryStatistics`, utilizada para obtener datos estadísticos de un objeto Java. Es posible obtener dichos datos ya sea de consultas de la API o base de datos (por ejemplo, el promedio de descargas de los libros registrados).
- **Top 10 libros más descargados:** Así como se vio trabajando con Lambdas, Streams y Spring Framework, es posible presentar los datos de los 10 libros más descargados, consultando directamente en la API o en la base de datos de los guardados.
- **Buscar autor por nombre:** Es posible realizar la búsqueda de libro o autor con la consulta hecha con `search?` en la API (p.ej `gutendex.com/books/?search=tolkien`). El desafío extra es **realizar la consulta por nombre de autor en la BD local** si ya los has guardado.
- **Listar autores con otras consultas:** Implementar otras consultas con los atributos de año de nacimiento y fallecimiento de los autores usando JPA *Derived Queries* (por ejemplo, aquellos que nacieron antes de cierto año o listar a todos los autores que siguen con vida actualmente).

¡Desafíate a implementar estas características y convierte tu proyecto en una herramienta aún más poderosa y versátil!

---

### Checklist de finalización (Extras)
- [x] Utilizar `DoubleSummaryStatistics` para estadísticas (Ej: PromedioDescargas / DescargasMaximas de la BD).
- [x] Desarrollar menú u opción para ver el Top 10 de libros.
- [x] Implementar la consulta a la BD (Repository) que busque `Autor` por partes de su nombre (usando `findByNombreContainingIgnoreCase`).
- [x] Implementar y ensayar otras consultas personalizadas requeridas sobre el repositorio de JPA (Ej. Autores cuyo año de fallecimiento sea `null` o buscar en rango de años específico).
