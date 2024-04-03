package com.candenizgumus.services;

import com.candenizgumus.entities.Image;
import com.candenizgumus.repositories.ImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImageService
{
    ImageRepository imageRepository;
    Scanner scanner = new Scanner(System.in);
    public ImageService()
    {
        this.imageRepository = new ImageRepository();
    }

    public List<String> fotografAl0YazanaKadar(){
        List<String> fotoList = new ArrayList<>();
        String fotograf;
        do
        {
            System.out.println("Fotograf Giriniz. Sonlandırmak için 0 giriniz.");
            fotograf = scanner.nextLine();
            fotoList.add(fotograf);
        } while (!fotograf.equals("0"));
        fotoList.remove(fotoList.getLast());
        return fotoList;
    }
}
