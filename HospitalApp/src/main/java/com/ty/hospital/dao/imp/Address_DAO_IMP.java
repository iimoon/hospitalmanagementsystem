package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.Address_DAO;
import com.ty.hospitalapp.dto.Address;

public class Address_DAO_IMP implements Address_DAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("imoon");

    @Override
    public Address saveAddress(int aid, Address address) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(address);
            et.commit();
            return address;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace(); // Log or handle the exception
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteAddressById(int aid) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Address address = em.find(Address.class, aid);
            if (address != null) {
                et.begin();
                em.remove(address);
                et.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace(); // Log or handle the exception
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Address> getAddressAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Address getAddressById(int aid) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Address.class, aid);
        } finally {
            em.close();
        }
    }

    @Override
    public Address updateAddressById(int aid, Address address) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Address address2 = em.find(Address.class, aid);
            if (address2 != null) {
                address2.setStreet(address.getStreet());
                address2.setState(address.getState());
                address2.setCountry(address.getCountry());
                address2.setPin(address.getPin());
                et.begin();
                em.merge(address2);
                et.commit();
                return address2;
            }
            return null;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace(); // Log or handle the exception
            return null;
        } finally {
            em.close();
        }
    }
}
