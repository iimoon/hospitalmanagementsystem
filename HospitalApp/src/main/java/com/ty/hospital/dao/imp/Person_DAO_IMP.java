package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.Person_DAO;
import com.ty.hospitalapp.dto.Person;

public class Person_DAO_IMP implements Person_DAO {

    @Override
    public Person savePerson(int pid, Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(person);
        et.commit();
        return person;
    }

    @Override
    public Person getPersonById(int pid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, pid);
        return person;
    }

    @Override
    public List<Person> getAllPerson() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        return persons;
    }

    @Override
    public boolean deleteByPersonId(int pid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Person person = em.find(Person.class, pid);
        if (person != null) {
            et.begin();
            em.remove(person);
            et.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Person> getPersonByGender(String gender) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("SELECT p FROM Person p WHERE p.gender = :gender", Person.class)
            .setParameter("gender", gender).getResultList();
        return persons;
    }

    @Override
    public List<Person> getPersonByAge(int age) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("SELECT p FROM Person p WHERE p.age = :age", Person.class)
            .setParameter("age", age).getResultList();
        return persons;
    }

    @Override
    public Person getPersonByPhone(long phno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
        EntityManager em = emf.createEntityManager();
        Person person = em.createQuery("SELECT p FROM Person p WHERE p.phno = :phno", Person.class)
            .setParameter("phno", phno).getSingleResult();
        return person;
    }
}
