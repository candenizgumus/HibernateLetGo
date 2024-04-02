package com.candenizgumus.services;

import com.candenizgumus.entities.Category;
import com.candenizgumus.entities.Ilan;
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
    CategoryRepository categoryRepository;
    Scanner scanner = new Scanner(System.in);

    public IlanService()
    {
        this.ilanRepository = new IlanRepository();
        this.categoryRepository = new CategoryRepository();
    }

    public void ilanVer(){
        System.out.println("Kategori Seçiniz");
        categoryRepository.getAllParentCategories().forEach(System.out::println);
        System.out.println("Bir parent kategory giriniz.");
        String secilenParentCategory = scanner.nextLine();
        categoryRepository.getCategoriesByParentName(secilenParentCategory).forEach(System.out::println);
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
        List<Category> category = categoryRepository.findByColumnAndValue("name", altKategori);
        ilanRepository.save(Ilan.builder().user(SessionContext.loggedUser).category(category.getFirst()).title(baslik).description(description).konum(konum).price(fiyat).createat(LocalDate.now()).status(Status.ACTIVE).build());


    }
}
