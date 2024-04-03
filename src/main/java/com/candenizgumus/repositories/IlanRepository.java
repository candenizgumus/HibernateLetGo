package com.candenizgumus.repositories;


import com.candenizgumus.entities.Ilan;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class IlanRepository extends RepositoryManager<Ilan,Long>
{
    public IlanRepository()
    {
        super(Ilan.class);
    }

    public List<Ilan> getIlansByCategory(String parentName, String childName) {
        TypedQuery<Ilan> query = getEntityManager().createQuery(
                "SELECT i FROM Ilan i WHERE i.category.parentCategory =:parentName  AND i.category.name =: childName", Ilan.class);
        query.setParameter("parentName", parentName);
        query.setParameter("childName", childName);

        return query.getResultList();
    }

    public List<Ilan> getIlansByLocation(String location) {
        TypedQuery<Ilan> query = getEntityManager().createQuery(
                "SELECT i FROM Ilan i WHERE i.konum =:location", Ilan.class);
        query.setParameter("location", location);


        return query.getResultList();
    }
}
