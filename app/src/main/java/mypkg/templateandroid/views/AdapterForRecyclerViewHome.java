package mypkg.templateandroid.views;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mypkg.templateandroid.R;
import mypkg.templateandroid.data.DataModelForRecyclerViewInHome;

public class AdapterForRecyclerViewHome extends RecyclerView.Adapter<AdapterForRecyclerViewHome.ViewHolder> {

    private List<DataModelForRecyclerViewInHome> itemsOfRecyclerView = new ArrayList<>();
    private int secondPosition = -1;

    @SuppressLint("NotifyDataSetChanged")
    public void setItemsOfRecyclerView(List<DataModelForRecyclerViewInHome> itemsOfRecyclerView) {
        this.itemsOfRecyclerView = itemsOfRecyclerView;
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFirstItemVisible(int secondPosition) {
        this.secondPosition = secondPosition;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterForRecyclerViewHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.layout_item_recycler_view_in_home, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getTitle().setText(itemsOfRecyclerView.get(position).getItemTitle());
        holder.getDescription().setText(itemsOfRecyclerView.get(position).getItemDescription());

        if (position == secondPosition) {
            holder.getMainConstraintLayout().setBackgroundColor(Color.RED);
            holder.getTitle().setVisibility(View.VISIBLE);
            holder.getDescription().setVisibility(View.VISIBLE);

        } else {
            holder.getMainConstraintLayout().setBackgroundColor(Color.BLUE);
            holder.getTitle().setVisibility(View.GONE);
            holder.getDescription().setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return 240;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ConstraintLayout mainConstraintLayout;
        private final CardView mainCardView;
        private final ImageView imageOfCardView;
        private final TextView title;
        private final TextView description;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.mainConstraintLayout = itemView.findViewById(R.id.main_constraint);
            this.mainCardView = itemView.findViewById(R.id.main_cardView);
            this.imageOfCardView = itemView.findViewById(R.id.principal_image);
            this.title = itemView.findViewById(R.id.title);
            this.description = itemView.findViewById(R.id.description);
        }

        public ConstraintLayout getMainConstraintLayout() {
            return mainConstraintLayout;
        }

        public CardView getMainCardView() {
            return mainCardView;
        }

        public ImageView getImageOfCardView() {
            return imageOfCardView;
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getDescription() {
            return description;
        }
    }
}
