package com.example.ayanshah.docinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCase extends AppCompatActivity {
    private DBinfo mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_case);

        final EditText caseNum = (EditText) findViewById(R.id.caseNum);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText address = (EditText) findViewById(R.id.address);
        final EditText age = (EditText) findViewById(R.id.age);
        final EditText sex = (EditText) findViewById(R.id.sex);
        final EditText ref = (EditText) findViewById(R.id.ref);
        final EditText date = (EditText) findViewById(R.id.date);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final EditText complaints = (EditText) findViewById(R.id.complaints);

        final EditText oer1 = (EditText)findViewById(R.id.oeR1);
        final EditText oer2 = (EditText)findViewById(R.id.oeR2);
        final EditText oer3 = (EditText)findViewById(R.id.oeR3);
        final EditText oeL1 = (EditText)findViewById(R.id.oeL1);
        final EditText oeL2 = (EditText)findViewById(R.id.oeL2);
        final EditText oeL3 = (EditText)findViewById(R.id.oeL3);
        final EditText asL1 = (EditText)findViewById(R.id.asL1);
        final EditText asL2 = (EditText)findViewById(R.id.asL2);
        final EditText asL3 = (EditText)findViewById(R.id.asL3);
        final EditText asL4 = (EditText)findViewById(R.id.asL4);
        final EditText asL5 = (EditText)findViewById(R.id.asL5);
        final EditText asR1 = (EditText)findViewById(R.id.asR1);
        final EditText asR2 = (EditText)findViewById(R.id.asR2);
        final EditText asR3 = (EditText)findViewById(R.id.asR3);
        final EditText asR4 = (EditText)findViewById(R.id.asR4);
        final EditText asR5 = (EditText)findViewById(R.id.asR5);
        final EditText slamp = (EditText)findViewById(R.id.sLamp);
        final EditText refug = (EditText)findViewById(R.id.reUG);
        final EditText fnds = (EditText)findViewById(R.id.fnds);
        final EditText advt = (EditText)findViewById(R.id.advTr);


        Button add = (Button)findViewById(R.id.csAdd);

        mydb = new DBinfo(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.insertCase(caseNum.getText().toString(),name.getText().toString(),email.getText().toString(),address.getText().toString(),age.getText().toString(),sex.getText().toString()
                        ,ref.getText().toString(),date.getText().toString(),phone.getText().toString(),complaints.getText().toString());

                mydb.insertSpecifics(caseNum.getText().toString(),oer1.getText().toString(), oer2.getText().toString(), oer3.getText().toString(), oeL1.getText().toString(), oeL2.getText().toString(),
                        oeL3.getText().toString(), asR1.getText().toString(), asR2.getText().toString(), asR3.getText().toString(),
                        asR4.getText().toString(), asR5.getText().toString(), asL1.getText().toString(), asL2.getText().toString(), asL3.getText().toString(), asL4.getText().toString(), asL5.getText().toString(),
                        slamp.getText().toString(), refug.getText().toString(), fnds.getText().toString(), advt.getText().toString());

                Toast.makeText(getApplicationContext(), "done",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
