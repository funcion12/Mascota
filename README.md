# Examen Final - Programación Avanzada I
### Ing. y Lic. en Sistemas
### Turno Mayo 2025

### Objetivos
- Desarrollar endpoints que permitan el registro y consulta de la entidad Mascota
- Implementar Frontend que consuma los endpoints desarrollados

### Tiempo
- 2 horas reloj
### Evaluacion
- Se evaluará la versión del proyecto en el repositorio correspondiente, a la hora de finalización del examen, estimada para el día 08/05/2025 17:00
- El proyecto debe compilar sin errores en cualquier entorno de programación en el que se abra
- Todos los test unitarios deben pasar en verde
- Se probará la funcionalidad desde el Frontend

### Punto de partida
- Se proveerá el esquema de Backend en blanco, donde el alumno tenrá que crear test y código fuente que cubra la consigna.
- Prestar atención a los comentarios en el código

## Consigna
#### Módulo Veterinaria
_Se desea implementar un backend con su respectivo frontend para un microservicio que permita registrar mascotas._

#### Restricciones:
- No puede existir dos Mascotas con el mismo nombre
- El id debe ser un UUID generado por la lógica de dominio, y no por estrategia de base de datos
- Todos los atributos de Mascota son obligatorios
- La fecha de nacimiento de la mascota no puede ser superior a la actual
- La talla de la mascota debe ser uno de los siguientes valores: GRANDE - MEDIANA - PEQUEÑA

#### Funcionalidad
- Crear Mascota
  - Endpoint: POST http://localhost:8080/mascotas
  - RequestBody:
    ```json
    {
      "id": "7e8ad860-716d-4b86-9643-430870caefe7",
      "nombre": "Max",
      "fecha_nacimiento": "2021-01-01T10:00:00.000Z",
      "talla": "GRANDE"
    }
    ```

- Buscar Mascotas
  - Endpoint: GET http://localhost:8080/mascotas

#### Buenas prácticas y conceptos a considerar
- La nomenclatura de paquetes será en minúsculas
- La nomenclatura de clases será en UpperCamelCase
- La nomenclatura de métodos será en lowerCamelCase
- La organización de paquetes será por modelo->aspecto, tanto a nivel src/main como a nivel src/test. Ejemplo:
  ```
  mascotas
  └─ excepciones
  └─ modelo
  └─ repositorio
  └─ casodeuso
  ```
- Usar Excepciones personalizadas
- Se debe usar método factory/instancia para crear objetos
- Nomenclatura representativa de clases, métodos, etc.
