package com.peter.Farejudge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button button;
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
    }
    public void proceedTo() {
        Intent intent = new Intent (this,Login.class);
        startActivity(intent);
        Toast.makeText(this, "Back to where you stop", Toast.LENGTH_LONG).show();
    }
}

