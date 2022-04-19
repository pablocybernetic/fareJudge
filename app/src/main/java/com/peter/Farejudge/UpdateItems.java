package com.peter.Farejudge;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateItems extends AppCompatActivity {
    EditText name, contact, dob;

    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_items);
        name = findViewById(R.id.estname2);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteitem();
            }
        });

    }
    void deleteitem(){
        String nameTXT = name.getText().toString();
        Boolean checkudeletedata = DB.deletedata(nameTXT);
        if(checkudeletedata==true)
            Toast.makeText(UpdateItems.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(UpdateItems.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
    }
}