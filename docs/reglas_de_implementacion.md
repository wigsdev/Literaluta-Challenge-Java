# Reglas de Implementación y Flujo de Trabajo

Para asegurar la calidad, el orden y el mantenimiento adecuado del código a lo largo de la implementación del *Challenge Literalura*, el equipo ha acordado el siguiente flujo de trabajo estricto:

## Flujo de Trabajo (Workflow)

Cada nueva iteración de código o funcionalidad deberá seguir este ciclo de 5 pasos:

1. **Leer la Historia de Usuario (HU):**
   * Antes de codificar, se debe comprender el requerimiento dictado en el `BACKLOG.md` (o cualquier herramienta equivalente como Trello).
   * Identificar los criterios de aceptación y el checklist asociado.

2. **Implementar la HU:**
   * Escribir el código en la rama correspondiente asegurando la aplicación de buenas prácticas (SOLID, Clean Code).
   * Agregar comentarios pertinentes si la lógica es abstracta.

3. **Probar el funcionamiento de lo implementado:**
   * Ejecutar la aplicación e interactuar con la funcionalidad recién desarrollada de forma manual.
   * Realizar pruebas en consola para forzar errores comunes (ej. meter letras en menús numéricos, fechas incongruentes) para evitar "Crashes". Solo se avanza si las pruebas son exitosas.

4. **Actualizar el Backlog:**
   * Una vez probado el código, marcar los ítems del checklist de finalización de la HU en el `BACKLOG.md` con un `[x]`.
   * Considerar la HU como Concluida.

5. **Realizar Commits Descriptivos (Conventional Commits):**
   * Integrar los cambios utilizando las normativas de [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/).
   * Ejemplos de formato a utilizar:
     * `feat: añadir conexión HTTP con API Gutendex`
     * `fix: resolver duplicación de autores en BD`
     * `docs: actualizar el README con nuevas instrucciones`
     * `refactor: modularizar el menú interactivo de la consola`
