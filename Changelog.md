# Changelog

## 26/05/2025

- Versión inicial que contiene:

1. Diseño modular basado en arquitectura limpia (hexagonal).
2. Administración automática de excepciones.
3. Ejemplo de servicio rest, servicio ejb y repositorio jpa.
4. Manejo de transacciones.
5. Control de concurrencia para cada entity.
6. Manejo de records en lugar de DTOs.
7. Manejo de mappers con mapStruct en lugar de mappers manuales.
8. Configuración de conexión a base de datos y control de pool de conexiones.
9. Validación de PMD, Codesmell, CheckStyle basado en las reglas que se encuentran cargadas en el
   repositorio http://10.1.22.164/analisis-codigo/analisis-codigo.
10. Pipeline de integración continua (CI) de GitLab para :
    a. Integración continua mediante plugins de validaciones de código estático para que se realice la verificación con
    cada ejecución del comando mvn clean install antes de subir el código al GitLab.
    b. Envío del código fuente al servidor SonarQube.
    c. Creación de la imagen Docker basada en el código fuente y envío de imagen Docker al registry.
