package com.els.clubService.model;

import java.util.UUID;

import com.els.clubService.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BookClubRepository {

    public boolean saveBookClub(BookClub bookClub) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(bookClub);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean addUserToClub(UUID userId, UUID bookClubId) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            BookClub bookClub = (BookClub) session.get(BookClub.class, bookClubId);
            bookClub.addMember(userId);
            session.save(bookClub);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }
}
