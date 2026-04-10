package com.example.loginlayout

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
                else -> {
                    // Aquí iría la lógica de autenticación
                    Toast.makeText(
                        this,
                        "Iniciando sesión con: $email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        // Configurar click listener para contraseña olvidada
        forgotPasswordLink.setOnClickListener {
            Toast.makeText(
                this,
                "Funcionalidad de recuperación de contraseña",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Configurar click listener para registro
        registerLink.setOnClickListener {
            Toast.makeText(
                this,
                "Ir a la pantalla de registro",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}