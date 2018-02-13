package com.example.martinosorio.filmgrid.event;

import android.graphics.Bitmap;

/**
 * Created by Martin on 2/12/2018.
 */

public class ImageDownloadedEvent {
    private int id;
    private Bitmap image;

    public ImageDownloadedEvent(int id, Bitmap image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public Bitmap getImage() {
        return image;
    }
}
