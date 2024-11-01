package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.Hospital_DAO_IMP;
import com.ty.hospitalapp.dto.Hospital;

public class Hospital_SERVICE {
	public void saveHospital(Hospital h) {
		Hospital_DAO_IMP h_DAOIMP = new Hospital_DAO_IMP();
		Hospital h_obj = h_DAOIMP.saveHospital(h);
		if(h_obj!=null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data Not Saved");
		}
	}
	
	public List<Hospital> getAllHospital(int hid) {
		Hospital_DAO_IMP h_DAOIMP = new Hospital_DAO_IMP();
		List<Hospital> h_obj = h_DAOIMP.getAllHospital();
		if(h_obj!=null) {
			return h_obj;
		} else {
			return null;
		}
	}
	
	public Hospital getHospitalById(int hid) {
		Hospital_DAO_IMP h_DAOIMP = new Hospital_DAO_IMP();
		Hospital h_obj = h_DAOIMP.getHospitalById(hid);
		if(h_obj!=null) {
			return h_obj;
		} else {
			return null;
		}
	}
	
	public void deleteHospitalById(int hid) {
		Hospital_DAO_IMP h_DAOIMP = new Hospital_DAO_IMP();
		boolean flag = h_DAOIMP.deleteHospitalById(hid);
		if(flag) {
			System.out.println("Data deleted successfully");;
		} else {
			System.out.println("Unable to delete data");
		}
	}
	
	public Hospital updateHospitalById(int hid, Hospital h) {
		Hospital_DAO_IMP h_DAOIMP = new Hospital_DAO_IMP();
		Hospital h_obj = h_DAOIMP.UpdateHospitalById(hid, h);
		if(h_obj!=null) {
			return h_obj;
		} else {
			return null;
		}
	}
	
}
