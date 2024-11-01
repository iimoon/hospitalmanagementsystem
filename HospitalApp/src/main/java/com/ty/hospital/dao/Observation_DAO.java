package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Observation;

public interface Observation_DAO {
	public Observation savedObservation(int oid, Observation observation);
	public Observation getObservationById(int oid);
	public List<Observation> getAllObservation();
	public boolean deleteObservationById(int oid);
	
}
