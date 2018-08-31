/*
package ru.app.churchofchrist;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupManager;
import android.app.backup.FileBackupHelper;


public class TheBackupAgent extends BackupAgentHelper {
    // Имя файла SharedPreferences
    static final String HIGH_SCORES_FILENAME = "scores";

    // Ключ к уникальной идентификации набора резервных данных
    static final String FILES_BACKUP_KEY = "myDataBase";


    @Override
    public void onCreate() {
        FileBackupHelper helper = new FileBackupHelper(this, HIGH_SCORES_FILENAME);
        addHelper(FILES_BACKUP_KEY, helper);
    }

    // Выделите помощника и добавьте его в резервный агент
    public void requestBackup() {
        BackupManager bm = new BackupManager(this);
        bm.dataChanged();
    }

}
*/
