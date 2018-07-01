package com.example.deepankursadana.imageloading.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import android.support.v7.widget.RecyclerView;

import com.example.deepankursadana.imageloading.R;
import com.example.deepankursadana.imageloading.adapters.ImageRenderAdapter;
import com.example.deepankursadana.imageloading.data.ApiSearchData;
import com.example.deepankursadana.imageloading.data.Feed;
import com.example.deepankursadana.imageloading.data.Photo;
import com.example.deepankursadana.imageloading.data.Photos;
import com.example.deepankursadana.imageloading.interfaces.ApiResponseListener;
import com.example.deepankursadana.imageloading.network.RequestManager;
import com.example.deepankursadana.imageloading.network.SearchApiManager;
import com.example.deepankursadana.imageloading.utils.EndlessRecyclerScrollListener;
import com.example.deepankursadana.imageloading.utils.ILayoutManager;
import com.google.gson.Gson;

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
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
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
                toggleLoader(true);
                RequestManager.getInstance().submitQuery(query.trim().toLowerCase(), getActivity(), listener);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private ApiResponseListener listener = new ApiResponseListener() {
        @Override
        public void onSuccess(String key, String jsonObject) {
            toggleLoader(false);
            ApiSearchData apiSearchData = new Gson().fromJson(jsonObject, ApiSearchData.class);
            ArrayList<Feed> list = new ArrayList<>();
            Photos photos = apiSearchData.getPhotos();
            for (Photo photo : photos.getPhoto()) {
                Feed feed = new Feed();
                feed.setPhoto(photo);
                list.add(feed);
            }
            addItemsFromApi(list);
        }

        @Override
        public void onFailure() {
            toggleLoader(false);
        }
    };


    void toggleLoader(boolean showLoader) {

    }

    private void addItemsFromApi(final List<Feed> feeds) {
        refreshAdapter(feeds);

    }

    private void refreshAdapter(List<Feed> feeds) {
        if (imageRenderAdapter != null) {
            imageRenderAdapter.setList(feeds);
        }
    }
}
