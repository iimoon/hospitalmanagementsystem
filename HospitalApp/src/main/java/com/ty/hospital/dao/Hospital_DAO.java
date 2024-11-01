package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Hospital;

public interface Hospital_DAO {
	public Hospital saveHospital(Hospital hospital);
	public List<Hospital> getAllHospital();
	public boolean deleteHospitalById(int hid);
	public Hospital getHospitalById(int hid);
	public Hospital UpdateHospitalById(int hid,Hospital hospital);
	
}
