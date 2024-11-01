package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.Branch_DAO;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Hospital;

public class Branch_DAO_IMP implements Branch_DAO {

    private EntityManagerFactory emf;

    public Branch_DAO_IMP() {
        this.emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");
    }

    @Override
    public Branch saveBranch(int hid, Branch branch) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();

            // Find the hospital by its ID
            Hospital hospital = em.find(Hospital.class, hid);
            if (hospital == null) {
                throw new IllegalArgumentException("Hospital with id " + hid + " not found");
            }

            // Set the hospital to the branch
            branch.setHospitals(hospital);

            em.persist(branch);
            et.commit();
            return branch;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Branch> getAllBranch() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Branch b", Branch.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteBranchById(int bid) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Branch branch = em.find(Branch.class, bid);
            if (branch != null) {
                et.begin();
                em.remove(branch);
                et.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public Branch getBranchById(int bid) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Branch.class, bid);
        } finally {
            em.close();
        }
    }

    @Override
    public Branch updateBranchById(int bid, Branch branch) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Branch existingBranch = em.find(Branch.class, bid);
            if (existingBranch != null) {
                et.begin();

                // Update fields
                existingBranch.setName(branch.getName());
                existingBranch.setPhno(branch.getPhno());
                existingBranch.setEmail(branch.getEmail());
                existingBranch.setAddress(branch.getAddress());

                if (branch.getHospitals() != null) {
                    Hospital hospital = em.find(Hospital.class, branch.getHospitals().getHid());
                    if (hospital != null) {
                        existingBranch.setHospitals(hospital);
                    } else {
                        throw new IllegalArgumentException("Hospital with id " + branch.getHospitals().getHid() + " not found");
                    }
                }

                em.merge(existingBranch);
                et.commit();
                return existingBranch;
            } else {
                return null;
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}
