package com.example.android.miwok;

/**
 * Created by usa19 on 7/10/2017.
 */

public class Word {
    //set a checking value to check if
    private static final int NO_IMAGE = -1;
    private String mMiwokTranslate;
    private String mDefaultTranslate;
    //setting default id as no_image
    private int mImageID = NO_IMAGE;
    private int mAudioID;

    public Word(String miwokTranslate, String defaultTranslate, int audioID) {
        mMiwokTranslate = miwokTranslate;
        mDefaultTranslate = defaultTranslate;
        mAudioID = audioID;
    }

    public Word(String miwokTranslate, String defaultTranslate, int audioID, int ImageID) {
        mMiwokTranslate = miwokTranslate;
        mDefaultTranslate = defaultTranslate;
        mAudioID = audioID;
        //if there is an image in input, the default id above will be updated
        mImageID = ImageID;
    }

    public String getMiwokTranslate() {
        return mMiwokTranslate;
    }

    public String getDefaultTranslate() {
        return mDefaultTranslate;
    }

    public int getImageID() {
        return mImageID;
    }

    public int getAudioID() {
        return mAudioID;
    }

    /**
     * Returns whether or not there is an image for this word. if there IS an image,
     * the mImageID will get updated and the != will be false, thus hasImage() returns
     * false..
     */
    public boolean hasImage() {
        return mImageID != NO_IMAGE;
    }
}
