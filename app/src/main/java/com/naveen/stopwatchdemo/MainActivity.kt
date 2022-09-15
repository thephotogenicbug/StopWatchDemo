package com.naveen.stopwatchdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naveen.stopwatchdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isStarted = false
    private lateinit var serviceIntent : Intent
    private var time = 0.0
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
        serviceIntent = Intent(applicationContext,StopWatchService::class.java)
    }

    private fun startOrStop(){
        if(isStarted){
            stop()
        } else{
            start()
        }
    }

    private fun start(){
        // update start fun
        serviceIntent.putExtra(StopWatchService.CURRENT_TIME,time)
        startService(serviceIntent)
        binding.btnStart.text = "Stop"
        isStarted = true
    }
    private fun stop(){
        stopService(serviceIntent)
        binding.btnStart.text = "Start"
        isStarted = false

    }
    private fun reset(){

    }
}