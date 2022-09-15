package com.naveen.stopwatchdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.*

class StopWatchService : Service() {
    override fun onBind(p0: Intent?): IBinder? = null
    // instance of Timer class
    private val timer = Timer()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }
    // companion object
    companion object{
        const val CURRENT_TIME = "current time"
        const val UPDATED_TIME = "updated time"
    }

    private inner class StopWatchTimerTask(private var time:Double):TimerTask(){
        override fun run() {
            val intent = Intent(UPDATED_TIME)
            time++ // increase time by +1
            intent.putExtra(UPDATED_TIME,time) // save current time to the intent
            sendBroadcast(intent)
        }

    }
}