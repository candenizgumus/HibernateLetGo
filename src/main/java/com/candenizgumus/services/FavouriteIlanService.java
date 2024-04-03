package com.candenizgumus.services;

import com.candenizgumus.entities.FavouriteIlan;
import com.candenizgumus.entities.Ilan;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.FavouriteIlanRepository;
import com.candenizgumus.utility.SessionContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FavouriteIlanService
{
    FavouriteIlanRepository favouriteIlanRepository;



    public FavouriteIlanService()
    {
        this.favouriteIlanRepository = new FavouriteIlanRepository();
    }


}
