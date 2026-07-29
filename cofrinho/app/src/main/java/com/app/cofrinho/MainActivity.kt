package com.app.cofrinho

import android.annotation.SuppressLint
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
import com.app.cofrinho.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = CofrinhoDatabase.getDatabase(this)
        val cofrinhoDao = db.cofrinhoDao()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch(Dispatchers.IO){
            val busca = cofrinhoDao.count()
            if(busca == 0){
                cofrinhoDao.save(Cofrinho(nome = "Cofrinho", meta = 0.0))
            }
        }

        lifecycleScope.launch(Dispatchers.IO){
            val cofrinho = cofrinhoDao.findById(1)

            binding.txtNome.text = cofrinho.nome
            binding.txtTotal.text = "R$ " + cofrinhoDao.total(1).toString()
            binding.txtQtd.text = "Quantidade: " + cofrinhoDao.quantidade(1).toString()
            //biding.txtMeta.txt = "Meta: " + cofrinhoDao.total(1).toString()

            binding.txtM1.text = cofrinho.moeda1.toString()
            binding.txtM50.text = cofrinho.moeda50.toString()
            binding.txtM25.text = cofrinho.moeda25.toString()
            binding.txtM10.text = cofrinho.moeda10.toString()
            binding.txtM5.text = cofrinho.moeda5.toString()
            binding.txtN2.text = cofrinho.nota2.toString()
        }


        binding.btnBM1.setOnClickListener {
            var valor = binding.txtM1.text.toString().toLong()
            valor += 1
            binding.txtM1.setText(valor.toString())
        }

        binding.btnBM50.setOnClickListener {
            var valor = binding.txtM50.text.toString().toLong()
            valor += 1
            binding.txtM50.setText(valor.toString())
        }

        binding.btnBM25.setOnClickListener {
            var valor = binding.txtM25.text.toString().toLong()
            valor += 1
            binding.txtM25.setText(valor.toString())
        }

        binding.btnBM10.setOnClickListener {
            var valor = binding.txtM10.text.toString().toLong()
            valor += 1
            binding.txtM10.setText(valor.toString())
        }

        binding.btnBM5.setOnClickListener {
            var valor = binding.txtM5.text.toString().toLong()
            valor += 1
            binding.txtM5.setText(valor.toString())
        }

        binding.btnBN2.setOnClickListener {
            var valor = binding.txtN2.text.toString().toLong()
            valor += 1
            binding.txtN2.setText(valor.toString())
        }

        binding.btnAM1.setOnClickListener {
            lifecycleScope.launch {
                val busca = withContext(Dispatchers.IO){
                    cofrinhoDao.findById(1).moeda1
                }
                var valor = binding.txtM1.text.toString().toLong()
                valor -= 1
                if(valor < busca){
                    binding.txtM1.setText("0")
                }else{
                    binding.txtM1.setText(valor.toString())
                }
            }
        }

        binding.btnAM50.setOnClickListener {
            lifecycleScope.launch {
                val busca = withContext(Dispatchers.IO){
                    cofrinhoDao.findById(1).moeda50
                }
                var valor = binding.txtM50.text.toString().toLong()
                valor -= 1
                if(valor < busca){
                    binding.txtM50.setText("0")
                }else{
                    binding.txtM50.setText(valor.toString())
                }
            }
        }

        binding.btnAM25.setOnClickListener {
            lifecycleScope.launch {
                val busca = withContext(Dispatchers.IO){
                    cofrinhoDao.findById(1).moeda25
                }
                var valor = binding.txtM25.text.toString().toLong()
                valor -= 1
                if(valor < busca){
                    binding.txtM25.setText("0")
                }else{
                    binding.txtM25.setText(valor.toString())
                }
            }
        }

        binding.btnAM10.setOnClickListener {
            lifecycleScope.launch {
                val busca = withContext(Dispatchers.IO){
                    cofrinhoDao.findById(1).moeda10
                }
                var valor = binding.txtM10.text.toString().toLong()
                valor -= 1
                if(valor < busca){
                    binding.txtM10.setText("0")
                }else{
                    binding.txtM10.setText(valor.toString())
                }
            }
        }

        binding.btnAM5.setOnClickListener {
            lifecycleScope.launch {
                val busca = withContext(Dispatchers.IO){
                    cofrinhoDao.findById(1).moeda5
                }
                var valor = binding.txtM5.text.toString().toLong()
                valor -= 1
                if(valor < busca){
                    binding.txtM5.setText("0")
                }else{
                    binding.txtM5.setText(valor.toString())
                }
            }
        }

        binding.btnAN2.setOnClickListener {
            lifecycleScope.launch {
                val busca = withContext(Dispatchers.IO){
                    cofrinhoDao.findById(1).nota2
                }
                var valor = binding.txtN2.text.toString().toLong()
                valor -= 1
                if(valor < busca){
                    binding.txtN2.setText("0")
                }else{
                    binding.txtN2.setText(valor.toString())
                }
            }
        }


    }
}