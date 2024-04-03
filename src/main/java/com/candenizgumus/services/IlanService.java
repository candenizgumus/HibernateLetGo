package com.candenizgumus.services;

import com.candenizgumus.entities.Category;
import com.candenizgumus.entities.Ilan;
import com.candenizgumus.entities.Image;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.CategoryRepository;
import com.candenizgumus.repositories.IlanRepository;
import com.candenizgumus.utility.SessionContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class IlanService
{
    IlanRepository ilanRepository;
    CategoryService categoryService;
    ImageService imageService;

    Scanner scanner = new Scanner(System.in);

    public IlanService()
    {
        this.ilanRepository = new IlanRepository();
        this.categoryService = new CategoryService();
        this.imageService = new ImageService();

    }

    public void ilanVer(){
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
        Double fiyat = scanner.nextDouble(); scanner.nextLine();






        List<Category> category = categoryService.categoryRepository.findByColumnAndValue("name", altKategori);
        Ilan ilan = ilanRepository.save(Ilan.builder().user(SessionContext.loggedUser).category(category.getFirst()).title(baslik).description(description).konum(konum).price(fiyat).createat(LocalDate.now()).status(Status.ACTIVE).build());

        List<String> fotoURLS = imageService.fotografAl0YazanaKadar();
        fotoURLS.forEach(f -> imageService.imageRepository.save(Image.builder().createat(LocalDate.now()).status(Status.ACTIVE).ilan(ilan).imageurl(f).build()));

    }


    public void ilanlariListele(){
        List<Ilan> butunIlanlar = ilanRepository.findAll();
        butunIlanlar.forEach(ilan -> {
            System.out.println("************************************************************************************************************************************");
            System.out.println("Ilan No: "+ ilan.getId());
            System.out.println("Username: " + ilan.getUser().getUsername());
            System.out.println("Tarih: " + ilan.getCreateat());
            System.out.println("Baslik: " + ilan.getTitle());
            System.out.println("Aciklama: " + ilan.getDescription());
            System.out.println("Adres: " + ilan.getKonum());
            System.out.println("Fiyat " + ilan.getPrice());
            List<Image> fotos = imageService.imageRepository.findByColumnAndValue("ilan", ilan);
            fotos.forEach(f-> System.out.println(f.getImageurl()));

        });

        System.out.println("************************************************************************************************************************************");
    }
}
