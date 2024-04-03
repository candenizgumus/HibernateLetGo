package com.candenizgumus.repositories;


import com.candenizgumus.entities.FavouriteIlan;
import jakarta.persistence.TypedQuery;

public class FavouriteIlanRepository extends RepositoryManager<FavouriteIlan,Long>
{
    public FavouriteIlanRepository()
    {
        super(FavouriteIlan.class);
    }


}
