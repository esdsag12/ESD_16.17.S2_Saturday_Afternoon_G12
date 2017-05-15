package com.app.esd.esd.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.esd.esd.Database.TaskC.Task;
import com.app.esd.esd.Model.Session;

import java.util.ArrayList;

/**
 * Created by DOBYNT on 02/11/2016.
 */

public class TaskDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "session.db";

    private static final String SQL_CREATE_ALARM = "CREATE TABLE " + Task.TABLE_NAME + " (" +
            Task._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Task.DATE + " TEXT," +
            Task.TIME_HOUR + " LONG," +
            Task.TIME_MINUTE + " LONG," +
            Task.SCORE + " INTEGER" + " )";
    private static final String SQL_DELETE_ALARM =
            "DROP TABLE IF EXISTS " + Task.TABLE_NAME;

    public TaskDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(SQL_CREATE_ALARM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL(SQL_DELETE_ALARM);
        onCreate(db);
    }

    private Session populateModel(Cursor c) {
        Session model = new Session();
        model.id = c.getInt(c.getColumnIndex(Task._ID));
        model.date = c.getString(c.getColumnIndex(Task.DATE));
        model.time_hour = c.getLong(c.getColumnIndex(Task.TIME_HOUR));
        model.time_minute = c.getLong(c.getColumnIndex(Task.TIME_MINUTE));
        model.score = c.getInt(c.getColumnIndex(Task.SCORE));
        return model;
    }

    private ContentValues populateContent(Session model) {
        ContentValues values = new ContentValues();
        values.put(Task.DATE, model.date);
        values.put(Task.TIME_HOUR, model.time_hour);
        values.put(Task.TIME_MINUTE, model.time_minute);
        values.put(Task.SCORE, model.score);
        return values;
    }

    public long createSession(Session model) {
        ContentValues values = populateContent(model);
        return getWritableDatabase().insert(Task.TABLE_NAME, null, values);
    }

    public Session getSession(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + Task.TABLE_NAME + " WHERE " + Task._ID + " = " + id;

        Cursor c = db.rawQuery(select, null);
        if (c.moveToNext()) {
            return populateModel(c);
        }
        return null;
    }

    public long updateSession(Session model) {
        ContentValues values = populateContent(model);
        return getWritableDatabase().update(Task.TABLE_NAME, values, Task._ID + " = ?", new String[]{String.valueOf(model.id)});
    }

    public int deleteSession(long id) {
        return getWritableDatabase().delete(Task.TABLE_NAME, Task._ID + " = ?", new String[]{String.valueOf(id)});
    }


    public ArrayList<Session> getAlarms() {
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + Task.TABLE_NAME;

        Cursor c = db.rawQuery(select, null);

        ArrayList<Session> alarmList = new ArrayList<Session>();

        while (c.moveToNext()) {
            alarmList.add(populateModel(c));
        }

        if (!alarmList.isEmpty()) {
            return alarmList;
        }
        return null;
    }
}