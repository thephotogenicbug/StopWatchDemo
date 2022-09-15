package com.naveen.stopwatchdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naveen.stopwatchdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startOrStop()
        }
        binding.btnReset.setOnClickListener {
            reset()
        }
    }

    private fun startOrStop(){
        if(isStarted){
            stop()
        } else{
            start()
        }
    }

    private fun start(){
        binding.btnStart.text = "Stop"
        isStarted = true
    }
    private fun stop(){
        binding.btnStart.text = "Start"
        isStarted = false

    }
    private fun reset(){

    }
}