package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Branch;

public interface Branch_DAO {
	public Branch saveBranch(int hid, Branch branch);
	public List<Branch> getAllBranch();
	public boolean deleteBranchById(int bid);
	public Branch getBranchById(int bid);
	public Branch updateBranchById(int bid, Branch branch);
}
