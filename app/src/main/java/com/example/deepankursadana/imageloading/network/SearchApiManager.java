package com.example.deepankursadana.imageloading.network;

import com.example.deepankursadana.imageloading.data.Feed;

import org.json.JSONObject;

import java.util.List;

public class SearchApiManager {

    public interface DataListener {
        void onActionDetailApiSuccess(List<Feed> list, int totalCount, int uniqueCount, JSONObject pageInfo, String objId, ActionsDataModel.ActionTypes actionType);

        void onActionDetailApiFailed(String objId, ActionsDataModel.ActionTypes actionType);
    }

}
