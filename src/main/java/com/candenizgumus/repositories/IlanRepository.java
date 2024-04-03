package com.candenizgumus.repositories;


import com.candenizgumus.entities.Ilan;
import jakarta.persistence.TypedQuery;

public class IlanRepository extends RepositoryManager<Ilan,Long>
{
    public IlanRepository()
    {
        super(Ilan.class);
    }


}
