package com.candenizgumus.services;

import com.candenizgumus.entities.User;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.MessageRepository;
import com.candenizgumus.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
                return Optional.ofNullable(kullaniciAdiListesi.getFirst());
            }else
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
        while(true)
        {
            System.out.println("Kullanıcı adı giriniz.");
            kullaniciadi = scanner.nextLine();

            List<User> userList = userRepository.findByColumnAndValue("username", kullaniciadi);
            if (!userList.isEmpty())
            {
                System.out.println("Kullanici adi daha once alinmistir.");

            }else
            {
                break;
            }

        }

        System.out.println("Şifre Giriniz.");
        String sifre = scanner.nextLine();

        String email;
        while(true)
        {
            System.out.println("Email Giriniz.");
            email = scanner.nextLine();
            List<User> emailList = userRepository.findByColumnAndValue("email", email);
            if (!emailList.isEmpty())
            {
                System.out.println("Email daha once alinmistir.");

            }else
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

        userRepository.save(User.builder().username(kullaniciadi).password(sifre).email(email).tel(telefon).profileimageurl(profileImage).konum(konum).createat(LocalDate.now()).status(Status.ACTIVE).build());
        return true;


    }
}
