package com.els.clubService.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookClubRepository {

    public void saveBookClub(BookClub bookClub) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("book-club");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(bookClub);
        em.getTransaction().commit();
        em.close();
    }
}
