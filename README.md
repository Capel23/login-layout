# ProyectoApp 🐱

Un hermoso layout de login y ecommerce para Android con diseño Material Design y colores personalizados del icono MANGUP.

## 🎨 Características

- **Diseño Material Design** - Componentes modernos y responsivos
- **Login Activity** - Pantalla de autenticación con validación
- **Home/Ecommerce Activity** - Pantalla de productos con RecyclerView
- **Navegabilidad con Intent** - Navegación fluida entre actividades
- **Colores Personalizados** - Paleta de colores basada en el icono MANGUP
- **Logo Integrado** - Icono PNG del gato MANGUP 
- **Campos de Entrada** - Email/Usuario y Contraseña con validación visual
- **Botón de Acción** - "Iniciar Sesión" destacado con color rojo
- **Responsive** - Adaptable a dispositivos de diferentes tamaños
- **RecyclerView de Productos** - Grilla de productos en la pantalla home

## 🎯 Colores Implementados

| Elemento | Color | Código Hex |
|----------|-------|-----------|
| Fondo | Verde Azulado | #369C9E |
| Título MANGUP | Dorado | #DCC08C |
| Bordes de Campos | Carmesí | #D1473E |
| Botón Iniciar | Rojo | #A63029 |
| Fondo Campos | Crema | #FDF5E6 |
| Texto Secundario | Crema Claro | #FDF5E6 |

## 📱 Estructura del Proyecto

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── MainActivity.kt (Login Activity)
│   │   │   ├── HomeActivity.kt (Ecommerce Activity)
│   │   │   ├── Product.kt (Data class)
│   │   │   └── ProductAdapter.kt (RecyclerView Adapter)
│   │   └── res/
│   │       ├── layout/
│   │       │   ├── activity_main.xml (Login Layout)
│   │       │   ├── activity_home.xml (Home Layout)
│   │       │   └── item_product.xml (Product Item Layout)
│   │       ├── drawable/
│   │       │   └── icono_mangup.png
│   │       └── values/
│   │           ├── colors.xml
│   │           ├── strings.xml
│   │           └── themes.xml
│   └── build.gradle.kts
```

## 🚀 Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/Capel23/login-layout.git
cd login-layout
```

2. Abre el proyecto en Android Studio

3. Ejecuta el proyecto en un emulador o dispositivo físico

## 📋 Requisitos

- Android Studio 2022.1 o superior
- SDK de Android 28 o superior
- Gradle 8.0 o superior

## 🛠️ Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación
- **Material Design** - Componentes y estilos
- **ConstraintLayout** - Sistema de layout
- **Vector Drawable** - Para gráficos escalables

## 📝 Elementos del Layout

- **Logo** - ImageView con el icono MANGUP (150dp x 150dp)
- **Título** - TextView con nombre "MANGUP" en dorado
- **Campos de Entrada** - TextInputLayout para email y contraseña
- **Botón de Acción** - MaterialButton con icono rojo
- **Separador** - Línea divisoria con texto "O"
- **Link de Registro** - TextView para registrarse

## 🎓 Puntuación

Este proyecto cumple con los requisitos de:
- ✅ Layout Android con todas sus características
- ✅ Todos los elementos de interfaz pedidos
- ✅ Diseño profesional y responsivo
- ✅ Colores coordinados y atractivos

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la Licencia MIT.

## 👤 Autor

Desarrollo realizado por Luis Capel para el proyecto MANGUP Login Layout

---

⭐ Si te gusta este proyecto, ¡no olvides dejar una estrella!

