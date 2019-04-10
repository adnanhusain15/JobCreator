package com.example.user.jobcreator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDatabaseManager extends SQLiteOpenHelper {

    public SqliteDatabaseManager(Context context)
    {
        super(context, StudentDirectory.DATABASE_NAME,null,StudentDirectory.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE "+ StudentDirectory.Details.TABLE_NAME+"("+StudentDirectory.Details.NAME+" TEXT ,"+StudentDirectory.Details.NUM+" TEXT ,"+StudentDirectory.Details.CGPA+" TEXT ,"+StudentDirectory.Details.INSP+" TEXT ,"+StudentDirectory.Details.BLOG+" TEXT)";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
