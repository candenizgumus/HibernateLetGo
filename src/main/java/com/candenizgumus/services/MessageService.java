package com.candenizgumus.services;

import com.candenizgumus.repositories.ImageRepository;
import com.candenizgumus.repositories.MessageRepository;

public class MessageService
{
    MessageRepository messageRepository;

    public MessageService()
    {
        this.messageRepository = new MessageRepository();
    }
}
