package com.candenizgumus;

import com.candenizgumus.entities.User;
import com.candenizgumus.repositories.UserRepository;
import com.candenizgumus.services.UserService;

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
                secim = scanner.nextInt();
            }catch (InputMismatchException e){
                throw new RuntimeException("boş giremezsiniz");
            }
            switch (secim) {
                case 1:
                    Optional<User> loggedUser = userService.login();
                    break;
                case 2:
                    userService.register();
                    break;
            }
        }
    }
}