package com.candenizgumus.services;


import com.candenizgumus.repositories.FavouriteIlanRepository;




public class FavouriteIlanService
{
    FavouriteIlanRepository favouriteIlanRepository;



    public FavouriteIlanService()
    {
        this.favouriteIlanRepository = new FavouriteIlanRepository();
    }


}
