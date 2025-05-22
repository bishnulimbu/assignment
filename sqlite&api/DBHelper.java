
package com.example.lifecycleapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "UserDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY, name TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public void insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO users(name) VALUES(?)", new Object[]{name});
    }

    public void updateData(int id, String newName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE users SET name=? WHERE id=?", new Object[]{newName, id});
    }

    public void deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM users WHERE id=?", new Object[]{id});
    }

    public String getAllNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM users", null);
        StringBuilder names = new StringBuilder();
        while (c.moveToNext()) names.append(c.getString(0)).append(", ");
        c.close();
        return names.toString();
    }
}

