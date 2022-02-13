package com.ludmilla.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var running = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            IniciarCronometro()
        }

        btnPause.setOnClickListener {
            PausarCronometro()
        }

        btnZero.setOnClickListener {
            ZerarCronometro()
        }

    }

    private fun IniciarCronometro() {
        if (!running) {
            chronometer.base = SystemClock.elapsedRealtime() - pause
            chronometer.start()
            running = true
        }
    }
    private fun PausarCronometro(){
        if(running){
        chronometer.stop()
        pause = SystemClock.elapsedRealtime() - chronometer.base
        running = false
        }
    }
    private fun ZerarCronometro(){
        chronometer.base = SystemClock.elapsedRealtime()
        pause = 0
    }


}