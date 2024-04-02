package com.candenizgumus.repositories;



import com.candenizgumus.entities.Message;

public class MessageRepository extends RepositoryManager<Message,Long>
{
    public MessageRepository()
    {
        super(Message.class);
    }
}
