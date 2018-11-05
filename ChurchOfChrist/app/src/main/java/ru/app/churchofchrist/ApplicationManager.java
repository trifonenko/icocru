package ru.app.churchofchrist;

import android.app.Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.room.Room;
import ru.app.churchofchrist.room_helper_database.AppDatabase;

public class ApplicationManager extends Application {

    private static final String DATABASE_NAME = "icoc.db";
    private static String DATABASE_PATH;
    private File databaseFile;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        DATABASE_PATH = getApplicationInfo().dataDir + "/databases/";

        copyDatabase();

        database = Room.databaseBuilder(this, AppDatabase.class, ApplicationManager.DATABASE_NAME)
                       .allowMainThreadQueries()
                       .build();

    }

    public AppDatabase getDatabase() {
        return database;
    }

    private boolean checkDataBase() {
        databaseFile = new File(DATABASE_PATH + DATABASE_NAME);
        return databaseFile.exists();
    }

    private void copyDatabase() {
        if (!checkDataBase()) {
            try {
                copyDatabaseFile();
            } catch (FileNotFoundException e) {
                throw new Error("FileNotFoundException");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDatabaseFile() throws IOException {
        InputStream mInput = getAssets().open(ApplicationManager.DATABASE_NAME);
        if (databaseFile.getParentFile().mkdir()) {
            OutputStream mOutput = new FileOutputStream(DATABASE_PATH + DATABASE_NAME);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while ((mLength = mInput.read(mBuffer)) > 0)
                mOutput.write(mBuffer, 0, mLength);
            mOutput.flush();
            mOutput.close();
            mInput.close();
        }
    }
}