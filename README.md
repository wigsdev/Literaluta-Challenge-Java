<h1 align="center">📚 Challenge Literalura</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" alt="Hibernate"/>
  <img src="https://img.shields.io/badge/Maven-C71A22?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
</p>

## 📖 Descripción del Proyecto

¡Bienvenido a **Literalura**! Esta aplicación de consola (CLI) es un catálogo interactivo de libros desarrollado en Java con el framework Spring Boot. 

El proyecto consume la API pública de Gutendex para buscar información literaria en tiempo real (libros, autores, idiomas, descargas), procesa y filtra los datos (mapeo JSON a Java con Jackson), y finalmente los persiste en una base de datos **PostgreSQL** mediante **Spring Data JPA**. Una vez guardados, el sistema permite realizar consultas avanzadas al repositorio local combinando filtrados y estadísticas.

---

## 🚀 Tecnologías Utilizadas

*   ☕ **Java 25:** Lenguaje de programación principal para el backend.
*   🍃 **Spring Boot 3:** Framework facilitador para la configuración y control de inversión.
*   🗄️ **Spring Data JPA / Hibernate:** Capa de persistencia y mapeo objeto-relacional (ORM).
*   🐘 **PostgreSQL 16:** Motor de bases de datos relacional para guardar el histórico.
*   📦 **Jackson:** Librería esencial responsable de la deserialización de los JSON de la API.
*   🛠️ **Maven:** Herramienta estandarizada para la gestión de dependencias y construcción.

---

## ⚙️ Funcionalidades del Menú

La aplicación te proveerá de un menú interactivo por terminal con las 5 funciones clave requeridas por el Challenge:

1.  🔍 **Buscar libro por título:** Consulta a la API de Gutendex por título, extrae metadatos y crea las instancias Java para registrar Libro y Autor (con verificación lógica para evitar duplicidades).
2.  📚 **Listar libros buscados:** Consulta en la base de datos e imprime el historial de las obras literarias que tienes almacenadas en el sistema.
3.  ✍️ **Listar autores guardados:** Imprime un catálogo extraído del repositorio con la información de los autores que han sido registrados junto con sus obras.
4.  ⏳ **Listar autores vivos en un año determinado:** Usando *Derived Queries* precisos, analiza el histórico local, comparando año de nacimiento y defunción con el año introducido por el usuario, para filtrar autores que seguían con vida.
5.  🌐 **Listar libros por idioma:** Ingresa el acrónimo estadístico (`es`, `en`, `fr`, `pt`) y el sistema te retornará detalles de dichos libros junto a la cantidad total (recuento / *size*).

---

## 🛠️ Instrucciones de Instalación y Uso

### 1. Pre-requisitos indispensables
*   Tener el **Java Development Kit (JDK) 25** instalado en tu computadora.
*   Motor de **PostgreSQL** corriendo localmente en el puerto `5432`.
*   Crear una base de datos relacional vacía llamada `literalura`.

### 2. Configurar el Entorno Principal
Asegúrate de ejecutar la siguiente instrucción en tu consola `psql` o a través de herramientas gráficas como `pgAdmin` para tener el recipiente de almacenamiento listo:
```sql
CREATE DATABASE literalura;
```
*(Nota: Si tus credenciales de Postgresql locales no son `postgres` / `postgres`, actualiza tu usuario y clave en el archivo `application.properties` antes de arrancar).*

### 3. Clonar y Desplegar
Baja el repositorio desde GitHub e inicialízalo en segundos con el wrapper de Maven que ya viene preconfigurado:
```bash
# Clonar repositorio
git clone https://github.com/tu-usuario/literalura.git
cd literalura

# Ejecutar el aplicativo (Linux / Mac)
./mvnw spring-boot:run

# Ejecutar el aplicativo (Windows CMD / PowerShell)
.\mvnw.cmd spring-boot:run
```

---
<p align="center">
  <i>Desarrollado como parte del desafío (Challenge Literalura) correspondiente a la especialización Backend del programa educativo Alura ONE (Oracle Next Education).</i>
</p>