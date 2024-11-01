package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.Observation_DAO_IMP;
import com.ty.hospitalapp.dto.Observation;

public class Observation_SERVICE {
	
	public Observation saveObservation(int oid, Observation o) {
		Observation_DAO_IMP o_DAO_IMP = new Observation_DAO_IMP();
		Observation o_obj = o_DAO_IMP.savedObservation(oid, o);
		if(o_obj!=null) {
			return o_obj;
		} else {
			return null;
		}
	}
	
	public Observation getObservationById(int oid) {
		Observation_DAO_IMP o_DAO_IMP = new Observation_DAO_IMP();
		Observation o_obj = o_DAO_IMP.getObservationById(oid);
		if(o_obj!=null) {
			return o_obj;
		} else {
			return null;
		}
	}
	
	public List<Observation> getAllObservation(){
		Observation_DAO_IMP o_DAO_IMP = new Observation_DAO_IMP();
		List<Observation> o_obj = o_DAO_IMP.getAllObservation();
		if(o_obj!=null) {
			return o_obj;
		} else {
			return null;
		}
	}
	
	public void deleteObservationById(int oid) {
		Observation_DAO_IMP o_DAO_IMP = new Observation_DAO_IMP();
		boolean flag = o_DAO_IMP.deleteObservationById(oid);
		if(flag) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Failed to delete data");
		}
	}
	
}
