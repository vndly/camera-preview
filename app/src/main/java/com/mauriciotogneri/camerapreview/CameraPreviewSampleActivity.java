package com.mauriciotogneri.camerapreview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

// https://github.com/pikanji/CameraPreviewSample
public class CameraPreviewSampleActivity extends Activity
{
    private CameraPreview preview;
    private RelativeLayout container;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.preview);

        container = (RelativeLayout) findViewById(R.id.container);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        preview = new CameraPreview(this, 0, CameraPreview.LayoutMode.FitToParent);
        container.addView(preview);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        preview.stop();
        container.removeView(preview);
        preview = null;
    }
}