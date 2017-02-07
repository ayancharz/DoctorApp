package com.example.ayanshah.docinfo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * Created by Ayan Shah on 2/6/2017.
 */

public class CustomListAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final ArrayList<String> idArray;
    private final ArrayList<String> nameArray;

    public CustomListAdapter(Activity context, ArrayList<String> idArray,ArrayList<String>nameArray ) {
        super(context, R.layout.list_data_layout, idArray);
        this.context = context;
        this.idArray = idArray;
        this.nameArray = nameArray;
    }



    @Override
    public View getView(int pos, View v, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_data_layout,null,true);
        TextView idtext = (TextView) rowView.findViewById(R.id.listName);
        idtext.setText(idArray.get(pos));
        TextView nametext = (TextView) rowView.findViewById(R.id.listId);
        nametext.setText(nameArray.get(pos));
        return rowView;
    }

}

