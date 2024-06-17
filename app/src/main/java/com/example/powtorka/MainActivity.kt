package com.example.powtorka

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.powtorka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val history = mutableListOf<String>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOblicz.setOnClickListener()
        {
            spalanie()
        }
        binding.buttonHistoria.setOnClickListener()
        {
            history()
        }
        }
        private fun spalanie()
        {
            var litry = binding.editTextLitres.text.toString().toDouble()
            var kilometry = binding.editTextKilometers.text.toString().toDouble()
            var cena = binding.editTextCost.text.toString().toDouble()
            var srednie = (litry/kilometry)*100
            var srednieText = "Średnie spalanie na 100km wynosi: %.2f".format(srednie)
            Toast.makeText(this,srednieText,Toast.LENGTH_SHORT).show()
            history.add("%.2f".format(srednie))
            var koszt = (litry*cena)/kilometry
            var kosztText = "Koszt za 1 kilometr wynosi: %.2f".format(koszt)
            Toast.makeText(this,kosztText,Toast.LENGTH_SHORT).show()
            history.add("%.2f".format(koszt))
        }
        private fun history()
        {
            Toast.makeText(this,history.toString(),Toast.LENGTH_SHORT).show()
            binding.historiaView.text = history.toString()
        }

    }
