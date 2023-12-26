package mypkg.templateandroid.data;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class RepositoryForHome {

    private final DaoForRecyclerViewInHome daoForRecyclerViewInHome;

    @Inject
    public RepositoryForHome(DaoForRecyclerViewInHome daoForRecyclerViewInHome){
        this.daoForRecyclerViewInHome = daoForRecyclerViewInHome;
    }

    public LiveData<List<DataModelForRecyclerViewInHome>> getItemsForRecyclerView() {
        return daoForRecyclerViewInHome.getAllItems();
    }

}
