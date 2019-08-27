package com.example.ratatouille;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class activity_Ratatouille extends AppCompatActivity {
    ProgressBar progressBar;
    private int progreso = 0;
    private Handler handler = new Handler();
    private int delayMillis = 50;
    boolean finishProgress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ratatouille);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            public void run() {
                while (progreso < 100) {
                    progreso += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progreso);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(delayMillis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                finishProgress = true;
                Log.i("Progreso","Terminado");
                //TODO lanzar actividad de inicio.
                
            }
        }).start();
    }
}
