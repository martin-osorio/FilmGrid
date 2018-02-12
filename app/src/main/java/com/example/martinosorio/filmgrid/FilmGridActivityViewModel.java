package com.example.martinosorio.filmgrid;

/**
 * Created by Martin on 2/12/2018.
 */

public class FilmGridActivityViewModel {

    public FilmGridActivityViewModel() {
        startController();
    }

    private void startController(){
        SnagfilmsController controller = new SnagfilmsController();
        controller.start();
    }
}
