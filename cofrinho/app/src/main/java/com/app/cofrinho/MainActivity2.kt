package com.app.cofrinho

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.cofrinho.databinding.ActivityMain2Binding
import com.app.cofrinho.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnCriar.setOnClickListener {
            val nome = binding.nomeCriar.text.toString().trim()
            val metaStr = binding.metaCriar.text.toString().trim()
            val meta = metaStr.toDoubleOrNull()
            val imagem = 1 // IMPLEMENTAR

            if(!nome.isEmpty() && meta != null && imagem != null) {
                Toast.makeText(this,
                    "Nome: $nome, Meta: $meta, Imagem: $imagem",
                    Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,
                    "Preencha todos os campos!",
                    Toast.LENGTH_SHORT).show();
            }
        }



        binding.btnRtn.setOnClickListener {
            finish()
        }
    }
}