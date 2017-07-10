package com.patapignouf.phototochar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;



public class AFCameraSimple extends Activity {
    private Preview mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Create our Preview view and set it as the content of our activity.
        mPreview = new Preview(this);
        setContentView(mPreview);
    }
}