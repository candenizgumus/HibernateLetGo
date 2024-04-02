package com.candenizgumus.services;

import com.candenizgumus.repositories.MessageRepository;
import com.candenizgumus.repositories.UserRepository;

public class UserService
{
    UserRepository userRepository;

    public UserService()
    {
        this.userRepository = new UserRepository();
    }
}
