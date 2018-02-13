package com.example.martinosorio.filmgrid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.greenrobot.eventbus.EventBus;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Martin on 2/12/2018.
 */

public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    private int position;

    public ImageDownloader(int position) {
        this.position = position;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap image = null;
        try {
            InputStream inputStream = new URL(url).openStream();
            image = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    protected void onPostExecute(Bitmap result) {
        EventBus.getDefault().post(new ImageDownloadedEvent(position, result));
    }
}