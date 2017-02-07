package com.example.ayanshah.docinfo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchList extends AppCompatActivity {
    DBinfo db;
    String name;
    public ListView obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        db = new DBinfo(this);
        name = getIntent().getStringExtra("name");
        Cursor values = db.getCaseList(name);
        values.moveToFirst();
        int count = values.getCount();
        if(count<1){
            Toast.makeText(getApplicationContext(), "no case ",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            ArrayList<String> nameArray = new ArrayList<String>();
            ArrayList<String> idArray = new ArrayList<String>();
            values.moveToFirst();
            while(values.isAfterLast()==false){
                nameArray.add(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_NAME)));
                idArray.add(values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_ID)));
                values.moveToNext();
            }

            CustomListAdapter customListAdapter = new CustomListAdapter(this, idArray, nameArray);
            obj = (ListView) findViewById(R.id.caseSearchList);
            obj.setAdapter(customListAdapter);
            obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(getApplicationContext(), ViewCase.class);
                    intent.putExtra("id", obj.getItemAtPosition(position).toString());
                    startActivity(intent);

                }
            });
        }






    }
}
