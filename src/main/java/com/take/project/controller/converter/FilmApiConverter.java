package com.take.project.controller.converter;

import com.take.project.controller.response.FilmDetails;
import com.take.project.controller.response.FilmOverview;
import com.take.project.model.Film;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FilmApiConverter {

    public static List<FilmOverview> convertFilmsToOverviewDetails(List<Film> films){

        return films.stream().map(FilmApiConverter::convertFilmToOverviewDetails).toList();
    }

    private static FilmOverview convertFilmToOverviewDetails(Film film){

        var overviewDetails =  new FilmOverview();
        overviewDetails.setId(film.id());
        overviewDetails.setTitle(film.title());
        overviewDetails.setYearOfProduction(film.yearOfProduction());
        overviewDetails.setCost(film.cost());
        overviewDetails.setCategory(film.category());

        return overviewDetails;
    }

    public static FilmDetails convertFilmToDetails(Film film){

        var details =  new FilmDetails();
        details.setId(film.id());
        details.setTitle(film.title());
        details.setYearOfProduction(film.yearOfProduction());
        details.setCost(film.cost());
        details.setCategory(film.category());
        details.setPlot(film.plot());

        return details;
    }
}
