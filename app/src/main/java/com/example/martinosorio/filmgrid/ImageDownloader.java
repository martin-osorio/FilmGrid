package com.example.martinosorio.filmgrid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Martin on 2/12/2018.
 */

public class ImageDownloader extends AsyncTask<String,Void,Bitmap> {
    private ImageView imageView;//TODO

    ImageDownloader(ImageView imageView){
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String...urls){
        String url = urls[0];
        Bitmap image = null;
        try{
            InputStream inputStream = new URL(url).openStream();
            image = BitmapFactory.decodeStream(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
        return image;
    }

    protected void onPostExecute(Bitmap result){
        imageView.setImageBitmap(result);
    }
}