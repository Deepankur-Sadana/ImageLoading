package com.example.deepankursadana.imageloading.utils;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void copyStream() {
    }

    @Test
    public void urlBuilder() {
        //    To load the photo, you can build the full URL following this pattern:
//    http://farm{farm}.static.flickr.com/{server}/{id}_{secret}.jpg
//    Thus, using our Flickr photo model example above, the full URL would be:
        String expected = "http://farm1.static.flickr.com/578/23451156376_8983a8ebc7.jpg";
        String output = Utils.buildImageUrl("1", "578", "23451156376", "8983a8ebc7");

        assert expected.equals(output);
    }
}