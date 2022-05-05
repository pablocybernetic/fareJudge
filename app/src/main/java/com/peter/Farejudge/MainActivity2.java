package com.peter.Farejudge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {

    private Button button;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button) findViewById(R.id.btnContinue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                proceedTo();
            }
        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent (MainActivity2.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, 3500);


    }
    public void proceedTo() {
        Intent intent = new Intent (this,Login.class);
        startActivity(intent);
        Toast.makeText(this, "Back to where you stop", Toast.LENGTH_LONG).show();
    }
}

