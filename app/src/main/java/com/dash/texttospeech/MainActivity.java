package com.dash.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
     TextToSpeech texttospeech;
     Button button;
     EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =  findViewById(R.id.button);
         editText = findViewById(R.id.editText);
            texttospeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        int Language = texttospeech.setLanguage(Locale.UK);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Try Again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    String data = editText.getText().toString();
                    int status = texttospeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                }

            });
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            if (texttospeech != null) {
                texttospeech.stop();
                texttospeech.shutdown();
            }
        }

    }
