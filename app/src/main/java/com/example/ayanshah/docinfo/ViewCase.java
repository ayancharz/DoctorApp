package com.example.ayanshah.docinfo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewCase extends AppCompatActivity {

    DBinfo mydb;
    EditText caseNum;
    EditText name;
    EditText age;
    EditText sex;
    EditText ref;
    EditText date;
    EditText address;
    EditText phone;
    EditText complaints;
    EditText email;

    EditText oeR1;
    EditText oer2;
    EditText oer3;
    EditText oeL1;
    EditText oeL2;
    EditText oeL3;
    EditText asL1;
    EditText asL2;
    EditText asL3;
    EditText asL4;
    EditText asL5;
    EditText asR1;
    EditText asR2;
    EditText asR3;
    EditText asR4;
    EditText asR5;
    EditText slamp;
    EditText refug;
    EditText fnds;
    EditText advt;

    Button csAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_case);

        csAdd = (Button) findViewById(R.id.csAdd);
        csAdd.setEnabled(false);
        csAdd.setVisibility(View.INVISIBLE);
        caseNum = (EditText)findViewById(R.id.caseNum);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        age = (EditText)findViewById(R.id.age);
        sex = (EditText)findViewById(R.id.sex);
        ref = (EditText)findViewById(R.id.ref);
        date = (EditText)findViewById(R.id.date);
        address = (EditText)findViewById(R.id.address);
        phone = (EditText)findViewById(R.id.phone);
        complaints = (EditText)findViewById(R.id.complaints);

        oeR1 = (EditText)findViewById(R.id.oeR1);
        oer2 = (EditText)findViewById(R.id.oeR2);
        oer3 = (EditText)findViewById(R.id.oeR3);
        oeL1 = (EditText)findViewById(R.id.oeL1);
        oeL2 = (EditText)findViewById(R.id.oeL2);
        oeL3 = (EditText)findViewById(R.id.oeL3);
        asL1 = (EditText)findViewById(R.id.asL1);
        asL2 = (EditText)findViewById(R.id.asL2);
        asL3 = (EditText)findViewById(R.id.asL3);
        asL4 = (EditText)findViewById(R.id.asL4);
        asL5 = (EditText)findViewById(R.id.asL5);
        asR1 = (EditText)findViewById(R.id.asR1);
        asR2 = (EditText)findViewById(R.id.asR2);
        asR3 = (EditText)findViewById(R.id.asR3);
        asR4 = (EditText)findViewById(R.id.asR4);
        asR5 = (EditText)findViewById(R.id.asR5);
        slamp = (EditText)findViewById(R.id.sLamp);
        refug = (EditText)findViewById(R.id.reUG);
        fnds = (EditText)findViewById(R.id.fnds);
        advt = (EditText)findViewById(R.id.advTr);


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
            name.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_NAME)));
            age.setText(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_AGE)));
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
            oer2.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OER2)));
            oer3.setText(specificValues.getString(specificValues.getColumnIndex(DBinfo.SPECIFICS_COLUMN_OER3)));
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
        }
        else
            Toast.makeText(getApplicationContext(), "no case "+ caseId,
                    Toast.LENGTH_SHORT).show();




    }
}
