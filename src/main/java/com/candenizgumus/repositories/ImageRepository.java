package com.candenizgumus.repositories;


import com.candenizgumus.entities.Image;

public class ImageRepository extends RepositoryManager<Image,Long>
{
    public ImageRepository()
    {
        super(Image.class);
    }
}
