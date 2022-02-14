package com.ludmilla.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Chronometer
import com.ludmilla.cronometro.databinding.ActivityMainBinding
// ================== SYNTHETICS =======================
//Atençao: O SYNTHETICS É CONSIDERADO COMO OBSOLETO
//Para utilizar o Synthetics, é necessario colocar esse import abaixo
//e no build.grade id 'kotlin-android-extensions' e sincronizar. Apos isso,
//colocar diretamente o id das variaveis do xml no evento de onClick
//exemplo: pause.setOnClickListener

//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var running = false
    var pause: Long = 0

// ========FINDVIEWBYID===========
//Para Utilizar o findViewById, é necessario criar as variaveis abaixo
//e chama-las dentro do OnCreate
/*
    lateinit var cronometro: Chronometer
    lateinit var iniciar: Button
    lateinit var pausar: Button
    lateinit var zerar: Button
*/

//======== UTILIZANDO VIEWBINDING =============
//Tambem sera necessario colocar no arquivo build.gradle
//  buildFeatures{
//        viewBinding true
//    }
//E sincronizar

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//Para utilizar o Synthetics ou  findViewById, é necessario descomentar
//a linha abaixo

        //setContentView(R.layout.activity_main)

// Utilizando findViewById dentro do OnCreate, conforme citado
// E as variaveis foram criadas para serem chamadas no OnClick
//exemplo: iniciar.setOnClickListener

/*
        cronometro = findViewById(R.id.chronometer)
        iniciar = findViewById(R.id.btnStart)
        pausar = findViewById(R.id.btnPause)
        zerar = findViewById(R.id.btnZero)
*/

       binding.btnStart.setOnClickListener {
            IniciarCronometro()
        }

        binding.btnPause.setOnClickListener {
            PausarCronometro()
        }

        binding.btnZero.setOnClickListener {
            ZerarCronometro()
        }

    }

    private fun IniciarCronometro() {
        if (!running) {
            binding.chronometer.base = SystemClock.elapsedRealtime() - pause
            binding.chronometer.start()
            running = true
        }
    }
    private fun PausarCronometro(){
        if(running){
        binding.chronometer.stop()
        pause = SystemClock.elapsedRealtime() - binding.chronometer.base
        running = false
        }
    }
    private fun ZerarCronometro(){
        binding.chronometer.base = SystemClock.elapsedRealtime()
        pause = 0
    }


}