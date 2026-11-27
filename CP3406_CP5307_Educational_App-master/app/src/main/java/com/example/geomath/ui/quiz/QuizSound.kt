package com.example.geomath.ui.quiz

import android.media.AudioManager
import android.media.ToneGenerator

class QuizSound {

    private val toneGenerator =
        ToneGenerator(
            AudioManager.STREAM_MUSIC,
            80
        )

    fun playCorrect() {
        toneGenerator.startTone(
            ToneGenerator.TONE_PROP_ACK
        )
    }

    fun playIncorrect() {
        toneGenerator.startTone(
            ToneGenerator.TONE_PROP_NACK
        )
    }

    fun release() {
        toneGenerator.release()
    }
}