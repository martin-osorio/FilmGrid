package com.example.martinosorio.filmgrid.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.martinosorio.filmgrid.BR;
import com.example.martinosorio.filmgrid.event.ImageDownloadedEvent;
import com.example.martinosorio.filmgrid.utils.ImageDownloader;
import com.example.martinosorio.filmgrid.model.Film;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmViewModel extends BaseObservable {
    private Bitmap image;
    private String title;
    private int id;
    private boolean progressVisible;
    private boolean imageVisible;

    public FilmViewModel(Film film, int id) {
        EventBus.getDefault().register(this);

        this.id = id;
        setImageVisible(false);
        setProgressVisible(true);

        if (film != null) {
            this.title = film.getTitle();

            if (film.getImages() != null && film.getImages().getImage() != null && film.getImages().getImage().get(0) != null) {
                String url = film.getImages().getImage().get(0).getSrc();

                if (url != null && !url.isEmpty()) {
                    new ImageDownloader(id).execute(url);
                }
            }
        }
    }

    @BindingAdapter("imageBitmap")
    public static void loadImage(ImageView imageView, Bitmap image) {
        imageView.setImageBitmap(image);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onImageDownloadedEvent(ImageDownloadedEvent event) {
        if (this.id == event.getId()) {
            setImage(event.getImage());
            setImageVisible(true);
            setProgressVisible(false);
        }
    }

    @Bindable
    public Bitmap getImage() {
        return image;
    }

    @Bindable
    public void setImage(Bitmap image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public boolean isProgressVisible() {
        return progressVisible;
    }

    @Bindable
    private void setProgressVisible(boolean progressVisible) {
        this.progressVisible = progressVisible;
        notifyPropertyChanged(BR.progressVisible);
    }

    @Bindable
    public boolean isImageVisible() {
        return imageVisible;
    }

    @Bindable
    private void setImageVisible(boolean imageVisible) {
        this.imageVisible = imageVisible;
        notifyPropertyChanged(BR.imageVisible);
    }
}
