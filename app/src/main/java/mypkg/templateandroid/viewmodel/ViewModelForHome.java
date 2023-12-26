package mypkg.templateandroid.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import mypkg.templateandroid.data.DataModelForRecyclerViewInHome;
import mypkg.templateandroid.data.RepositoryForHome;

public class ViewModelForHome extends ViewModel {

    RepositoryForHome repositoryForHome;

    @Inject
    public ViewModelForHome(RepositoryForHome repositoryForHome) {
        this.repositoryForHome = repositoryForHome;
    }

    public LiveData<List<DataModelForRecyclerViewInHome>> getItemsForRecyclerView() {
        return repositoryForHome.getItemsForRecyclerView();
    }
}
