package com.example.log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import android.widget.Toast
import com.example.education_hackathon.LoginActivity
import com.example.education_hackathon.MainActivity
import com.example.education_hackathon.R
import com.example.education_hackathon.databinding.ActivityCreateBinding
import com.google.firebase.auth.FirebaseAuth


class CreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        binding= ActivityCreateBinding.inflate(layoutInflater)
        val view=  binding.root
        setContentView(view)


        val toolbar: Toolbar = binding.tbCrearCuenta
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Crear cuenta")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener{

            val intent = Intent(view.getContext(), LoginActivity::class.java)
            startActivity(intent)
        }

        val btnCrearcuenta : Button = binding.btnCrearcuenta
        btnCrearcuenta.setOnClickListener {
            val intent = Intent(view.getContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }

    //Validar que los campos no sean nulos
    fun valida(): Boolean {
        try {
            var validaok: Boolean = false

             //-- El email es un valor requerido
            if (binding.tvEmailCuenta.text?.length?.equals(0)!!) {
                binding.tvEmailCuenta.requestFocus()
                binding.tvEmailCuenta.setError("Email es un valor requerido")
                return validaok
            }
            //-- La contraseña es un valor requerido
            if (binding.tvPasswordCuenta.text?.length?.equals(0)!!) {
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("Debe ingresar una contraseña")
                return validaok
            }   //la contraseña debe de tener entre 6 y 15 caracteres
            else if (binding.tvPasswordCuenta.length() <6){
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("La contraseña debe tener almenos 6 caracteres")
                return validaok
            } else if (binding.tvPasswordCuenta.length() >15) {
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("Demasiados Caracteres")
                return validaok
            }

             //La confirmación de contraseña es un valor requerido
            if (binding.tvConfPassword.text?.length?.equals(0)!!) {
                binding.tvConfPassword.requestFocus()
                binding.tvConfPassword.setError("Debe ingresar la confirmación de contraseña")
                return validaok
            }
            //La contraseña debe ser igual a la confirmación de la contraseña
            val strpassword: String = if (binding.tvPasswordCuenta.text !=
                null) binding.tvPasswordCuenta.text.toString() else ""
            val strpasswordconfirmar:String = if (binding.tvConfPassword.text
                != null) binding.tvConfPassword.text.toString() else ""
            if (strpassword.equals(strpasswordconfirmar) == false)
            {
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("El Password y la confirmación deben coincidir")
                return validaok
            }
            validaok = true
            return validaok
        } catch (e: Exception) {
            e.message?.let { Log.e("Error en valida", it) };
            return false;
        }

    }

    //-- Metodo agregar Usuario
    fun addCuentaUsuario()
    {
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.createUserWithEmailAndPassword(binding.tvEmailCuenta.text
            .toString(), binding.tvPasswordCuenta.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "El usuario ha sido creado",
                        Toast.LENGTH_SHORT).show();
                    finish()
                } else {
                    Toast.makeText(this, "El usuario no ha sido creado",
                        Toast.LENGTH_SHORT).show();
                }
            }
    }

}