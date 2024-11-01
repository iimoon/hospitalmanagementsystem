package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.User_DAO_IMP;
import com.ty.hospitalapp.dto.User;

public class User_SERVICE {
	
	public User saveUser(User u) {
		User_DAO_IMP u_DAO_IMP = new User_DAO_IMP();
		User u_obj = u_DAO_IMP.saveUser(u);
		if(u_obj!=null) {
			return u_obj;
		} else {
			return null;
		}
	}
	
	public User getUserById(int uid) {
		User_DAO_IMP u_DAO_IMP = new User_DAO_IMP();
		User u_obj = u_DAO_IMP.getUserById(uid);
		if(u_obj!=null) {
			return u_obj;
		} else {
			return null;
		}
	}
	
	public List<User> getAlluser() {
		User_DAO_IMP u_DAO_IMP = new User_DAO_IMP();
		List<User> u_obj = u_DAO_IMP.getAllUser();
		if(u_obj!=null) {
			return u_obj;
		} else {
			return null;
		}
	}
	
	public User getUserByName(String n) {
		User_DAO_IMP u_DAO_IMP = new User_DAO_IMP();
		User u_obj = u_DAO_IMP.getUserByName(n);
		if(u_obj!=null) {
			return u_obj;
		} else {
			return null;
		}
	}
	
	public User getUserByRole(String r) {
		User_DAO_IMP u_DAO_IMP = new User_DAO_IMP();
		User u_obj = u_DAO_IMP.getUserByRole(r);
		if(u_obj!=null) {
			return u_obj;
		} else {
			return null;
		}
	}
	
	public void deleteUserById(int uid) {
		User_DAO_IMP u_DAO_IMP = new User_DAO_IMP();
		boolean flag = u_DAO_IMP.deleteUSerById(uid);
		if(flag) {
			System.out.println("Delete data");;
		} else {
			System.out.println("Failed to delete data");;
		}
	}
}
