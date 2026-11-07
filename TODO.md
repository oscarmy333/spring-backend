# TODO - Migración a Clean Architecture

## Progreso de la Migración ✅ COMPLETADO

- [x] 1. Crear estructura de carpetas Clean Architecture
- [x] 2. Capa Dominio (Domain Layer)
  - [x] 2.1 Crear entidad Personal (domain/entities)
  - [x] 2.2 Crear interfaz IPersonalRepository (domain/repositories)
  - [x] 2.3 Crear excepciones del dominio (domain/exceptions)
- [x] 3. Capa Aplicación (Application Layer)
  - [x] 3.1 Crear PersonalDTO (application/dto)
  - [x] 3.2 Crear PersonalMapper (application/mapper)
  - [x] 3.3 Crear interfaz IPersonalService (application/ports)
  - [x] 3.4 Crear PersonalUseCase (application/usecases)
- [x] 4. Capa Infraestructura (Infrastructure Layer)
  - [x] 4.1 Crear PersonalEntity (infrastructure/persistence/entities)
  - [x] 4.2 Crear PersonalRepositoryImpl (infrastructure/persistence/repositories)
  - [x] 4.3 Crear PersonalController (infrastructure/web)
  - [x] 4.4 Crear GlobalExceptionHandler (infrastructure/web)
- [x] 5. Configuración (No necesaria con @Component)
- [x] 6. Eliminar archivos antiguos
  - [x] 6.1 Eliminar controller/PersonalController.java
  - [x] 6.2 Eliminar services/ y sus contenidos
  - [x] 6.3 Eliminar model/, repository/, exception/ antiguos
- [ ] 7. Verificar compilación (Requiere configurar JAVA_HOME)

