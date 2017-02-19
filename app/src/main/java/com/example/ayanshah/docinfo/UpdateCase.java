package com.example.ayanshah.docinfo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCase extends AppCompatActivity {

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

        final EditText oeR1 = (EditText) findViewById(R.id.oeR1);
        final EditText oeR2 = (EditText) findViewById(R.id.oeR2);
        final EditText oeR3 = (EditText) findViewById(R.id.oeR3);
        final EditText oeL1 = (EditText) findViewById(R.id.oeL1);
        final EditText oeL2 = (EditText) findViewById(R.id.oeL2);
        final EditText oeL3 = (EditText) findViewById(R.id.oeL3);
        final EditText asL1 = (EditText) findViewById(R.id.asL1);
        final EditText asL2 = (EditText) findViewById(R.id.asL2);
        final EditText asL3 = (EditText) findViewById(R.id.asL3);
        final EditText asL4 = (EditText) findViewById(R.id.asL4);
        final EditText asL5 = (EditText) findViewById(R.id.asL5);
        final EditText asR1 = (EditText) findViewById(R.id.asR1);
        final EditText asR2 = (EditText) findViewById(R.id.asR2);
        final EditText asR3 = (EditText) findViewById(R.id.asR3);
        final EditText asR4 = (EditText) findViewById(R.id.asR4);
        final EditText asR5 = (EditText) findViewById(R.id.asR5);
        final EditText slamp = (EditText) findViewById(R.id.sLamp);
        final EditText refug = (EditText) findViewById(R.id.reUG);
        final EditText fnds = (EditText) findViewById(R.id.fnds);
        final EditText advt = (EditText) findViewById(R.id.advTr);
        final EditText history = (EditText) findViewById(R.id.history);
        final EditText comments = (EditText) findViewById(R.id.comments);

        mydb = new DBinfo(this);
        String caseId = getIntent().getStringExtra("id");
        Log.d("tag2",caseId);
        Cursor values = mydb.getBasicData(caseId);
        values.moveToFirst();
        int count = values.getCount();
        Log.d("tag4",caseId);
        if(count>0) {
            Cursor specificValues = mydb.getSpecificData(caseId);
            specificValues.moveToFirst();

            caseNum.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_ID)));
            caseNum.setEnabled(false);
            name.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_NAME)));
            age.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_AGE)));
            email.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_EMAIL)));
            sex.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_SEX)));
            ref.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_REF)));
            date.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_date)));
            address.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_ADDRESS)));
            phone.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_PHONE)));
            complaints.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_complaints)));


            oeL1.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OEL1)));
            oeL2.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OEL2)));
            oeL3.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OEL3)));
            oeR1.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OER1)));
            oeR2.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OER2)));
            oeR3.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OER3)));
            asL1.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASL1)));
            asL2.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASL2)));
            asL3.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASL3)));
            asL4.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASL4)));
            asL5.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASL5)));
            asR1.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASR1)));
            asR2.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASR2)));
            asR3.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASR3)));
            asR4.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASR4)));
            asR5.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ASR5)));
            slamp.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_SLAMP)));
            refug.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_REFUG)));
            fnds.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_FNDS)));
            advt.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_ADVT)));
            history.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_HISTORY)));
            comments.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_COMMENTS)));

        }
        else
            Toast.makeText(getApplicationContext(), "no case "+ caseId,
                    Toast.LENGTH_SHORT).show();







        Button add = (Button) findViewById(R.id.csAdd);
        add.setText("Update");
        caseNum.setEnabled(false);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.updateCase(caseNum.getText().toString(), name.getText().toString(), email.getText().toString(), address.getText().toString(), age.getText().toString(), sex.getText().toString()
                        , ref.getText().toString(), date.getText().toString(), phone.getText().toString(), complaints.getText().toString());

                mydb.updateSpecifics(caseNum.getText().toString(), oeR1.getText().toString(), oeR2.getText().toString(), oeR3.getText().toString(), oeL1.getText().toString(), oeL2.getText().toString(),
                        oeL3.getText().toString(), asR1.getText().toString(), asR2.getText().toString(), asR3.getText().toString(),
                        asR4.getText().toString(), asR5.getText().toString(), asL1.getText().toString(), asL2.getText().toString(), asL3.getText().toString(), asL4.getText().toString(), asL5.getText().toString(),
                        slamp.getText().toString(), refug.getText().toString(), fnds.getText().toString(), advt.getText().toString(),history.getText().toString(),comments.getText().toString());

                Toast.makeText(getApplicationContext(), "done",
                        Toast.LENGTH_SHORT).show();

                finish();
            }
        });


    }
}
