package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Encounter;

public interface Encounter_DAO {
	public Encounter saveEncounter(int eid,Encounter encounter);
	public List<Encounter> getAllEncounter();
	public boolean deleteEncoutnerById(int eid);
	public Encounter getEncounterById(int eid);
	public Encounter updateEncounterById(int eid,Encounter encounter);
}
