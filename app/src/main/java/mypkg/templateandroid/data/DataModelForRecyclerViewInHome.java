package mypkg.templateandroid.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "items_for_recycle_view_in_home")
public class DataModelForRecyclerViewInHome {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    int itemId;

    @ColumnInfo(name = "item_title")
    @SerializedName("item_title")
    String itemTitle;

    @ColumnInfo(name = "item_description")
    @SerializedName("item_description")
    String itemDescription;

    // No in use in this code
    @ColumnInfo(name = "image_base64")
    @SerializedName("image_base64")
    String imageBase64;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
