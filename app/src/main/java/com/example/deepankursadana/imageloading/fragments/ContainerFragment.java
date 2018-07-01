package com.example.deepankursadana.imageloading.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import android.support.v7.widget.RecyclerView;

import com.example.deepankursadana.imageloading.R;
import com.example.deepankursadana.imageloading.adapters.ImageRenderAdapter;
import com.example.deepankursadana.imageloading.data.Feed;
import com.example.deepankursadana.imageloading.network.SearchApiManager;
import com.example.deepankursadana.imageloading.utils.EndlessRecyclerScrollListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ContainerFragment extends Fragment {

    SearchView searchView;
    private RecyclerView recyclerView;

    private ImageRenderAdapter imageRenderAdapter;

    public static ContainerFragment newInstance(@Nullable Bundle argBundle) {
        ContainerFragment fragmentInstance = new ContainerFragment();

        if (argBundle != null) {
            fragmentInstance.setArguments(argBundle);
        }
        return fragmentInstance;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, null);
        searchView = rootView.findViewById(R.id.searchView);
//        recyclerView = rootView.findViewById(R.id.re);
//        android.R.layout.
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSearchView();
    }

    void initSearchView() {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }



    private void addItemsFromApi(final List<Feed> feeds, JSONObject pageInfo) {
        refreshAdapter(feeds);

    }

    ArrayList<Feed> apiList = new ArrayList<>();



    private void refreshAdapter(List<Feed> feeds) {
        if (imageRenderAdapter != null) {
            imageRenderAdapter.setList(feeds);
        }
    }
}
