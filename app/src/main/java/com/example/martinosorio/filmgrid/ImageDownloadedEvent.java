package com.example.martinosorio.filmgrid;

import android.graphics.Bitmap;

/**
 * Created by Martin on 2/12/2018.
 */

class ImageDownloadedEvent {
    int id;
    Bitmap image;

    ImageDownloadedEvent(int id, Bitmap image) {
        this.id = id;
        this.image = image;
    }
}
