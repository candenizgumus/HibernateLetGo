package com.candenizgumus;

import com.candenizgumus.entities.Category;
import com.candenizgumus.entities.User;
import com.candenizgumus.repositories.CategoryRepository;
import com.candenizgumus.repositories.UserRepository;
import com.candenizgumus.services.UserService;
import com.candenizgumus.utility.SessionContext;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Main
{
    static Scanner scanner = new Scanner(System.in);
    static UserService userService = new UserService();
    public static void main(String[] args)
    {

        menu();



    }

    public static void menu(){

        while (true) {
            System.out.println("1- Login");
            System.out.println("2- Register");
            System.out.println("0- Sistemi Kapat");
            Integer secim;
            try {
                System.out.println("seçim giriniz");
                secim = scanner.nextInt(); scanner.nextLine();
            }catch (InputMismatchException e){
                throw new RuntimeException("boş giremezsiniz");
            }
            switch (secim) {
                case 1:
                    userService.login();
                    userService.userMenu();
                    break;
                case 2:
                    userService.register();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}