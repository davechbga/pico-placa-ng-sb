# Pico y Placa - Fullstack Application

Este repositorio contiene una aplicación web diseñada para validar restricciones de circulación vehicular según la normativa de "Pico y Placa" en Ecuador. La solución está dividida en dos partes principales:

- **Frontend:** Una aplicación en Angular.
- **Backend:** Una API REST desarrollada en Spring Boot.

---

## Tabla de Contenidos

1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Requisitos Previos](#requisitos-previos)
4. [Instalación y Configuración](#instalación-y-configuración)
5. [Lógica de Pico y Placa en Ecuador](#lógica-de-pico-y-placa-en-ecuador)
6. [Contribuciones](#contribuciones)

---

## Descripción del Proyecto

El objetivo de esta aplicación es permitir a los usuarios verificar si un vehículo puede circular en una fecha y hora específicas, siguiendo las restricciones de "Pico y Placa" en Ecuador. Estas restricciones están basadas en el último dígito de la placa del vehículo, el día de la semana y un rango de horas establecido.

## Estructura del Proyecto

El repositorio está organizado en las siguientes carpetas:

- `pico-placa-frontend`: Contiene el código fuente del frontend desarrollado en Angular.
- `pico-placa-backend`: Contiene el código fuente del backend desarrollado en Spring Boot.

## Requisitos Previos

Asegúrate de tener instalados los siguientes componentes:

- **Node.js** (v18 o superior) y **npm**
- **Angular CLI** (v19.0.6 o superior)
- **Java** (JDK 21)
- **Maven** (v3.8 o superior)
- **Git**

## Instalación y Configuración

Sigue los pasos a continuación para configurar y ejecutar el proyecto:

### 1. Clonar el Repositorio

```bash
git clone https://github.com/davechbga/pico-placa-ng-sb.git
```

### 2. Configuración del Frontend

1. Navega a la carpeta `pico-placa-frontend`:

   ```bash
   cd pico-placa-frontend
   ```

2. Instala las dependencias del proyecto:

   ```bash
   npm install
   ```

3. Levanta el servidor de desarrollo:

   ```bash
   ng serve
   ```

4. Accede a la aplicación en tu navegador en [http://localhost:4200](http://localhost:4200).

### 3. Configuración del Backend

1. Navega a la carpeta `pico-placa-backend`:

   ```bash
   cd ../pico-placa-backend
   ```

2. Ejecuta el servidor con Maven:

   ```bash
   mvn spring-boot:run
   ```

3. El backend estará disponible en [http://localhost:8080](http://localhost:8080).

---

## Lógica de Pico y Placa en Ecuador

La normativa de "Pico y Placa" en Ecuador restringe la circulación vehicular en ciertas áreas dependiendo del último dígito de la placa del vehículo, el día de la semana y las horas pico establecidas.

### Restricciones por Último Dígito de la Placa

| Día       | Último Dígito Restringido |
| --------- | ------------------------- |
| Lunes     | 1 y 2                     |
| Martes    | 3 y 4                     |
| Miércoles | 5 y 6                     |
| Jueves    | 7 y 8                     |
| Viernes   | 9 y 0                     |

### Horarios de Restricción

- **Mañana:** 07:00 a 09:30
- **Tarde:** 16:00 a 20:00

### Validación

La aplicación utiliza los siguientes parámetros para determinar si un vehículo puede circular:

1. **Último dígito de la placa:** Extraído automáticamente de la entrada proporcionada por el usuario.
2. **Día de la semana:** Determinado a partir de la fecha ingresada.
3. **Hora:** Comparada con los rangos de restricción.

Si todas las condiciones de restricción se cumplen, el vehículo no puede circular en el horario ingresado.

---

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un [issue](https://github.com/usuario/pico-placa/issues) o envía un pull request con tus mejoras o sugerencias.
