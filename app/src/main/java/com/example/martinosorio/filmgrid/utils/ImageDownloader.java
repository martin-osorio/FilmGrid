package com.example.martinosorio.filmgrid.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.martinosorio.filmgrid.event.ImageDownloadedEvent;

import org.greenrobot.eventbus.EventBus;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Martin on 2/12/2018.
 */

public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    private int id;

    public ImageDownloader(int id) {
        this.id = id;
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
        EventBus.getDefault().post(new ImageDownloadedEvent(id, result));
    }
}