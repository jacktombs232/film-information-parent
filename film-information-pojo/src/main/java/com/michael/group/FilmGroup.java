package com.michael.group;

import com.michael.pojo.Film;
import com.michael.pojo.FilmDesc;

public class FilmGroup {
    private Film film;
    private FilmDesc filmDesc;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmDesc getFilmDesc() {
        return filmDesc;
    }

    public void setFilmDesc(FilmDesc filmDesc) {
        this.filmDesc = filmDesc;
    }
}
