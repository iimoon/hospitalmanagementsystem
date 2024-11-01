package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.Address_DAO_IMP;
import com.ty.hospitalapp.dto.Address;

public class Address_SERVICE {
	public void saveAddress(int aid,Address a) {
		Address_DAO_IMP a_DAO_IMP = new Address_DAO_IMP();
		Address a_obj = a_DAO_IMP.saveAddress(aid, a);
		if(a_obj!=null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data not saved!");
		}
	}
	
	public void deleteAddressById(int aid) {
		Address_DAO_IMP a_DAO_IMP = new Address_DAO_IMP();
		boolean flag = a_DAO_IMP.deleteAddressById(aid);
		if(flag) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Failed to Delete Data!");
		}
	}
	
	public List<Address> getAddressAll(){
		Address_DAO_IMP a_DAO_IMP = new Address_DAO_IMP();
		List<Address> a_obj = a_DAO_IMP.getAddressAll();
		if(a_obj!=null) {
			return a_obj;
		} else {
			return null;
		}
	}
	
	public Address getAddressById(int aid){
		Address_DAO_IMP a_DAO_IMP = new Address_DAO_IMP();
		Address a_obj = a_DAO_IMP.getAddressById(aid);
		if(a_obj!=null) {
			return a_obj;
		} else {
			return null;
		}
	}
	
	public Address updateAddressById(int aid, Address a) {
		Address_DAO_IMP a_DAO_IMP = new Address_DAO_IMP();
		Address a_obj = a_DAO_IMP.updateAddressById(aid, a);
		if(a_obj!=null) {
			return a_obj;
		} else {
			return null;
		}
	}
}
