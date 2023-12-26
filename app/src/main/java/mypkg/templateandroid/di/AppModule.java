package mypkg.templateandroid.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import mypkg.templateandroid.TemplateAndroidApplication;
import mypkg.templateandroid.data.AppDatabase;
import mypkg.templateandroid.data.DaoForRecyclerViewInHome;
import mypkg.templateandroid.data.RepositoryForHome;

@Module
public class AppModule {

    private final AppDatabase appDatabase;

    public AppModule(TemplateAndroidApplication templateAndroidApplication) {
        this.appDatabase = templateAndroidApplication.getDatabase();
    }

    @Provides
    DaoForRecyclerViewInHome provideDaoForRecyclerViewInHome() {
        return appDatabase.daoForRecyclerViewInHome();
    }
}
