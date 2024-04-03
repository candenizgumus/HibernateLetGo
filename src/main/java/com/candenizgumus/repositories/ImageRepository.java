package com.candenizgumus.repositories;


import com.candenizgumus.entities.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImageRepository extends RepositoryManager<Image,Long>
{

    public ImageRepository()
    {
        super(Image.class);
    }


}
