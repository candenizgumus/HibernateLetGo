package com.candenizgumus.services;

import com.candenizgumus.entities.Ilan;
import com.candenizgumus.entities.Message;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.MessageRepository;
import com.candenizgumus.utility.SessionContext;

import java.time.LocalDate;
import java.util.Scanner;

public class MessageService
{
    MessageRepository messageRepository;
    Scanner scanner = new Scanner(System.in);


    public MessageService()
    {
        this.messageRepository = new MessageRepository();
    }

    public void mesajAt(Ilan ilan){
        System.out.println("Kullanıcıya göndermek istediğiniz mesajı giriniz.");
        String mesaj = scanner.nextLine();
        messageRepository.save(Message.builder().text(mesaj).sender(SessionContext.loggedUser).receiver(ilan.getUser()).send_date(LocalDate.now()).status(Status.ACTIVE).build());

    }

    public void mesajlarimiGoruntule(){
        messageRepository.findByColumnAndValue("receiver",SessionContext.loggedUser).forEach(message -> System.out.println(message.getSender().getUsername() + " adlı kullanıcı tarafından mesajınız: " + message.getText() + " gonderim tarihi: " + message.getSend_date()));
    }
}
