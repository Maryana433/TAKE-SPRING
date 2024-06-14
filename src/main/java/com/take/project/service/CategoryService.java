package com.take.project.service;

import com.take.project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<String> getAllCategories(){
        return categoryRepository.findAll().stream().map(c -> c.getCategoryName().name()).collect(Collectors.toList());
    }
}
