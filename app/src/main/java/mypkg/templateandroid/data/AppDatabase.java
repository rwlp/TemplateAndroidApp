package mypkg.templateandroid.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataModelForRecyclerViewInHome.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DaoForRecyclerViewInHome daoForRecyclerViewInHome();

    private static volatile AppDatabase INSTANCE; // All threads accessing up-to-data instance

    public static AppDatabase getDatabase(Context context) {
        // Create instance of Database using 'synchronized'

        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "app_database").build();
            }
        }
        return INSTANCE;
    }
}
