package com.example.android.mediaapp;

/**
 * Created by lama on 8/4/2017 AD.
 */

public class media {
    String mName;
    int mImage= NO_IMAGE_PROVIDED;
    int mTrack;
    private static final int NO_IMAGE_PROVIDED = -1;

    public media(String mName, int mImage, int mTrack) {
        this.mName = mName;
        this.mImage = mImage;
        this.mTrack = mTrack;
    }

    public media(String mName, int mTrack) {
        this.mName = mName;
        this.mTrack = mTrack;
    }

    public String getmName() {
        return mName;
    }
    public boolean hasImage() {
        return mImage != NO_IMAGE_PROVIDED;
    }
    public int getmImage() {
        return mImage;
    }

    public int getmTrack() {
        return mTrack;
    }
}
