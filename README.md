# Literalura: Catálogo Interactivo de Libros 📚

![Literalura Banner](https://img.shields.io/badge/Status-En%20Desarrollo-orange) ![Java](https://img.shields.io/badge/Java-25-red) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3+-green) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)

**Literalura** es un ambicioso desafío de programación que te provee un moderno catálogo de libros administrable desde la terminal. Realiza consultas en tiempo real a una API externa de biblioteca gratuita, extrae valiosa información serializada y nutre a nuestra propia base de datos local para ejecutar analíticas y búsquedas potentes.

🔗 **Enlace oficial del desafío:** [Challenge Spring Boot - Literalura](https://app.aluracursos.com/course/challenge-spring-boot-literalura)

---

## 🚀 Características Principales

Esta aplicación de consola impulsada por **Spring Boot CommandLineRunner** permite al usuario interactuar a través de un menú textual que ofrece, entre otras, las siguientes capacidades:

1. **Búsqueda Avanzada de Libros en API Remota:** Rastrea cualquier libro por su título utilizando el motor gratuito Gutendex.
2. **Registro Automático y Relacional:** Al encontrar una coincidencia, tanto el Libro como sus Autores quedan debidamente almacenados (sin repeticiones) dentro del motor relacional PostgreSQL.
3. **Listado Histórico de Consultas:** Exhibe de forma estructurada todo el acervo literario recabado por el usuario previamente.
4. **Listado de Autores Centralizado:** Extrae una nómina de cada escritor captado y registrado en la BD.
5. **Busqueda de Autores por Época:** Realiza una búsqueda refinada calculando qué autores del catálogo estaban con vida en un año en específico ingresado por el usuario.
6. **Filtros Estadísticos (Idioma):** Muestra el volumen demográfico de los libros por idiomas (ej: ¿Cuántos libros ingleses vs españoles tenemos registrados?).

---

## 🛠️ Stack Tecnológico

La infraestructura del proyecto está edificada íntegramente de cara a las necesidades de **Backend** dictadas por la industria contemporánea:

- **Lenguaje Transversal:** Java 25 (LTS)
- **Framework Core:** Spring Boot (v3.3+)
- **Persistencia de Datos:** Spring Data JPA / Hibernate
- **Base de Datos:** PostgreSQL local (v16+)
- **Procesamiento de Payload:** Jackson Annotations (Data Binding)
- **Gestión de Paquetes y Construcción:** Maven

---

## 📄 Arquitectura Documental (Docs)

Hemos adoptado metodologías ágiles y documentales severas para mantener el producto pulcro. Para entender internamente el desarrollo, navega la carpeta `/docs` y archivos en la ruta raíz:

- **`BACKLOG.md`**: Detalla el requerimiento íntegro subdividido en 13 Historias de Usuario con sus *"Checklists"*.
- **`docs/plan_de_implementacion.md`**: Fases metódicas de abordaje del desafío Sprint tras Sprint.
- **`docs/reglas_de_implementacion.md`**: Define el severo flujo *HU -> Desarrollo -> QA -> Commit Conventional*.
- **`docs/roles_utilizados.md`**: Delimita responsabilidades simuladas (DBA, Backend, QA...).
- **`docs/sdlc_literalura.md`**: El mapeo de las 7 fases maduras del ciclo de vida del software aplicadas en este Challenge.

---

## ☕ Instalación y Ejecución Práctica

Para inicializar y testear el catálogo personal de libros a nivel local, es imprescindible realizar estos pasos:

### 1. Variables y Servicios
- Asegúrate de contar con el IDE de tu preferencia y soporte para Java 25.
- Debes tener el servicio de **PostgreSQL** montado en el puerto por defecto (5432) y tener creada una base de datos vacía local (ej: `literalura`).

### 2. Configuración JPA (Próximamente)
- Clonar el repositorio.
- Acceder a los recursos (`src/main/resources/application.properties`) y conectar con las credenciales correspondientes a tu gestor local DB.

### 3. Build & Run
- Ubicarse en la ruta raíz.
- Construir con Maven.
- Ejecutar el `.jar` consolidado o utilizar el IDE.

---

*Proyecto en vías de culminación para el programa ONE de Alura.*