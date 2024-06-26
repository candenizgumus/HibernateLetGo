package com.candenizgumus.services;

import com.candenizgumus.constants.Constants;
import com.candenizgumus.entities.FavouriteIlan;
import com.candenizgumus.entities.Ilan;
import com.candenizgumus.entities.User;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.MessageRepository;
import com.candenizgumus.repositories.UserRepository;
import com.candenizgumus.utility.SessionContext;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService
{
    UserRepository userRepository;

    Scanner scanner = new Scanner(System.in);

    public UserService()
    {
        this.userRepository = new UserRepository();

    }

    public Optional<User> login()
    {

            System.out.println("Kullanıcı adı giriniz.");
            String kullaniciadi = scanner.nextLine();
            System.out.println("Şifre Giriniz.");
            String sifre = scanner.nextLine();

            List<User> kullaniciAdiListesi = userRepository.findByColumnAndValue("username", kullaniciadi);

            if (!kullaniciAdiListesi.isEmpty())
            {
                if (kullaniciAdiListesi.getFirst().getPassword().equals(sifre))
                {
                    SessionContext.loggedUser = (kullaniciAdiListesi.getFirst());
                    return Optional.ofNullable(kullaniciAdiListesi.getFirst());
                } else
                {
                    System.out.println("Kullanici adi veya sifre hatali.");
                    return Optional.empty();
                }

            }
            System.out.println("Kullanici adi veya sifre hatali.");
            return Optional.empty();


    }


    public boolean register()
    {

        String kullaniciadi;
        while (true)
        {
            System.out.println("Kullanıcı adı giriniz.");
            kullaniciadi = scanner.nextLine();

            List<User> userList = userRepository.findByColumnAndValue("username", kullaniciadi);
            if (!userList.isEmpty())
            {
                System.out.println("Kullanici adi daha once alinmistir.");

            } else
            {
                break;
            }

        }

        System.out.println("Şifre Giriniz.");
        String sifre = scanner.nextLine();

        String email;
        while (true)
        {
            System.out.println("Email Giriniz.");
            email = scanner.nextLine();
            List<User> emailList = userRepository.findByColumnAndValue("email", email);
            if (!isValidEmail(email))
            {
                System.out.println("Email format hatasi");

            } else if (!emailList.isEmpty())
            {
                System.out.println("Email daha once alinmistir.");

            } else
            {
                break;
            }
        }

        System.out.println("Tel no Giriniz.");
        String telefon = scanner.nextLine();
        System.out.println("profile imageurl Giriniz.");
        String profileImage = scanner.nextLine();
        System.out.println("Konum Giriniz.");
        String konum = scanner.nextLine();
        User loggedUser = User.builder().username(kullaniciadi).password(sifre).email(email).tel(telefon).profileimageurl(profileImage).konum(konum).createat(LocalDate.now()).status(Status.ACTIVE).build();
        userRepository.save(loggedUser);

        return true;


    }

    private boolean isValidEmail(String email)
    {
        Matcher matcher = Constants.EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }


    public void userMenu()
    {
        while (true)
        {
            System.out.println("1- Ilan ver");
            System.out.println("2- Ilanları Detaysiz Listele");
            System.out.println("3- Ilanları Detayli Listele");
            System.out.println("4- Favori İlan Seçme");
            System.out.println("5- Mesajları Goruntule");
            System.out.println("6- Kategoriye göre arama");
            System.out.println("7- Konuma göre arama");
            System.out.println("0- Üst Menü");
            Integer secim;
            try
            {
                System.out.println("seçim giriniz");
                secim = scanner.nextInt(); scanner.nextLine();
            } catch (InputMismatchException e)
            {
                throw new RuntimeException("boş giremezsiniz");
            }
            switch (secim)
            {
                case 1:
                    LetGoServices.ilanService.ilanVer();
                    break;
                case 2:
                    LetGoServices.ilanService.ilanlariGosterDetaysiz();
                    break;
                case 3:
                    LetGoServices.ilanService.ilanlariListeleDetayli();
                    break;
                case 4:
                    LetGoServices.ilanService.favoriIlanSecme();
                    break;
                case 5:
                    LetGoServices.messageService.mesajlarimiGoruntule();
                    break;
                case 6:
                    searchByCategory();
                    break;
                case 7:
                    searchByLocation();
                    break;
                case 0:
                    return;

            }
        }
    }

    public void searchByCategory(){
        LetGoServices.categoryService.categoryRepository.getAllParentCategories().forEach(System.out::println);
        System.out.println("Bir parent kategory giriniz.");
        String secilenParentCategory = scanner.nextLine();
        LetGoServices.categoryService.categoryRepository.getCategoriesByParentName(secilenParentCategory).forEach(System.out::println);
        System.out.println("Bir child kategori seciniz.");
        String childCategory = scanner.nextLine();
        LetGoServices.ilanService.ilanlariGosterDetaysizKategoriyeGore(secilenParentCategory,childCategory);
    }

    public void searchByLocation(){
        System.out.println("Bir konum seciniz.");
        String konum = scanner.nextLine();
        LetGoServices.ilanService.ilanlariGosterDetaysizKonumaGore(konum);
    }




}
