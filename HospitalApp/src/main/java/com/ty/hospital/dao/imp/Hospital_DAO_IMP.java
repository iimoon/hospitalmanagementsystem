package com.ty.hospital.dao.imp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.Hospital_DAO;
import com.ty.hospitalapp.dto.Hospital;

public class Hospital_DAO_IMP implements Hospital_DAO {

    @Override
    public Hospital saveHospital(Hospital hospital) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(hospital);
        et.commit();
        
        em.close();
        emf.close();
        return hospital;
    }

    @Override
    public List<Hospital> getAllHospital() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imoon");
        EntityManager em = emf.createEntityManager();
        
        List<Hospital> hospitals = em.createQuery("SELECT h FROM Hospital h", Hospital.class).getResultList();
        
        em.close();
        emf.close();
        return hospitals;
    }

    @Override
    public boolean deleteHospitalById(int hid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imoon");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Hospital hospital = em.find(Hospital.class, hid);
        if (hospital != null) {
            et.begin();
            em.remove(hospital);
            et.commit();
            em.close();
            emf.close();
            return true;
        }

        em.close();
        emf.close();
        return false;
    }

    @Override
    public Hospital getHospitalById(int hid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imoon");
        EntityManager em = emf.createEntityManager();
        
        Hospital hospital = em.find(Hospital.class, hid);
        
        em.close();
        emf.close();
        return hospital;
    }

    @Override
    public Hospital UpdateHospitalById(int hid, Hospital hospital) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imoon");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Hospital existingHospital = em.find(Hospital.class, hid);
        if (existingHospital != null) {
            existingHospital.setName(hospital.getName());
            existingHospital.setWebsite(hospital.getWebsite());
            et.begin();
            em.merge(existingHospital);
            et.commit();
        }
        
        em.close();
        emf.close();
        return existingHospital;
    }
}
