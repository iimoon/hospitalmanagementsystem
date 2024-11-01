package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.Observation_DAO;
import com.ty.hospitalapp.dto.Observation;

public class Observation_DAO_IMP implements Observation_DAO {

    @Override
    public Observation savedObservation(int oid, Observation observation) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(observation);
        et.commit();
        return observation;
    }

    @Override
    public Observation getObservationById(int oid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        Observation observation = em.find(Observation.class, oid);
        return observation;
    }

    @Override
    public List<Observation> getAllObservation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<Observation> observations = em.createQuery("SELECT o FROM Observation o", Observation.class).getResultList();
        return observations;
    }

    @Override
    public boolean deleteObservationById(int oid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Observation observation = em.find(Observation.class, oid);
        if (observation != null) {
            et.begin();
            em.remove(observation);
            et.commit();
            return true;
        } else {
            return false;
        }
    }
}
