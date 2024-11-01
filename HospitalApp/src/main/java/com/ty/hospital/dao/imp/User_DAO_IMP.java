package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.User_DAO;
import com.ty.hospitalapp.dto.User;

public class User_DAO_IMP implements User_DAO {

    @Override
    public User saveUser(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        return user;
    }

    @Override
    public User getUserById(int uid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, uid);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
    }

    @Override
    public User getUserByName(String uname) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        User user = em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class)
            .setParameter("name", uname).getSingleResult();
        return user;
    }

    @Override
    public User getUserByRole(String role) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        User user = em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class)
            .setParameter("role", role).getSingleResult();
        return user;
    }

    @Override
    public boolean deleteUSerById(int uid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        User user = em.find(User.class, uid);
        if (user != null) {
            et.begin();
            em.remove(user);
            et.commit();
            return true;
        } else {
            return false;
        }
    }
}
