# Plan de Implementación (Challenge Literalura)

Este documento detalla el plan estratégico para el desarrollo del "Challenge Literalura", estructurado rigurosamente sobre la base de las Historias de Usuario (HU) definidas en nuestro Backlog.

## Fases de Implementación

### Fase 1: Inicialización y Configuración (Sprints iniciales)
* **HU 00:** Crear el repositorio de tu proyecto en GitHub.
* **HU 01:** Configurando el entorno Java (v25) y Spring (v3.3+).
* **Objetivo:** Tener el esqueleto del proyecto funcionando, conectado al repositorio remoto y con la base de datos PostgreSQL lista para recibir conexiones.

### Fase 2: Exploración e Integración de la API
* **HU 02:** Conociendo la API (Gutendex) para traer datos.
* **HU 03:** Construyendo una solicitud HTTP a la API (HttpClient).
* **HU 04:** Analizando la respuesta en formato JSON (Jackson).
* **HU 05:** Convirtiendo los datos mapeados a Objetos (DTOs).
* **Objetivo:** Lograr una conexión exitosa con Gutendex, extraer el JSON y deserializar correctamente la información (Libros y Autores) dentro del flujo de la aplicación.

### Fase 3: Persistencia de Datos y Modelo de Dominio
* **HU 07:** Consultar libros (Entity, API y Repository).
* **HU 08:** Consultar autores (Entity y relación).
* **HU 09:** Persistencia de datos en la base de datos local.
* **Objetivo:** Definir las entidades `Libro` y `Autor` y sus repositorios. Asegurar que al buscar un libro, la data se guarde permanentemente en PostgreSQL, relacionando correctamente los autores sin duplicarlos.

### Fase 4: Interfaz e Interacción con el Usuario
* **HU 06:** Interactuando con el usuario (Menú interactivo en consola).
* **HU 10:** Listando libros por idiomas (Consultas estadísticas base).
* **HU 11:** Listando autores vivos en determinado año.
* **Objetivo:** Proveer un menú CLI usando `Scanner` administrado por el `CommandLineRunner`. Conectar las opciones del menú con los servicios que consultan la base de datos y la API.

### Fase 5: Características Premium (Opcionales)
* **Extras:** Generar estadísticas con `DoubleSummaryStatistics`, Top 10 Libros, Buscar autores por nombre en BD, etc.
* **Objetivo:** Elevar el nivel del producto agregando métricas y búsquedas más complejas.

### Fase 6: Cierre y Entrega
* **HU 12:** Estructura técnica profesional del repositorio (README.md).
* **HU 13:** Terminar el Curso y enviar el enlace de GitHub.
* **Objetivo:** Presentar un repositorio impecable y obtener la certificación.
