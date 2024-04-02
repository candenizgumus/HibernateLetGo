package com.candenizgumus.repositories;


import com.candenizgumus.entities.Ilan;

public class IlanRepository extends RepositoryManager<Ilan,Long>
{
    public IlanRepository()
    {
        super(Ilan.class);
    }
}
