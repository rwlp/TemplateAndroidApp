package mypkg.templateandroid.di;

import javax.inject.Singleton;

import dagger.Component;
import mypkg.templateandroid.viewmodel.ViewModelForHome;
import mypkg.templateandroid.views.HomeFragment;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(HomeFragment homeFragment);

    ViewModelForHome viewModelForHome();
}
