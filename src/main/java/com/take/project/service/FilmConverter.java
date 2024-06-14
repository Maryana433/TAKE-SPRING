package com.take.project.service;

import com.take.project.entity.FilmEntity;
import com.take.project.model.Film;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FilmConverter {

    public List<Film> convertFilmEntitiesToFilm(List<FilmEntity> entities) {

        return entities.stream().map(FilmConverter::convertFilmEntitiesToFilm).toList();
    }

    public Film convertFilmEntitiesToFilm(FilmEntity entity) {

        var film = new Film(entity.getId(), entity.getTitle(), entity.getPlot(), entity.getYearOfProduction(),
                entity.getCategory().getCategoryName().name(), entity.getCost());

        return film;
    }
}
