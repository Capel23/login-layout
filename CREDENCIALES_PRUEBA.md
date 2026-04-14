# 🔐 CREDENCIALES DE PRUEBA - ProyectoApp

## ✅ Credenciales Válidas para Testing

### Usuario de Prueba:
```
Email:      usuario@mangup.com
Contraseña: 123456
```

---

## 📋 Cómo Usar las Credenciales

1. **Al iniciar la aplicación:**
   - Las credenciales se cargan automáticamente
   - Los campos email y contraseña vienen pre-llenados

2. **Para navegar:**
   - Simplemente haz click en "Iniciar Sesión"
   - Se abrirá automáticamente la pantalla de Ecommerce

3. **Para probar de nuevo:**
   - Click en "Logout" en la pantalla de Home
   - Regresarás automáticamente al Login
   - Las credenciales se recargarán

---

## ✨ Cambios Realizados

### MainActivity.kt
```kotlin
// Se agregó validación específica:
companion object {
    private const val VALID_EMAIL = "usuario@mangup.com"
    private const val VALID_PASSWORD = "123456"
}

// Auto-llenar campos:
emailEditText.setText(VALID_EMAIL)
passwordEditText.setText(VALID_PASSWORD)

// Validar credenciales exactas:
if (email == VALID_EMAIL && password == VALID_PASSWORD) {
    // Navegar a HomeActivity
} else {
    // Mostrar mensaje de error con credenciales válidas
}
```

---

## 🧪 Casos de Prueba

### ✅ Caso 1: Credenciales Correctas
```
Input:  usuario@mangup.com / 123456
Output: Navegación a HomeActivity
Toast:  "¡Bienvenido usuario@mangup.com!"
```

### ❌ Caso 2: Email Incorrecto
```
Input:  otro@email.com / 123456
Output: Toast mostrando credenciales válidas
```

### ❌ Caso 3: Contraseña Incorrecta
```
Input:  usuario@mangup.com / 999999
Output: Toast mostrando credenciales válidas
```

### ❌ Caso 4: Campos Vacíos
```
Input:  (vacío) / (vacío)
Output: Toast pidiendo llenar los campos
```

---

## 🔄 Flujo de Navegación

```
┌─────────────────────────────────┐
│        LOGIN ACTIVITY           │
├─────────────────────────────────┤
│ Email: usuario@mangup.com       │
│ Pass:  123456                   │
│                                 │
│ [Iniciar Sesión]                │
└────────────┬────────────────────┘
             │
             ↓ (Intent)
┌─────────────────────────────────┐
│       HOME ACTIVITY             │
│     (Ecommerce con 8 productos) │
└────────────┬────────────────────┘
             │
             ↓ (Click Logout)
┌─────────────────────────────────┐
│        LOGIN ACTIVITY (nuevamente)
│    (Credenciales recargadas)    │
└─────────────────────────────────┘
```

---

## 🧪 Pruebas Realizadas

### ✅ Validación de Email
- [x] Email correcto permite continuar
- [x] Email incorrecto muestra error
- [x] Email vacío muestra error

### ✅ Validación de Contraseña
- [x] Contraseña correcta permite continuar
- [x] Contraseña incorrecta muestra error
- [x] Contraseña vacía muestra error

### ✅ Navegabilidad
- [x] Login → Home funciona
- [x] Datos del usuario se pasan correctamente
- [x] Home → Login funciona
- [x] Logout limpia la sesión

### ✅ UI/UX
- [x] Campos se llenan automáticamente
- [x] Toast muestra mensajes claros
- [x] Navegación es suave
- [x] Colores se ven correctamente

---

## 📝 Notas Importantes

⚠️ **IMPORTANTE:** Las credenciales se cargan automáticamente
- No necesitas escribir nada
- Solo haz click en "Iniciar Sesión"
- La app navegará automáticamente al Home

💡 **Para cambiar credenciales:**
- Edita el archivo `MainActivity.kt`
- Modifica las constantes `VALID_EMAIL` y `VALID_PASSWORD`
- Recompila la aplicación

---

## 🚀 Cómo Ejecutar

1. **Abrir Android Studio**
2. **Cargar el proyecto ProyectoApp**
3. **Click en "Run"** o `Shift + F10`
4. **Seleccionar emulador o dispositivo**
5. **La app se abrirá con credenciales pre-llenadas**
6. **Click en "Iniciar Sesión"**
7. **¡Listo! Ya estás en el Home de Ecommerce**

---

## 📱 Requisitos Mínimos

- Android 9.0 (API 28) o superior
- 100 MB de espacio libre
- Conexión de internet (opcional, la app funciona offline)

---

## 🎯 Resultado Esperado

Al ejecutar la app con estas credenciales:

1. ✅ Se abrirá la pantalla de Login
2. ✅ Los campos estarán pre-llenados
3. ✅ Al hacer click en "Iniciar Sesión" navegará a Home
4. ✅ Se mostrará mensaje de bienvenida: "¡Bienvenido usuario@mangup.com!"
5. ✅ Se verán los 8 productos MANGUP
6. ✅ El botón Logout regresa a Login
7. ✅ Todo funciona sin errores

---

**Credenciales de Prueba Listas ✅**
**Fecha:** Abril 10, 2026
**Estado:** Verificado y Funcional

---

Úsalas para probar la navegabilidad de la app 🚀

