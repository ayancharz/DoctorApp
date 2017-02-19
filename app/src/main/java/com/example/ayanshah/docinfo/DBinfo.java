package com.example.ayanshah.docinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Ayan Shah on 1/23/2017.
 */

public class DBinfo extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "CASEDETAILS.db";
    public static final String CONTACTS_TABLE_NAME = "BasicInfo";
    public static final String CASE_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_CASE_NO = "caseno";
    public static final String CASE_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CASE_COLUMN_ADDRESS = "address";
    public static final String CASE_COLUMN_AGE = "age";
    public static final String CASE_COLUMN_SEX = "sex";
    public static final String CASE_COLUMN_REF = "ref";
    public static final String CASE_COLUMN_date = "date";
    public static final String CASE_COLUMN_PHONE = "phone";
    public static final String CASE_COLUMN_complaints = "complaints";


    public static final String SPECIFICS_TABLE_NAME = "SpecificInfo";
    public static final String SPECIFICS_COLUMN_OER1 = "oeR1";
    public static final String SPECIFICS_COLUMN_OER2 = "oeR2";
    public static final String SPECIFICS_COLUMN_OER3 = "oeR3";
    public static final String SPECIFICS_COLUMN_OEL1 = "oeL1";
    public static final String SPECIFICS_COLUMN_OEL2 = "oeL2";
    public static final String SPECIFICS_COLUMN_OEL3 = "oeL3";
    public static final String SPECIFICS_COLUMN_ASR1 = "asR1";
    public static final String SPECIFICS_COLUMN_ASR2 = "asR2";
    public static final String SPECIFICS_COLUMN_ASR3 = "asR3";
    public static final String SPECIFICS_COLUMN_ASR4 = "asR4";
    public static final String SPECIFICS_COLUMN_ASR5 = "asR5";
    public static final String SPECIFICS_COLUMN_ASL1 = "asL1";
    public static final String SPECIFICS_COLUMN_ASL2 = "asL2";
    public static final String SPECIFICS_COLUMN_ASL3 = "asL3";
    public static final String SPECIFICS_COLUMN_ASL4 = "asL4";
    public static final String SPECIFICS_COLUMN_ASL5 = "asL5";
    public static final String SPECIFICS_COLUMN_SLAMP = "slamp";
    public static final String SPECIFICS_COLUMN_REFUG = "refug";
    public static final String SPECIFICS_COLUMN_FNDS = "fnds";
    public static final String SPECIFICS_COLUMN_ADVT = "advt";
    public static final String SPECIFICS_COLUMN_HISTORY = "history";
    public static final String SPECIFICS_COLUMN_COMMENTS = "comments";




    public DBinfo (Context context) {
        super(context, DATABASE_NAME, null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table BasicInfo " + "(id integer primary key, name text, email text, address text, age text, sex text, ref text, date text, phone text, complaints text)");
        db.execSQL("create table SpecificInfo " + "(id integer primary key, oeR1 text, oeL1 text, oeR2 text, oeL2 text, oeR3 text, oeL3 text, asR1 text, " +
                "asL1 text, asR2 text, asL2 text, asR3 text, asL3 text, asR4 text, asL4 text, asR5 text, asL5 text, slamp text, refug text, fnds text, advt text, history text, comments text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS BasicInfo");
        //db.execSQL("DROP TABLE IF EXISTS SpecificInfo");
        //onCreate(db);
        String upgradequery = "ALTER TABLE SpecificInfo ADD COLUMN history text";
        db.execSQL(upgradequery);
        upgradequery = "ALTER TABLE SpecificInfo ADD COLUMN comments text ";
        db.execSQL(upgradequery);
    }

    public boolean insertCase (String caseno, String name, String email, String address, String age,
                               String sex, String ref, String date, String phone, String complaints ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);

        contentValues.put("address", address);
        contentValues.put("age", age);
        contentValues.put("sex", sex);
        contentValues.put("ref", ref);
        contentValues.put("date", date);
        contentValues.put("complaints", complaints);
        db.insert("BasicInfo", null, contentValues);
        return true;
    }

    public boolean insertSpecifics(String caseno, String oer1, String oer2, String oer3, String oel1,
                                   String oel2, String oel3, String asr1, String asr2, String asr3,
                                   String asr4, String asr5, String asl1, String asl2, String asl3, String asl4, String asl5,
                                   String slamp, String refug, String fnds, String advt, String history, String comments ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(SPECIFICS_COLUMN_OER1,oer1 );
        contentValues.put(SPECIFICS_COLUMN_OER2, oer2);
        contentValues.put(SPECIFICS_COLUMN_OER3, oer3);
        contentValues.put(SPECIFICS_COLUMN_OEL1, oel1);
        contentValues.put(SPECIFICS_COLUMN_OEL2, oel2 );
        contentValues.put(SPECIFICS_COLUMN_OEL3, oel3);
        contentValues.put(SPECIFICS_COLUMN_ASL1, asl1);
        contentValues.put(SPECIFICS_COLUMN_ASL2, asl2);
        contentValues.put(SPECIFICS_COLUMN_ASL3, asl3);
        contentValues.put(SPECIFICS_COLUMN_ASL4, asl4);
        contentValues.put(SPECIFICS_COLUMN_ASL5, asl5);
        contentValues.put(SPECIFICS_COLUMN_ASR1, asr1);
        contentValues.put(SPECIFICS_COLUMN_ASR2, asr2);
        contentValues.put(SPECIFICS_COLUMN_ASR3, asr3);
        contentValues.put(SPECIFICS_COLUMN_ASR4, asr4);
        contentValues.put(SPECIFICS_COLUMN_ASR5, asr5);
        contentValues.put(SPECIFICS_COLUMN_SLAMP, slamp);
        contentValues.put(SPECIFICS_COLUMN_REFUG, refug);
        contentValues.put(SPECIFICS_COLUMN_ADVT, advt);
        contentValues.put(SPECIFICS_COLUMN_FNDS, fnds);
        contentValues.put(SPECIFICS_COLUMN_HISTORY, history);
        contentValues.put(SPECIFICS_COLUMN_COMMENTS, comments);
        db.insert("SpecificInfo", null, contentValues);

        return true;
    }


    public boolean updateCase(String caseno, String name, String email, String address, String age,
                               String sex, String ref, String date, String phone, String complaints)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);

        contentValues.put("address", address);
        contentValues.put("age", age);
        contentValues.put("sex", sex);
        contentValues.put("ref", ref);
        contentValues.put("date", date);
        contentValues.put("complaints", complaints);
        db.update("BasicInfo", contentValues,"id = ?",new String[] {caseno});
        return true;
    }

    public boolean updateSpecifics(String caseno, String oer1, String oer2, String oer3, String oel1,
                                   String oel2, String oel3, String asr1, String asr2, String asr3,
                                   String asr4, String asr5, String asl1, String asl2, String asl3, String asl4, String asl5,
                                   String slamp, String refug, String fnds, String advt, String history, String comments ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(SPECIFICS_COLUMN_OER1,oer1 );
        contentValues.put(SPECIFICS_COLUMN_OER2, oer2);
        contentValues.put(SPECIFICS_COLUMN_OER3, oer3);
        contentValues.put(SPECIFICS_COLUMN_OEL1, oel1);
        contentValues.put(SPECIFICS_COLUMN_OEL2, oel2 );
        contentValues.put(SPECIFICS_COLUMN_OEL3, oel3);
        contentValues.put(SPECIFICS_COLUMN_ASL1, asl1);
        contentValues.put(SPECIFICS_COLUMN_ASL2, asl2);
        contentValues.put(SPECIFICS_COLUMN_ASL3, asl3);
        contentValues.put(SPECIFICS_COLUMN_ASL4, asl4);
        contentValues.put(SPECIFICS_COLUMN_ASL5, asl5);
        contentValues.put(SPECIFICS_COLUMN_ASR1, asr1);
        contentValues.put(SPECIFICS_COLUMN_ASR2, asr2);
        contentValues.put(SPECIFICS_COLUMN_ASR3, asr3);
        contentValues.put(SPECIFICS_COLUMN_ASR4, asr4);
        contentValues.put(SPECIFICS_COLUMN_ASR5, asr5);
        contentValues.put(SPECIFICS_COLUMN_SLAMP, slamp);
        contentValues.put(SPECIFICS_COLUMN_REFUG, refug);
        contentValues.put(SPECIFICS_COLUMN_ADVT, advt);
        contentValues.put(SPECIFICS_COLUMN_FNDS, fnds);
        contentValues.put(SPECIFICS_COLUMN_HISTORY, history);
        contentValues.put(SPECIFICS_COLUMN_COMMENTS, comments);
        db.update("SpecificInfo", contentValues, "id = ?", new String[]{caseno });

        return true;
    }


    public Cursor getBasicData(String caseno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("tag",caseno);

        Cursor values = db.rawQuery(" select * from BasicInfo where id = "+caseno+"", null);
        //values.moveToFirst();
        //Log.d("tag3", values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_NAME)));
        return values;
    }

    public Cursor getSpecificData(String caseno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("tagX",caseno);

        Cursor values = db.rawQuery(" select * from SpecificInfo where id = "+caseno+"", null);
        //values.moveToFirst();
        //Log.d("tag3", values.getString(values.getColumnIndex(DBinfo.CASE_COLUMN_NAME)));
        return values;
    }

    public Cursor getCaseList(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor values = db.rawQuery(" select id,name from BasicInfo where name like '%"+name+"%'",null);




        return values;
    }



}
