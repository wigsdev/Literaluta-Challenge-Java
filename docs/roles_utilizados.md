# Roles Utilizados en la Implementación

Dado el enfoque integral del **Challenge Literalura** (desde el diseño de base de datos hasta el consumo de APIs y la experiencia de usuario en consola), es necesario distribuir las capacidades requeridas en roles lógicos de desarrollo. Aunque sea un proyecto de esfuerzo individual o par, adoptaremos las siguientes posturas para asegurar la calidad del producto:

## 1. Backend Developer (Especialista en Integraciones Java)
* **Responsabilidades:** 
  * Configurar Spring Boot, gestionar dependencias en Maven (Jackson, JPA).
  * Crear clientes HTTP para consumir la API de Gutendex.
  * Diseñar la capa de servicio que interconecta el repositorio y la vista.
  * Mapear y deserializar los JSONs provenientes de la API.

## 2. Database Administrator (DBA) / Arquitecto de Datos
* **Responsabilidades:** 
  * Modelar las entidades `@Entity` de `Libro` y `Autor` en Java, previendo su impacto físico en PostgreSQL.
  * Administrar relaciones (`@ManyToOne`, `@OneToMany`) y el comportamiento en cascada.
  * Diseñar y optimizar consultas personalizadas (*Derived Queries* / `@Query`).
  * Evitar la redundancia de datos (control de duplicados de Autores).

## 3. Analista de Calidad (QA Tester)
* **Responsabilidades:** 
  * Crear y ejecutar baterías de pruebas manuales exhaustivas en la consola (Interacción del Usuario).
  * Validar casos de borde: años inválidos, texto en lugar de números, búsquedas de libros que no existen, desbordamiento de descargas.
  * Asegurar que por cada "Implementación" en el flujo de trabajo, se proceda a validar antes de aplicar el commit.

## 4. Product Owner / Technical Lead
* **Responsabilidades:** 
  * Velar por la estructura técnica del proyecto.
  * Mantener el `BACKLOG.md` (y/o tablero Trello) debidamente actualizado.
  * Definir los criterios de aceptación y priorizar el desarrollo (Phase 1, 2, 3..).
  * Redactar documentación de altísimo nivel (Como el `README.md` final y este documento).
