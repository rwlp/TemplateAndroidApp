package mypkg.templateandroid.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import mypkg.templateandroid.R;
import mypkg.templateandroid.TemplateAndroidApplication;
import mypkg.templateandroid.viewmodel.ViewModelForHome;

public class HomeFragment extends Fragment {

    @Inject
    ViewModelForHome viewModelForHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Dagger DI
        ((TemplateAndroidApplication) getActivity().getApplication()).
                getAppComponent().inject(this);

        // RecyclerView Implementations
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_first);
        LinearLayoutManager linearLayoutForRecyclerView = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        AdapterForRecyclerViewHome adapterForRecyclerViewHome = new AdapterForRecyclerViewHome();
        recyclerView.setLayoutManager(linearLayoutForRecyclerView);

        viewModelForHome.getItemsForRecyclerView().observe(getViewLifecycleOwner(), newDataSetForRecyclerView -> {
            adapterForRecyclerViewHome.setItemsOfRecyclerView(newDataSetForRecyclerView);
            recyclerView.setAdapter(adapterForRecyclerViewHome);
            recyclerView.scrollToPosition(120); // To 'endless' RecyclerView

        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // To find second visible position
                int secondPosition = linearLayoutForRecyclerView.findFirstVisibleItemPosition();
                adapterForRecyclerViewHome.setFirstItemVisible(secondPosition + 1);
            }
        });

        return view;
    }
}