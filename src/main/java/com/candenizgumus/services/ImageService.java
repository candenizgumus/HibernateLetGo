package com.candenizgumus.services;

import com.candenizgumus.entities.Image;
import com.candenizgumus.repositories.ImageRepository;

public class ImageService
{
    ImageRepository imageRepository;

    public ImageService()
    {
        this.imageRepository = new ImageRepository();
    }
}
