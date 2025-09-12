# SITFIS Seguridad

Este proyecto es un microservicio de **Seguridad** desarrollado con **Spring Boot** y **Jakarta EE**. Su objetivo es gestionar la autenticación, autorización y administración de usuarios, roles, grupos y permisos del sistema SITFIS.

## Características

- **Autenticación y Autorización**: Login/logout con gestión de tokens JWT
- **Gestión de Usuarios**: CRUD completo de usuarios con validación de disponibilidad
- **Administración de Roles y Grupos**: Gestión jerárquica de permisos y accesos
- **Sistema de Menús**: Control granular de acceso a funcionalidades (Menús, Submenús, Tabs)
- **Paginación y Filtros**: Consultas optimizadas con soporte para paginación
- **Reportes**: Generación de reportes de usuarios, roles y grupos
- **Arquitectura Hexagonal**: Implementación con patrones de Clean Architecture

## Endpoints Principales

### Autenticación
- `POST /auth/login` - Autenticación de usuarios
- `GET /auth/logout` - Cierre de sesión

### Administración de Usuarios
- `GET /api/admin/usuarios` - Listado paginado de usuarios
- `POST /api/admin/usuarios` - Crear nuevo usuario
- `PUT /api/admin/usuarios/{id}` - Actualizar usuario
- `GET /api/admin/usuarios/verificar-disponibilidad` - Verificar disponibilidad de cuenta

### Gestión de Grupos
- `GET /api/admin/grupos` - Listar grupos disponibles
- `POST /api/admin/grupos` - Crear grupo
- `PUT /api/admin/grupos/{id}` - Actualizar grupo
- `DELETE /api/admin/grupos/{id}` - Eliminar grupo
- `GET /api/admin/grupos/paginado` - Listado paginado con filtros

### Sistema de Menús
- `GET /api/admin/menu` - Listar menús con filtros
- `GET /api/admin/submenu` - Listar submenús por menú
- `GET /api/admin/tabs` - Listar tabs por menú/submenú
- `GET /api/admin/tabs/paginado` - Listado paginado de tabs

### Roles y Permisos
- `GET /api/admin/rol-grupo/grupo/{grupoId}` - Roles por grupo
- `POST /api/admin/rol-grupo/crear-o-actualizar` - Asignar roles a grupos
- `DELETE /api/admin/rol-grupo/{grupoId}` - Eliminar asignaciones

### Usuario-Rol-Grupo
- `GET /api/admin/usuariosrolesgrupos/{id}` - Obtener roles de usuario
- `POST /api/admin/usuariosrolesgrupos/crear-o-actualizar` - Asignar roles a usuarios
- `POST /api/admin/usuariosrolesgrupos/copiar-roles` - Copiar permisos entre usuarios
- `PUT /api/admin/usuariosrolesgrupos/usuario-grupo-grincipal/{usuarioId}` - Establecer grupo principal

### Listas y Reportes
- `GET /api/admin/listas-roles-grupos/reporte` - Reporte completo de asignaciones
- `GET /api/admin/listas-roles-grupos/paginado` - Listado paginado de asignaciones
- `GET /api/admin/listas-roles-grupos/menus` - Menús disponibles por grupo/rol

## Tecnologías Utilizadas

- **Spring Boot 3.x** con **Jakarta EE**
- **Spring Data JPA** para persistencia
- **Spring Security** para autenticación y autorización
- **Lombok** para reducir código boilerplate
- **Java SDK 24**
- **Arquitectura Hexagonal** (Puertos y Adaptadores)
- **OpenAPI/Swagger** para documentación de API

## Seguridad

- Todas las rutas bajo `/api/admin/**` requieren autenticación
- Las rutas de autenticación `/auth/**` son públicas
- Implementa validación de roles y permisos granulares
- Soporte para CORS configurado para entornos de desarrollo

## Monitoreo

Se incluyen endpoints de Actuator para monitoreo y health checks en `/actuator/**`.