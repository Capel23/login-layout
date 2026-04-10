# 🎨 Guía de Personalización - Login Layout

## Introducción

Este documento te guiará sobre cómo personalizar el login layout según tus necesidades.

---

## 🖼️ 1. Cambiar el Logo

### Opción A: Usar un drawable personalizado

1. **Crear una imagen personalizada**:
   - Coloca tu imagen PNG en `app/src/main/res/drawable/`
   - Nombre: `ic_logo.png` (o el que prefieras)

2. **Actualizar el layout**:
   - En `activity_main.xml`, busca la sección del ImageView:
   ```xml
   <ImageView
       android:id="@+id/logo"
       android:layout_width="100dp"
       android:layout_height="100dp"
       android:src="@drawable/ic_logo"  <!-- Cambiar esto -->
   />
   ```

### Opción B: Usar un icono materializado

Si quieres un icono moderno, puedes usar Material Icons:
```xml
<ImageView
    android:id="@+id/logo"
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:src="@drawable/ic_lock_secure"
    android:tint="@color/primary"
/>
```

---

## 🎨 2. Cambiar Colores

### Colores disponibles en `colors.xml`:

```xml
<color name="primary">#2196F3</color>           <!-- Color principal (botón, hints)-->
<color name="primary_dark">#1976D2</color>      <!-- Variante oscura -->
<color name="accent">#FF6200EE</color>          <!-- Color de acento -->
<color name="gray_light">#F5F5F5</color>        <!-- Fondos de campos -->
<color name="gray_dark">#424242</color>         <!-- Texto oscuro -->
<color name="hint_text">#999999</color>         <!-- Textos de hints -->
<color name="error">#FF5252</color>             <!-- Color de error -->
```

### Ejemplo: Cambiar a tema oscuro

```xml
<!-- En colors.xml -->
<color name="primary">#1E88E5</color>           <!-- Azul más claro -->
<color name="gray_light">#303030</color>        <!-- Gris oscuro -->
<color name="gray_dark">#E0E0E0</color>         <!-- Texto claro -->
<color name="white">#121212</color>             <!-- Fondo oscuro -->
```

### Ejemplo: Tema verde

```xml
<color name="primary">#00BCD4</color>           <!-- Verde-azulado -->
<color name="primary_dark">#0097A7</color>
<color name="accent">#009688</color>
```

---

## ✍️ 3. Cambiar Textos

Todos los textos están en `app/src/main/res/values/strings.xml`:

```xml
<!-- Cambiar el título de inicio de sesión -->
<string name="login_title">Acceder a tu Cuenta</string>

<!-- Cambiar placeholder de email -->
<string name="email_hint">Tu correo electrónico</string>

<!-- Cambiar texto del botón -->
<string name="login_button">Acceder</string>

<!-- Cambiar textos de links -->
<string name="forgot_password">¿Olvidaste la contraseña?</string>
<string name="no_account">¿Nuevo usuario? <b>Crea una cuenta</b></string>
```

---

## 📏 4. Cambiar Tamaños y Espacios

En `activity_main.xml`:

### Cambiar tamaño del logo:
```xml
<ImageView
    android:id="@+id/logo"
    android:layout_width="120dp"    <!-- Cambiar aquí -->
    android:layout_height="120dp"   <!-- Cambiar aquí -->
/>
```

### Cambiar altura de campos:
```xml
<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/emailEditText"
    android:layout_width="match_parent"
    android:layout_height="56dp"    <!-- Cambiar aquí (default 48dp) -->
/>
```

### Cambiar padding general:
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="32dp"          <!-- Cambiar aquí (default 24dp) -->
/>
```

---

## 🔤 5. Cambiar Tipografía

### Aumentar tamaño de textos:
```xml
<TextView
    android:text="@string/login_title"
    android:textSize="24sp"         <!-- Cambiar aquí -->
/>
```

### Usar estilos personalizados:
Crea un archivo `styles.xml`:
```xml
<style name="LoginTitleStyle">
    <item name="android:textSize">24sp</item>
    <item name="android:textStyle">bold</item>
    <item name="android:textColor">@color/primary</item>
    <item name="android:fontFamily">@font/montserrat_bold</item>
</style>
```

Luego en el layout:
```xml
<TextView
    style="@style/LoginTitleStyle"
/>
```

---

## 🔘 6. Cambiar el Botón

### Cambiar color del botón:
```xml
<com.google.android.material.button.MaterialButton
    android:id="@+id/loginButton"
    app:backgroundTint="@color/primary"     <!-- Cambiar aquí -->
    app:cornerRadius="8dp"                  <!-- Radio de esquinas -->
/>
```

### Cambiar a botón de contorno:
```xml
<com.google.android.material.button.MaterialButton
    android:id="@+id/loginButton"
    style="@style/Widget.MaterialComponents.Button.OutlinedButton"
    app:strokeColor="@color/primary"
    android:textColor="@color/primary"
/>
```

### Cambiar a botón de texto:
```xml
<com.google.android.material.button.MaterialButton
    android:id="@+id/loginButton"
    style="@style/Widget.MaterialComponents.Button.TextButton"
/>
```

---

## ⌨️ 7. Cambiar los Campos de Entrada

### Cambiar estilo de campo (Outlined):
```xml
<com.google.android.material.textfield.TextInputLayout
    style="@style/Widget.MaterialComponents.TextInputEditText.OutlinedBox"
    app:boxBackgroundColor="@color/gray_light"
    app:boxStrokeColor="@color/primary"
/>
```

### Cambiar a estilo relleno:
```xml
<com.google.android.material.textfield.TextInputLayout
    style="@style/Widget.MaterialComponents.TextInputEditText.FilledBox"
    app:boxBackgroundColor="@color/gray_light"
/>
```

### Quitar icono de limpieza (email):
```xml
<com.google.android.material.textfield.TextInputLayout
    app:endIconMode="none"          <!-- Cambiar aquí -->
/>
```

---

## 🎭 8. Agregar Tema Oscuro

Crea un archivo `app/src/main/res/values-night/colors.xml`:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="white">#121212</color>         <!-- Fondo oscuro -->
    <color name="black">#E0E0E0</color>         <!-- Texto claro -->
    <color name="primary">#64B5F6</color>       <!-- Azul más claro -->
    <color name="gray_light">#303030</color>
    <color name="gray_dark">#E0E0E0</color>
    <color name="hint_text">#757575</color>
</resources>
```

---

## 🔍 9. Validación de Campos

En `MainActivity.kt`, puedes mejorar la validación:

```kotlin
// Validar formato de email
fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

// Validar contraseña fuerte
fun isValidPassword(password: String): Boolean {
    return password.length >= 8 && 
           password.any { it.isUpperCase() } && 
           password.any { it.isDigit() }
}

// Usar en el listener:
loginButton.setOnClickListener {
    val email = emailEditText.text.toString().trim()
    val password = passwordEditText.text.toString().trim()
    
    when {
        email.isEmpty() -> showError("Email requerido")
        !isValidEmail(email) -> showError("Email inválido")
        password.isEmpty() -> showError("Contraseña requerida")
        !isValidPassword(password) -> showError("Contraseña muy débil")
        else -> performLogin(email, password)
    }
}
```

---

## 🌐 10. Agregar Traducción (i18n)

### Crear archivo para español completo

`app/src/main/res/values-es/strings.xml`:
```xml
<resources>
    <string name="app_name">Mi Aplicación</string>
    <string name="login_title">Iniciar Sesión</string>
    <string name="email_hint">Correo Electrónico</string>
    <string name="password_hint">Contraseña</string>
    <string name="login_button">Iniciar Sesión</string>
    <string name="forgot_password">¿Olvidaste tu contraseña?</string>
    <string name="no_account">¿No tienes cuenta? <b>Regístrate</b></string>
</resources>
```

### Crear para inglés

`app/src/main/res/values-en/strings.xml`:
```xml
<resources>
    <string name="app_name">My Application</string>
    <string name="login_title">Sign In</string>
    <string name="email_hint">Email Address</string>
    <string name="password_hint">Password</string>
    <string name="login_button">Sign In</string>
    <string name="forgot_password">Forgot your password?</string>
    <string name="no_account">Don't have an account? <b>Sign Up</b></string>
</resources>
```

---

## 🎯 11. Ejemplos Completos

### Tema Rojo Profesional
```xml
<!-- colors.xml -->
<color name="primary">#D32F2F</color>
<color name="primary_dark">#B71C1C</color>
<color name="accent">#FF6F00</color>
<color name="gray_light">#FAFAFA</color>
<color name="gray_dark">#212121</color>
```

### Tema Purple Moderno
```xml
<!-- colors.xml -->
<color name="primary">#9C27B0</color>
<color name="primary_dark">#7B1FA2</color>
<color name="accent">#FF4081</color>
<color name="gray_light">#F3E5F5</color>
<color name="gray_dark">#311B92</color>
```

### Tema Tech Azul-Gris
```xml
<!-- colors.xml -->
<color name="primary">#1976D2</color>
<color name="primary_dark">#1565C0</color>
<color name="accent">#00BCD4</color>
<color name="gray_light">#ECEFF1</color>
<color name="gray_dark">#263238</color>
```

---

## ✅ Checklist de Personalización

- [ ] Cambiar logo
- [ ] Ajustar colores del tema
- [ ] Cambiar textos
- [ ] Ajustar tamaños
- [ ] Validar campos mejorada
- [ ] Agregar tema oscuro
- [ ] Agregar traducciones
- [ ] Probar en diferentes dispositivos
- [ ] Compilar y probar

---

## 📝 Notas Importantes

1. **Siempre usar recursos (colors.xml, strings.xml)**
   - No hardcodees colores o textos en el layout

2. **Respetar Material Design**
   - Mantener espacios mínimos de 48x48dp en elementos táctiles
   - Usar colores con contraste suficiente

3. **Accesibilidad**
   - Agregar content descriptions a imágenes
   - Asegurar que los textos sean legibles

4. **Compatibilidad**
   - Probar en minSdk 24 en adelante
   - Usar Material Components

5. **Performance**
   - No agregar muchos drawables sin optimizar
   - Usar VectorDrawables cuando sea posible

---

**¡Disfruta personalizando tu login!** 🚀


