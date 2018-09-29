package ru.app.churchofchrist.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String sDbPath;
    private static final String DB_NAME = "icoc.db";
    private Context mContext;
    private boolean mNeedUpdate = false;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DatabaseHelper.DB_NAME, null, 9);
        if (context != null) sDbPath = context.getApplicationInfo().dataDir + "/databases/";
        this.mContext = context;
        copyDatabase();
        this.getReadableDatabase();
    }

    public void updateDatabase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(sDbPath + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();
            copyDatabase();
            mNeedUpdate = false;
        }
    }

    /**
     * Проверка существования файла базы данных по заданному пути.
     *
     * @return <code>true</code> если файл базы данных существует, иначе <code>false</code>
     */
    private boolean checkFileDatabase() {
        File databaseFile = new File(sDbPath + DB_NAME);
        return databaseFile.exists();
    }

    private void copyDatabase() {
        if (!checkFileDatabase()) {
            try {
                this.getReadableDatabase();
                this.close();
                copyDatabaseFile();
            } catch (IOException e) {
                throw new Error("ErrorCopyingDatabase");
            }
        }
    }

    private void copyDatabaseFile() throws IOException {
        InputStream input = mContext.getAssets()
                                    .open(DB_NAME);
        OutputStream output = new FileOutputStream(sDbPath + DB_NAME);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0) output.write(buffer, 0, length);
        output.flush();
        output.close();
        input.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }

    @Override
    public synchronized void close() {
        if (mDatabase != null)
            mDatabase.close();
        super.close();
    }
}