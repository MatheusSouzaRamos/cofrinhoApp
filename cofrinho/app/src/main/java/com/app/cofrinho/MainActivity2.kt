package com.app.cofrinho

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.app.cofrinho.database.CofrinhoDatabase
import com.app.cofrinho.database.entity.Cofrinho
import com.app.cofrinho.databinding.ActivityMain2Binding
import com.app.cofrinho.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // binding para facilitar as chamadas
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = CofrinhoDatabase.getDatabase(this)
        val cofrinhoDao = db.cofrinhoDao()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        binding.btnEditar.setOnClickListener {
            val nome = binding.nomeCriar.text.toString().trim()
            val metaStr = binding.metaCriar.text.toString().trim()
            val meta = metaStr.toDoubleOrNull()


            if(!nome.isEmpty() && meta != null) {
                lifecycleScope.launch{
                    withContext(Dispatchers.IO){
                        cofrinhoDao.edit(1, nome = nome, meta = meta)
                    }
                }

                Toast.makeText(this,
                    "O Cofrinho foi editado!",
                    Toast.LENGTH_SHORT).show();
                finish()

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