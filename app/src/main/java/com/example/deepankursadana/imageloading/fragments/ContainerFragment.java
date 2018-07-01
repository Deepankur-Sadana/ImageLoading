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


public class ContainerFragment extends Fragment implements SearchApiManager.DataListener {

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

//                if (list.contains(query)) {
//                    adapter.getFilter().filter(query);
//                } else {
//                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
//                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void addScrollListener() {
        recyclerView.addOnScrollListener(new EndlessRecyclerScrollListener(mLayoutManager) {
            @Override
            public void onReachEnd() {
                if (requestToken != null && requestToken.isRequestRunning()) {
                    return;
                }
                if (lastPageApiInfo != null && lastPageApiInfo.optBoolean("has_next_page")) {
                    getNextPageFromApi();
                }

            }
        });
    }

    @Override
    public void onActionDetailApiSuccess(List<Feed> list, int totalCount, int uniqueCount, JSONObject pageInfo, String objId, ActionsDataModel.ActionTypes actionType) {
        removeLoaderIfPresentFromTheList();
    }

    @Override
    public void onActionDetailApiFailed(String objId, ActionsDataModel.ActionTypes actionType) {

    }

    private void addItemsFromApi(final List<Feed> actionsDataModelList, JSONObject pageInfo) {

    }

    ArrayList<Feed> apiList = new ArrayList<>();

    private void removeLoaderIfPresentFromTheList() {
        if (apiList.size() > 0 && apiList.get(apiList.size() - 1).getObjType().equalsIgnoreCase(ActionDetailData.LOAD_MORE_OBJ_TYPE)) {
            apiList.remove(apiList.size() - 1);
            imageRenderAdapter.notifyItemRemoved(apiList.size() + 1);
        }
    }

    private void refreshAdapter(List<Feed> actionsDataModelList) {
        if (actionsDataModelList != null) {
            actionsDataModelList.setList(actionsDataModelList);
            refreshCountOnTextView(actionsDataModelList);
            showLikesLayout();
        }
    }
}
