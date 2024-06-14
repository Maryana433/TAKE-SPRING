package com.take.project.controller;

import com.take.project.controller.converter.FilmApiConverter;
import com.take.project.controller.response.FilmDetails;
import com.take.project.controller.response.FilmOverview;
import com.take.project.service.CategoryService;
import com.take.project.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<List<FilmOverview>> getFilmOverview(@RequestParam(required = false, name = "category")
                                                       String categoryName) {

        var filmModels = filmService.getAllFilms(categoryName);
        var filmApiResponse = FilmApiConverter.convertFilmsToOverviewDetails(filmModels);

        return ResponseEntity.ok(filmApiResponse);
    }


    @GetMapping("/{id}")
    ResponseEntity<FilmDetails> getFilmDetails(@PathVariable("id") long id) {

        var filmModel = filmService.getFilmById(id);
        var filmApiResponse = FilmApiConverter.convertFilmToDetails(filmModel);

        return ResponseEntity.ok(filmApiResponse);
    }

    @GetMapping("/categories")
    ResponseEntity<List<String>> getAllCategories(){

        List<String> allCategories = categoryService.getAllCategories();
        allCategories.add("All");
        return ResponseEntity.ok(allCategories);

    }
}
