package com.example.education_hackathon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.education_hackathon.databinding.ActivityLoginBinding
import com.example.log.CreateActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        val view=  binding.root
        setContentView(view)

        //Validar que los campos no sean nulos
        fun validarUsuario(): Boolean {
            try {
                var validaok: Boolean = false
                //-- El email es un valor requerido
                if (binding.edituser.text?.length?.equals(0)!!) {
                    binding.edituser.requestFocus()
                    binding.edituser.setError("Debe ingresar su correo electrónico")
                    return validaok
                }
                //-- La contraseña es un valor requerido
                if (binding.editPassword.text?.length?.equals(0)!!) {
                    binding.editPassword.requestFocus()
                    binding.editPassword.setError("Debe ingresar una contraseña")
                    return validaok
                }
                validaok = true
                return validaok
            } catch (e: Exception) {
                e.message?.let { Log.e("Error en valida", it) };
                return false;
            }
        }

        //
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener({ v ->
            if (validarUsuario().equals(true)) {
                firebaseAuth.signInWithEmailAndPassword(binding.edituser.text.toString(),
                    binding.editPassword.text.toString()).addOnCompleteListener(this, OnCompleteListener<AuthResult> {
                        task -> if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();binding.edituser.setText("")
                    binding.edituser.setText("") }
                else {
                    Toast.makeText(this, "El usuario y clave no existen", Toast.LENGTH_SHORT).show(); } }) }
        })
        //------------------

        val CrearCuenta : TextView = binding.tvCreaUnaAqui
        CrearCuenta.setOnClickListener { v ->
            val intent = Intent(v.getContext(), CreateActivity::class.java)
            startActivity(intent)
        }
    }
}