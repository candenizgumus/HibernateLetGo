package com.candenizgumus.services;

import com.candenizgumus.entities.Category;
import com.candenizgumus.entities.FavouriteIlan;
import com.candenizgumus.entities.Ilan;
import com.candenizgumus.entities.Image;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.IlanRepository;
import com.candenizgumus.utility.SessionContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class IlanService
{
    IlanRepository ilanRepository;
    CategoryService categoryService;
    ImageService imageService;
    FavouriteIlanService favouriteIlanService;
    MessageService messageService;

    Scanner scanner = new Scanner(System.in);

    public IlanService()
    {
        this.ilanRepository = new IlanRepository();
        this.categoryService = new CategoryService();
        this.imageService = new ImageService();
        this.favouriteIlanService = new FavouriteIlanService();
        this.messageService = new MessageService();

    }

    public void ilanVer()
    {
        System.out.println("Kategori Seçiniz");
        categoryService.categoryRepository.getAllParentCategories().forEach(System.out::println);
        System.out.println("Bir parent kategory giriniz.");
        String secilenParentCategory = scanner.nextLine();
        categoryService.categoryRepository.getCategoriesByParentName(secilenParentCategory).forEach(System.out::println);
        System.out.println("Alt kategorinizi giriniz.");
        String altKategori = scanner.nextLine();
        System.out.println("Başlık giriniz.");
        String baslik = scanner.nextLine();
        System.out.println("Açıklama giriniz.");
        String description = scanner.nextLine();
        System.out.println("Konum giriniz.");
        String konum = scanner.nextLine();
        System.out.println("Fiyat giriniz.");
        Double fiyat = scanner.nextDouble();
        scanner.nextLine();


        List<Category> category = categoryService.categoryRepository.findByColumnAndValue("name", altKategori);
        Ilan ilan = ilanRepository.save(Ilan.builder().user(SessionContext.loggedUser).category(category.getFirst()).title(baslik).description(description).konum(konum).price(fiyat).createat(LocalDate.now()).status(Status.ACTIVE).build());

        List<String> fotoURLS = imageService.fotografAl0YazanaKadar();
        fotoURLS.forEach(f -> imageService.imageRepository.save(Image.builder().createat(LocalDate.now()).status(Status.ACTIVE).ilan(ilan).imageurl(f).build()));

    }

    public void ilanlariGosterDetaysiz()
    {
        List<Ilan> butunIlanlar = ilanRepository.findAll();
        List<FavouriteIlan> favouriteIlan = favouriteIlanService.favouriteIlanRepository.findByColumnAndValue("user", SessionContext.loggedUser);
        butunIlanlar.forEach(ilan ->
        {
            System.out.println("************************************************************************************************************************************");
            System.out.println("Ilan No: " + ilan.getId());
            System.out.println("Username: " + ilan.getUser().getUsername());
            System.out.println("Baslik: " + ilan.getTitle());
            System.out.println("Fiyat " + ilan.getPrice());
            List<Image> fotos = imageService.imageRepository.findByColumnAndValue("ilan", ilan);
            if (!fotos.isEmpty())
            {
                System.out.println(fotos.getFirst().getImageurl());
            }

            favouriteIlan.forEach(f ->
            {
                if (f.getIlan().equals(ilan))
                {
                    System.out.println("Bu ilan FAVORİNİZDEDİR!.");

                }
            });
        });

        System.out.println("************************************************************************************************************************************");

    }

    public void ilanlariGosterDetaysizKategoriyeGore(String parentName, String childName)
    {
        List<Ilan> butunIlanlar = ilanRepository.getIlansByCategory(parentName,childName);
        List<FavouriteIlan> favouriteIlan = favouriteIlanService.favouriteIlanRepository.findByColumnAndValue("user", SessionContext.loggedUser);
        butunIlanlar.forEach(ilan ->
        {
            System.out.println("************************************************************************************************************************************");
            System.out.println("Ilan No: " + ilan.getId());
            System.out.println("Username: " + ilan.getUser().getUsername());
            System.out.println("Baslik: " + ilan.getTitle());
            System.out.println("Fiyat " + ilan.getPrice());
            List<Image> fotos = imageService.imageRepository.findByColumnAndValue("ilan", ilan);
            if (!fotos.isEmpty())
            {
                System.out.println(fotos.getFirst().getImageurl());
            }

            favouriteIlan.forEach(f ->
            {
                if (f.getIlan().equals(ilan))
                {
                    System.out.println("Bu ilan FAVORİNİZDEDİR!.");

                }
            });
        });

        System.out.println("************************************************************************************************************************************");

    }

    public void ilanlariGosterDetaysizKonumaGore(String konum)
    {
        List<Ilan> butunIlanlar = ilanRepository.getIlansByLocation(konum);
        List<FavouriteIlan> favouriteIlan = favouriteIlanService.favouriteIlanRepository.findByColumnAndValue("user", SessionContext.loggedUser);
        butunIlanlar.forEach(ilan ->
        {
            System.out.println("************************************************************************************************************************************");
            System.out.println("Ilan No: " + ilan.getId());
            System.out.println("Username: " + ilan.getUser().getUsername());
            System.out.println("Baslik: " + ilan.getTitle());
            System.out.println("Fiyat " + ilan.getPrice());
            List<Image> fotos = imageService.imageRepository.findByColumnAndValue("ilan", ilan);
            if (!fotos.isEmpty())
            {
                System.out.println(fotos.getFirst().getImageurl());
            }

            favouriteIlan.forEach(f ->
            {
                if (f.getIlan().equals(ilan))
                {
                    System.out.println("Bu ilan FAVORİNİZDEDİR!.");

                }
            });
        });

        System.out.println("************************************************************************************************************************************");

    }


    public void ilanlariListeleDetayli()
    {
        System.out.println("Detayli Gormek istediğiniz ilanın id'sini giriniz.");
        Long ilanId = scanner.nextLong(); scanner.nextLine();
        List<FavouriteIlan> favouriteIlan = favouriteIlanService.favouriteIlanRepository.findByColumnAndValue("user", SessionContext.loggedUser);
        Optional<Ilan> ilanOptional = ilanRepository.findById(ilanId);
        if (ilanOptional.isPresent())
        {
            Ilan ilan = ilanOptional.get();
            System.out.println("************************************************************************************************************************************");
            System.out.println("Ilan No: " + ilan.getId());
            System.out.println("Username: " + ilan.getUser().getUsername());
            System.out.println("Tarih: " + ilan.getCreateat());
            System.out.println("Baslik: " + ilan.getTitle());
            System.out.println("Aciklama: " + ilan.getDescription());
            System.out.println("Adres: " + ilan.getKonum());
            System.out.println("Fiyat " + ilan.getPrice());
            List<Image> fotos = imageService.imageRepository.findByColumnAndValue("ilan", ilan);
            fotos.forEach(f -> System.out.println(f.getImageurl()));

            favouriteIlan.forEach(f ->
            {
                if (f.getIlan().equals(ilan))
                {
                    System.out.println("Bu ilan FAVORİNİZDEDİR!.");

                }
            });
            ilanIslemleri(ilanOptional.get());
        }
        System.out.println("************************************************************************************************************************************");


    }

    public void ilanIslemleri(Ilan ilan)
    {

        while (true)
        {
            System.out.println("1- Ilanı Favoriden Çıkar");
            System.out.println("2- Mesaj at");
            System.out.println("0- Ust Menu");
            int secim = scanner.nextInt();
            scanner.nextLine();
            switch (secim)
            {
                case 1:
                    favoriIlanCikarma(ilan);
                    break;
                case 2:
                    messageService.mesajAt(ilan);
                    break;
                case 0:

                    return;
            }
        }

    }



    public void favoriIlanSecme()
    {

        System.out.println("Favori ilanınızın id'sini giriniz.");
        Long ilanId = scanner.nextLong(); scanner.nextLine();
        Optional<Ilan> ilan = ilanRepository.findById(ilanId);
        List<FavouriteIlan> favouriteIlanList = favouriteIlanService.favouriteIlanRepository.findByColumnAndValue("user", SessionContext.loggedUser);

        if (!ilan.isPresent())
        {
            System.out.println("İlan mevcut mevcut değil");
            return;
        }
        for (FavouriteIlan favouriteIlan : favouriteIlanList)
        {
            if (favouriteIlan.getIlan().equals(ilan.get()))
            {
                System.out.println("Bu ilan zaten favorinizde.");
                return;
            }

        }

        favouriteIlanService.favouriteIlanRepository.save(FavouriteIlan.builder().user(SessionContext.loggedUser).ilan(ilan.get()).createat(LocalDate.now()).status(Status.ACTIVE).build());
    }

    public void favoriIlanCikarma(Ilan ilan)
    {
        List<FavouriteIlan> favoriIlan = favouriteIlanService.favouriteIlanRepository.findByColumnAndValue("ilan", ilan);
        favouriteIlanService.favouriteIlanRepository.deleteById(favoriIlan.getFirst().getId());
    }


}

