package com.example.martinosorio.filmgrid;

import android.graphics.Bitmap;

/**
 * Created by Martin on 2/12/2018.
 */

class ImageDownloadedEvent {
    private int id;
    private Bitmap image;

    ImageDownloadedEvent(int id, Bitmap image) {
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
