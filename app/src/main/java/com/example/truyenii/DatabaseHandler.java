package com.example.truyenii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends  SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TruyenQQ";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Truyen";
    private static final String KEY_IDT = "IDT";
    private static final String KEY_IDtl = "IDtl";
    private static final String KEY_NAME = "TenTruyen";
    private static final String KEY_IDUser = "IDNguoiDung";
    private static final String KEY_Date = "NgayDang";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_Truyen_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_IDT, KEY_IDtl, KEY_NAME, KEY_IDUser, KEY_Date);
        db.execSQL(create_Truyen_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_Truyen_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_Truyen_table);

        onCreate(db);
    }

    public void addTruyen(Truyen truyen) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, truyen.getTenTruyen());
        values.put(KEY_IDtl, truyen.getIDtl());
        values.put(KEY_IDUser, truyen.getIDNguoiDung());
        values.put(KEY_Date, truyen.getNgayDang());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

//    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
//    public Cursor rawQuery(String sql, String[] selectionArgs)
    public Truyen getTryen(int TruyenID) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_IDT + " = ?", new String[] { String.valueOf(TruyenID) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Truyen student = new Truyen(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
        return student;
    }

    public Truyen getTruyen(int TruyenID) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_IDT + " = ?", new String[] { String.valueOf(TruyenID) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Truyen truyen = new Truyen(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
        return truyen;
    }

    public List<Truyen> getAllTruyen() {
        List<Truyen>  TruyenList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Truyen truyen = new Truyen(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
            TruyenList.add(truyen);
            cursor.moveToNext();
        }
        return TruyenList;
    }

    public void updateTruyen(Truyen truyen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, truyen.getTenTruyen());
        values.put(KEY_IDtl, truyen.getIDtl());
        values.put(KEY_IDUser, truyen.getIDNguoiDung());
        values.put(KEY_Date, truyen.getNgayDang());

        db.update(TABLE_NAME, values, KEY_IDT + " = ?", new String[] { String.valueOf(truyen.getIDT()) });
        db.close();
    }

    public void deleteTruyen(int TruyenID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_IDT + " = ?", new String[] { String.valueOf(TruyenID) });
        db.close();
    }
}