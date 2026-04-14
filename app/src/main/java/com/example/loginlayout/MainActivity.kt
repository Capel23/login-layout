package com.example.loginlayout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    
    // Credenciales de prueba
    companion object {
        private const val VALID_EMAIL = "usuario@mangup.com"
        private const val VALID_PASSWORD = "123456"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener referencias de los elementos
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText)
        val loginButton = findViewById<MaterialButton>(R.id.loginButton)
        val forgotPasswordLink = findViewById<android.widget.TextView>(R.id.forgotPassword)
        val registerLink = findViewById<android.widget.TextView>(R.id.registerText)
        
        // Llenar credenciales de prueba automáticamente
        emailEditText.setText(VALID_EMAIL)
        passwordEditText.setText(VALID_PASSWORD)

        // Configurar click listener para el botón de login
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validación básica
            when {
                email.isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Por favor ingresa tu correo electrónico",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Por favor ingresa tu contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                email == VALID_EMAIL && password == VALID_PASSWORD -> {
                    // Credenciales correctas - Navegar a HomeActivity
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("USER_EMAIL", email)
                    startActivity(intent)
                    Toast.makeText(
                        this,
                        "¡Bienvenido $email!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    // Credenciales incorrectas
                    Toast.makeText(
                        this,
                        "Credenciales inválidas. Usuario: usuario@mangup.com | Contraseña: 123456",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        // Configurar click listener para contraseña olvidada
        forgotPasswordLink.setOnClickListener {
            Toast.makeText(
                this,
                "Para recuperar tu contraseña, contacta al soporte",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Configurar click listener para registro
        registerLink.setOnClickListener {
            Toast.makeText(
                this,
                "Funcionalidad de registro próximamente disponible",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}