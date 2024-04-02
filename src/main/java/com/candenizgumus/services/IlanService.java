package com.candenizgumus.services;

import com.candenizgumus.repositories.IlanRepository;

public class IlanService
{
    IlanRepository ilanRepository;

    public IlanService()
    {
        this.ilanRepository = new IlanRepository();
    }
}
