package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.Encounter_DAO_IMP;
import com.ty.hospitalapp.dto.Encounter;

public class Encounter_SERVICE {
	public Encounter saveEncounter(int eid, Encounter e) {
		Encounter_DAO_IMP e_DAO_IMP = new Encounter_DAO_IMP();
		Encounter e_obj = e_DAO_IMP.saveEncounter(eid, e);
		if(e_obj!=null) {
			return e_obj;
		} else {
			return null;
		}
	}
	
	public List<Encounter> getAllEncounter(){
		Encounter_DAO_IMP e_DAO_IMP = new Encounter_DAO_IMP();
		List<Encounter> e_obj = e_DAO_IMP.getAllEncounter();
		if(e_obj!=null) {
			return e_obj;
		} else {
			return null;
		}
	}
	
	public void deleteEncounterById(int eid) {
		Encounter_DAO_IMP e_DAO_IMP = new Encounter_DAO_IMP();
		boolean flag = e_DAO_IMP.deleteEncoutnerById(eid);
		if(flag) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Failed to delete data");
		}
	}
	
	public Encounter getEncounterById(int eid) {
		Encounter_DAO_IMP e_DAO_IMP = new Encounter_DAO_IMP();
		Encounter e_obj = e_DAO_IMP.getEncounterById(eid);
		if(e_obj!=null) {
			return e_obj;
		}else {
			return null;
		}
	}
	
	public Encounter updateEncounterById(int eid, Encounter e) {
		Encounter_DAO_IMP e_DAO_IMP = new Encounter_DAO_IMP();
		Encounter e_obj = e_DAO_IMP.updateEncounterById(eid, e);
		if(e_obj!=null) {
			return e_obj;
		} else {
			return null;
		}
	}
}
