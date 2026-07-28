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
import com.app.cofrinho.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
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

        binding.btnNew.setOnClickListener {

            lifecycleScope.launch(Dispatchers.IO){
                val busca = cofrinhoDao.findAll().size

                if(busca >= 4){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity,
                            "Só são permitidos 4 Cofrinhos!",
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                }else{
                    irParaTelaCadastro()
                }



            }

//
        }
    }

    private fun irParaTelaCadastro(){
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)
    }
}