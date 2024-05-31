package com.example.texttospeech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var textToSpeech: TextToSpeech
    lateinit var btn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        btn = findViewById(R.id.btn)

        textToSpeech = TextToSpeech(this) { status->
            if(status==TextToSpeech.SUCCESS) {
                Log.d("TextToSpeech","Initialization successful")
            } else {
                Log.d("TextToSpeech","Initialization Failed")
            }
        }

        textToSpeech.language = Locale.ENGLISH

        btn.setOnClickListener {
                textToSpeech.speak(editText.text.toString(), TextToSpeech.QUEUE_ADD,null);
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.shutdown()
    }


}