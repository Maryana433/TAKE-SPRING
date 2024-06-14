package com.take.project.service;

import com.take.project.entity.FilmEntity;
import com.take.project.exception.FilmNotFound;
import com.take.project.model.Film;
import com.take.project.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms(String categoryName) {

        List<FilmEntity> films;

        if (categoryName != null) {

            Specification<FilmEntity> specification = (root, query, criteriaBuilder) -> {
                // Join the Film entity with the Category entity
                root.fetch("category");

                // Perform a case-insensitive comparison on the category name
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("category").get("categoryName")), "%" + categoryName.toLowerCase() + "%");
            };

            films = filmRepository.findAll(specification);
        } else {
            films = filmRepository.findAll();
        }

        return FilmConverter.convertFilmEntitiesToFilm(films);
    }

    public Film getFilmById(long filmId) {

        var filmEntity = filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFound("Film with id " + filmId + " not found"));
        return FilmConverter.convertFilmEntitiesToFilm(filmEntity);
    }

    public FilmEntity getFilmEntityById(long filmId) {

        return filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFound("Film with id " + filmId + " not found"));
    }
}
