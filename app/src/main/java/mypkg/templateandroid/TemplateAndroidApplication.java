package mypkg.templateandroid;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mypkg.templateandroid.data.AppDatabase;
import mypkg.templateandroid.data.DataModelForRecyclerViewInHome;
import mypkg.templateandroid.di.AppComponent;
import mypkg.templateandroid.di.AppModule;
import mypkg.templateandroid.di.DaggerAppComponent;
import mypkg.templateandroid.utilities.ReadFileUtils;

/**
 * This is the Application class of app, in this version the settings are:
 * 1-Dagger settings implementations.
 * 2-Database initial operations.
 *
 */

public class TemplateAndroidApplication extends Application {

    private AppDatabase appDatabase;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = AppDatabase.getDatabase(this);

        appComponent = DaggerAppComponent.builder().
                appModule(new AppModule( this)).
                build();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new DataBaseInit(appDatabase, this));
        executor.shutdown();

    }

    public AppDatabase getDatabase() {
        return appDatabase;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static class DataBaseInit implements Runnable {

        private final AppDatabase appDatabase;
        private final Context context;

        public DataBaseInit(AppDatabase appDatabase, Context context) {
            this.appDatabase = appDatabase;
            this.context = context;

        }
        @Override
        public void run() {
            LiveData<List<DataModelForRecyclerViewInHome>> data = appDatabase.daoForRecyclerViewInHome().getAllItems();
            if ( data.getValue() == null ){

                String jsonContent = ReadFileUtils.readJsonInAssetDir(context);
                // Parse JSON content into List<HomeModel>
                Gson gson = new Gson();
                Type homeModelListType = new TypeToken<List<DataModelForRecyclerViewInHome>>(){}.getType();
                List<DataModelForRecyclerViewInHome> homeModels = gson.fromJson(jsonContent, homeModelListType);
                assert homeModels != null;
                appDatabase.daoForRecyclerViewInHome().insertData(homeModels);
            } else {
                Log.d("content", "not null");
            }
        }
    }
}
