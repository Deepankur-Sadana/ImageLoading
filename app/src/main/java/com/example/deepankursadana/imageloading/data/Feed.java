package com.example.deepankursadana.imageloading.data;

import com.example.deepankursadana.imageloading.utils.Utils;

public class Feed {

    public static final String LOAD_MORE_OBJ_TYPE = "load_more_obj_type";

    private String adObjType;
    private Photo photo;

    public String getObjType() {
        return adObjType;
    }

    private String mImageUrl;

    public void setPhoto(Photo photo) {
        this.photo = photo;
        mImageUrl = Utils.buildImageUrl(photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret());
    }

    public String getmImageUrl() {
        return mImageUrl;
    }
}
