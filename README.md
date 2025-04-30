# Microservicio Mi Negocio

Desarrollado bajo principios sólidos, arquitectura limpia y dominio rico, este microservicio ofrece:
- Alta escalabilidad mediante diseño modular
- Independencia tecnológica en capas críticas
- Integración fluida con ecosistemas cloud-native

## Características clave
### Arquitectura
- **Arquitectura hexagonal (Ports & Adapters)**
    - Dominio aislado de infraestructura
    - **Contratos claros entre capas(Interfaces)**
    - Desacoplamiento de frameworks externos
- **Principios SOLID y Clean Code**
    - Inversión de dependencias
    - Single Responsibility en componentes  
- **Patrón CQRS (Command Query Responsibility Segregation)**
     - Lectura (Query)
     - Escritura (Command)
  
## Requisitos Previos
- Java 23
- Postgres 17 o superior
- IntelliJ IDEA o tu IDE favorito compatible con Spring Boot

## Tecnologías principales
- Java 23
- Spring Boot 3.1.3
- Spring Cloud 2023.0.3
- Maven 3.3.9
- PostgreSQL 17
- Liquibase 4.24.0
- Hibernate 6.4.4.Final
- JPA 3.2.5

## Clonar el repositorio gitHub
- git clone https://github.com/ingcharles/MI-NEGOCIO-SERVICE.git

## Levantar servidor en modo desarrollo
### Configuración para Ejecutar la Aplicación:
- Crea la base de datos con el siguiente comando: CREATE DATABASE mybusinessdb;
- En IntelliJ IDEA, ve a la clase principal de tu aplicación (CatalogoServiceApplication) que se encuentra en el paquete ec.gob.imark.catalogo
- Abre esta clase en el editor de código.
- Crear una configuración de ejecución (Run Configuration)
- Haz clic en el menú desplegable de configuraciones de ejecución en la esquina superior derecha de IntelliJ (donde dice "Edit Configurations").
- Haz clic en el botón de "+" para agregar una nueva configuración y selecciona "Maven", en run digita "clean install" y en directorio selecciona la carpeta MI-NEGOCIO-SERVICE.
- Haz clic en el botón de "+" para agregar una nueva configuración y selecciona "Spring Boot".
- En el campo active profile ingresa el perfil "dev"
- Ejecuta Run o Debug según sea el caso
- Navega con el siguiente enlace a la documentación de las apis  http://localhost:8081/api/my-business/swagger-ui/index.html

## Estrategia de Pruebas (TDD) - Habilitar para testear
- **Pruebas Unitarias**
  - Unit 5 + AssertJ + Mockito
- **Pruebas de Integración**
  - @SpringBootTest + AssertJ
- Una vez Ejecutado Run o Debug - Aqui se crea la estructura de la base de datos para las pruebas de integración
- Habilitar las pruebas comentar la anotación @Disabled
- Para ejecutar las pruebas click derecho sobre cada archivo de pruebas y seleccionar Run o Debug según sea el caso