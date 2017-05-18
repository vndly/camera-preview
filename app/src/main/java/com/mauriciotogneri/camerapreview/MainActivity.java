package com.mauriciotogneri.camerapreview;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

// https://github.com/pikanji/CameraPreviewSample
public class MainActivity extends Activity implements PreviewCallback
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

        preview.setOneShotPreviewCallback(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        preview.stop();
        container.removeView(preview);
        preview = null;
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera)
    {
        Log.i("TEST", "DATA: " + data.length);
    }
}