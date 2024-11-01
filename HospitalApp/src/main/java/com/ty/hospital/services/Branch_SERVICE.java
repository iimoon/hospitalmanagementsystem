package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.Branch_DAO_IMP;
import com.ty.hospitalapp.dto.Branch;

public class Branch_SERVICE {

	public void saveBranch(int hid,Branch branch) {
		Branch_DAO_IMP b_DAO_IMP = new Branch_DAO_IMP();
		Branch b_obj = b_DAO_IMP.saveBranch(hid, branch);
		if(b_obj!=null) {
			System.out.println("Data saved");
		} else {
			System.out.println("Failed to save Data");
		}
	}
	
	public List<Branch> getAllBranch(){
		Branch_DAO_IMP b_DAO_IMP = new Branch_DAO_IMP();
		List<Branch> b_obj = b_DAO_IMP.getAllBranch();
		if(b_obj!=null) {
			return b_obj;
		} else {
			return null;
		}
	}
	
	public void deletBranchById(int bid) {
		Branch_DAO_IMP b_DAO_IMP = new Branch_DAO_IMP();
		boolean flag = b_DAO_IMP.deleteBranchById(bid);
		if(flag) {
			System.out.println("Delete data");
		} else {
			System.out.println("Failed to delete data");
		}
	}
	
	public Branch getBranchById(int bid) {
		Branch_DAO_IMP b_DAO_IMP = new Branch_DAO_IMP();
		Branch b_obj = b_DAO_IMP.getBranchById(bid);
		if(b_obj!=null) {
			return b_obj;
		} else {
			return null;
		}
	}
	
	public Branch updateBranchById(int bid, Branch b) {
		Branch_DAO_IMP b_DAO_IMP = new Branch_DAO_IMP();
		Branch b_obj = b_DAO_IMP.updateBranchById(bid, b);
		if(b_obj!=null) {
			return b_obj;
		} else {
			return null;
		}
	}
	
}
