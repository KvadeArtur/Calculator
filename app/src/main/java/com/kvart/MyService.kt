package com.kvart

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import java.lang.UnsupportedOperationException

class MyService : Service() {

    lateinit var ambientMediaPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Не найдено")
    }

    override fun onCreate() {
        ambientMediaPlayer = MediaPlayer.create(this, R.raw.audio_button)
        ambientMediaPlayer.setLooping(false)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ambientMediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        ambientMediaPlayer.stop()
    }
}
