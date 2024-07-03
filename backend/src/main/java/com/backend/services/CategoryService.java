package com.backend.services;

import com.backend.Category;
import com.backend.Dto.CategoryDto;
import com.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        List<Category> list = repository.findAll();
        return list.stream().map(x -> new CategoryDto(x)).collect(Collectors.toList());

//        List<CategoryDto> listDto = new ArrayList<>();    outro jeito de fazer
//        for (Category cat : list) {
//            listDto.add(new CategoryDto(cat));
//        }


    }
}
