package com.example.deepankursadana.imageloading.interfaces;

import com.example.deepankursadana.imageloading.data.Feed;

import java.util.List;

public interface DataBinderListener {

    void onDataUpdated(List<Feed> items, boolean hasNext);
    void onDataInsertedInEnd(List<Feed> items, boolean hasNext);
    void onDataInsertedAtExactPosition(List<Feed> items, int pos);
    void refreshListView();
    void onDataItemChanged(Feed feed, boolean overwriteData);
    void onDataItemRemoved(Feed feed);
    void setRefreshing(boolean setRefreshing);
    void scrollToPosition(int pos);
}
