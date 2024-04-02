package com.candenizgumus.services;

import com.candenizgumus.repositories.CategoryRepository;

public class CategoryService
{
    CategoryRepository categoryRepository;

    public CategoryService()
    {
        this.categoryRepository = new CategoryRepository();
    }
}
