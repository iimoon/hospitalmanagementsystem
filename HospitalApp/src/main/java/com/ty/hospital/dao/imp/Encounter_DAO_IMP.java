package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.Encounter_DAO;
import com.ty.hospitalapp.dto.Encounter;

public class Encounter_DAO_IMP implements Encounter_DAO {

    @Override
    public Encounter saveEncounter(int eid, Encounter encounter) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(encounter);
        et.commit();
        return encounter;
    }

    @Override
    public List<Encounter> getAllEncounter() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<Encounter> encounters = em.createQuery("SELECT e FROM Encounter e", Encounter.class).getResultList();
        return encounters;
    }

    @Override
    public boolean deleteEncoutnerById(int eid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Encounter encounter = em.find(Encounter.class, eid);
        if (encounter != null) {
            et.begin();
            em.remove(encounter);
            et.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Encounter getEncounterById(int eid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        Encounter encounter = em.find(Encounter.class, eid);
        return encounter;
    }

    @Override
    public Encounter updateEncounterById(int eid, Encounter encounter) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Encounter encounter2 = em.find(Encounter.class, eid);
        if (encounter2 != null) {
            encounter2.setReason(encounter.getReason());
            encounter2.setDateofjoin(encounter.getDateofjoin());
            encounter2.setDischarge(encounter.getDischarge());
            encounter2.setObservations(encounter.getObservations());
            encounter2.setPersons(encounter.getPersons());
            encounter2.setBranches(encounter.getBranches());
            encounter2.setMedorders(encounter.getMedorders());
            et.begin();
            em.merge(encounter2);
            et.commit();
            return encounter2;
        }
        return null;
    }
}
