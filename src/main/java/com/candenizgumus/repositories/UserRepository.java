package com.candenizgumus.repositories;



import com.candenizgumus.entities.User;

public class UserRepository extends RepositoryManager<User,Long>
{
    public UserRepository()
    {
        super(User.class);
    }
}
