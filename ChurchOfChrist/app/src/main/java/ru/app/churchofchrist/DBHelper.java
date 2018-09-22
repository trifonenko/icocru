package ru.app.churchofchrist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "";

    private String mDbName;
    private SQLiteDatabase mDatabase;
    private final Context mContext;
    private boolean mNeedUpdate = false;

     @SuppressLint("SdCardPath")
     public DBHelper(Context context, String dbName, int dbVersion) {
        super(context, dbName, null, dbVersion);

        this.mDbName = dbName;
        this.mContext = context;

        if (dbName.equals("icoc.db")) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";

            copyDataBase();
            this.getReadableDatabase();
        }
    }

    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + mDbName);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + mDbName);
        return dbFile.exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = mContext.getAssets().open(mDbName);
        OutputStream mOutput = new FileOutputStream(DB_PATH + mDbName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mDatabase = SQLiteDatabase.openDatabase(DB_PATH + mDbName, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDatabase != null;
    }

    @Override
    public synchronized void close() {
        if (mDatabase != null)
            mDatabase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE FAV_SONGS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "ID INTEGER, "
                + "NAME TEXT, "
                + "TEXT TEXT, "
                + "CHORDS TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }
}
