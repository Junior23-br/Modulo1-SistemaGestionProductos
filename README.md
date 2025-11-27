# 📦 Sistema Básico de Gestión de Productos  
### Proyecto del Módulo 1 – Programación en Java

Este proyecto implementa un **sistema de gestión de productos por consola**, utilizando los fundamentos principales de Java: métodos, variables estáticas, validaciones, ciclos y estructuras condicionales.

---

## 🎯 Objetivo  
Construir un programa que permita **registrar, consultar y gestionar información de un producto** desde una interfaz de texto, siguiendo buenas prácticas de organización y modularidad del código.

---

## 🛠️ Funcionalidades Principales  

### 📜 1. Menú Principal  
El programa muestra un menú con todas las opciones disponibles para manipular el producto:

- Registrar nuevo producto  
- Mostrar información del producto  
- Calcular valor total del inventario  
- Mostrar resumen completo  
- Limpiar los datos actuales  
- Salir del sistema  

---

### 📝 2. Registrar Producto  
Permite ingresar:  
- 🏷️ Nombre  
- 💲 Precio unitario (validado: debe ser mayor que 0)  
- 📦 Cantidad (validado: entero ≥ 0)  

Si ya existe un producto registrado, el sistema solicita confirmación para sobrescribirlo.

---

### 🔍 3. Mostrar Información Actual  
Muestra los datos almacenados del producto.  
Si no hay datos registrados, informa al usuario.

---

### 💰 4. Calcular Valor del Inventario  
Calcula:  
El resultado se muestra con dos decimales.

### 📊 5. Resumen Completo del Producto
Incluye:
- Nombre
- Precio unitario
- Cantidad
- Valor total
- Estado del stock según la cantidad:
  - 🔴 Bajo (< 5)
  - 🟡 Suficiente (5–20)
  - 🟢 Alto (> 20)

### 🧹 6. Limpiar Datos
Restablece los valores a:
- Nombre → "N/A"
- Precio → 0.0
- Cantidad → 0

## ✔️ Validaciones Incluidas
El sistema cuenta con métodos independientes para validar:
- Nombre → ni vacío ni espacios
- Precio → mayor que 0
- Cantidad → entero ≥ 0

## 🧩 Estructura del Programa
- Todo el proyecto está implementado en una sola clase Java.
- El `main` solo controla el menú principal y llama a los demás métodos.
- Se usan variables estáticas para almacenar los datos del producto.

