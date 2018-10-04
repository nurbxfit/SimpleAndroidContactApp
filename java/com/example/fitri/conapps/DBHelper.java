package com.example.fitri.conapps;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text,phone text,email text,place text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertContact (String name, String phone, String email,String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("place", place);
        db.insert("contacts", null, contentValues);
        return true;
    }

    public List<ContactInfo> getData(String name) {
        List<ContactInfo> searchResult = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selecrQuery = "select * from contacts where "+CONTACTS_COLUMN_NAME + " LIKE '%"+name+"%' ";
        Cursor res =  db.rawQuery(selecrQuery, null );

        if(res.moveToFirst())
        {
            do{
                ContactInfo contactInfo = new ContactInfo(Integer.parseInt(res.getString(0)),res.getString(1)
                ,res.getString(2),res.getString(3),res.getString(4));

                searchResult.add(contactInfo);
            }while(res.moveToNext());
        }


        return searchResult;
    }

    public ContactInfo getDataByID(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("INSIDE DATABASE: ", "Before getDatabyID" );
        Cursor result =  db.rawQuery( "select * from contacts where id="+id+"", null );
        Log.d("INSIDE DATABASE: ", "After getDatabyID" );
        result.moveToFirst();
        ContactInfo contactInfo = new ContactInfo(Integer.parseInt(result.getString(0)),result.getString(1),result.getString(2)
                ,result.getString(3),result.getString(4));

        Log.d("INSIDE DATABASE: ", "After res to contact" );
        return contactInfo;
    }


    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String name, String phone, String email,String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("place", place);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public List<ContactInfo> getAllCotacts() {
        List<ContactInfo> contactInfoList = new ArrayList<>();

        final String SELECT_QUERY = "SELECT * FROM " + CONTACTS_TABLE_NAME + " ORDER BY "+ CONTACTS_COLUMN_NAME;

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =  db.rawQuery( SELECT_QUERY, null );


        if(result.moveToFirst())
        {
            do{
                ContactInfo contact = new ContactInfo(Integer.parseInt(result.getString(0)),result.getString(1),result.getString(2)
                ,result.getString(3),result.getString(4));
                contactInfoList.add(contact);
            }while (result.moveToNext());
        }


        return contactInfoList;
    }
}