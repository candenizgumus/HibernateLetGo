package com.candenizgumus.repositories;

import com.candenizgumus.entities.Category;

public class CategoryRepository extends RepositoryManager<Category,Long>
{
    public CategoryRepository()
    {
        super(Category.class);
    }
}
