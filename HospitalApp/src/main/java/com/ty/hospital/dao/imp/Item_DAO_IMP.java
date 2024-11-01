package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.Item_DAO;
import com.ty.hospitalapp.dto.Item;

public class Item_DAO_IMP implements Item_DAO {

    @Override
    public Item saveItem(int iid, Item item) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(item);
        et.commit();
        return item;
    }

    @Override
    public List<Item> getAllItem() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<Item> items = em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        return items;
    }

    @Override
    public boolean deleteById(int iid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Item item = em.find(Item.class, iid);
        if (item != null) {
            et.begin();
            em.remove(item);
            et.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Item getItemById(int iid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        Item item = em.find(Item.class, iid);
        return item;
    }
}
