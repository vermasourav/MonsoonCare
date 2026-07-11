package com.monsoon.care.data.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.monsoon.care.data.db.entities.AlertEntity;
import com.monsoon.care.data.db.dao.AlertDao;
import com.monsoon.care.utils.Constants;

/**
 * Room Database - Single database instance for the application
 */
@Database(entities = {AlertEntity.class}, version = Constants.DB_VERSION, exportSchema = false)
public abstract class MonsoonCareDatabase extends RoomDatabase {

    private static volatile MonsoonCareDatabase INSTANCE;

    public abstract AlertDao alertDao();

    public static MonsoonCareDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MonsoonCareDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MonsoonCareDatabase.class,
                            Constants.DB_NAME
                    )
                    .fallbackToDestructiveMigration()
                    .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void closeDatabase() {
        if (INSTANCE != null && INSTANCE.isOpen()) {
            INSTANCE.close();
            INSTANCE = null;
        }
    }
}

