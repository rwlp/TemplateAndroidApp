package mypkg.templateandroid.data;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoForRecyclerViewInHome {

    @Query("SELECT * FROM items_for_recycle_view_in_home")
    LiveData<List<DataModelForRecyclerViewInHome>> getAllItems();

    @Insert
    void insertData(List<DataModelForRecyclerViewInHome> dataToInsert);

}
