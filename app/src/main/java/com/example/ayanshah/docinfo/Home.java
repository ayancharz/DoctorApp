package com.example.ayanshah.docinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {

DBinfo dBinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button searchCase = (Button) findViewById(R.id.searchCase);
        Button addCase = (Button) findViewById(R.id.addCase);
        dBinfo = new DBinfo(this);

        final EditText caseNum = (EditText) findViewById(R.id.caseNum);


        addCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCase.class);
                startActivity(intent);
            }
        });

        searchCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(caseNum.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Select a Case Number" ,
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), ViewCase.class);
                    intent.putExtra("caseno", caseNum.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}