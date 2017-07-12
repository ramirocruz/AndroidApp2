package com.example.rish.androidapp;

/**
 * Created by RISHABH KUMAR SINGH on 7/12/2017.
 */

public class ModelObject {
    //ONE(View.R.layout.intro1),
    //TWO(R.layout.intro2),
    //THREE(R.layout.intro3);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
