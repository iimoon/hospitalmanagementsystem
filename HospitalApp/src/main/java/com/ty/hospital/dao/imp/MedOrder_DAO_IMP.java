package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.MedOrder_DAO;
import com.ty.hospitalapp.dto.MedOrder;

public class MedOrder_DAO_IMP implements MedOrder_DAO {

    @Override
    public MedOrder saveMedOrder(int mid, MedOrder medOrder) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(medOrder);
        et.commit();
        return medOrder;
    }

    @Override
    public boolean deleteMedOrderById(int mid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        MedOrder medOrder = em.find(MedOrder.class, mid);
        if (medOrder != null) {
            et.begin();
            em.remove(medOrder);
            et.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MedOrder getMedOrderById(int mid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        MedOrder medOrder = em.find(MedOrder.class, mid);
        return medOrder;
    }

    @Override
    public List<MedOrder> getAllMedOrder() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<MedOrder> medOrders = em.createQuery("SELECT m FROM MedOrder m", MedOrder.class).getResultList();
        return medOrders;
    }

    @Override
    public List<MedOrder> getMedOrderByDoctorName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<MedOrder> medOrders = em.createQuery("SELECT m FROM MedOrder m WHERE m.dname = :name", MedOrder.class)
            .setParameter("name", name).getResultList();
        return medOrders;
    }

    @Override
    public List<MedOrder> getMedOrderByData(String date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<MedOrder> medOrders = em.createQuery("SELECT m FROM MedOrder m WHERE m.date = :date", MedOrder.class)
            .setParameter("date", date).getResultList();
        return medOrders;
    }

    @Override
    public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        MedOrder existingMedOrder = em.find(MedOrder.class, mid);
        if (existingMedOrder != null) {
            existingMedOrder.setDname(medOrder.getDname());
            existingMedOrder.setDate(medOrder.getDate());
            existingMedOrder.setTotal(medOrder.getTotal());
            existingMedOrder.setItems(medOrder.getItems());
            existingMedOrder.setEncounters(medOrder.getEncounters());
            et.begin();
            em.merge(existingMedOrder);
            et.commit();
            return existingMedOrder;
        }
        return null;
    }
}
