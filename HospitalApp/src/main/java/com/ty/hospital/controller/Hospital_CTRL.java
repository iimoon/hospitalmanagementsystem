package com.ty.hospital.controller;

import com.ty.hospital.services.Hospital_SERVICE;
import com.ty.hospitalapp.dto.Hospital;

public class Hospital_CTRL {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		Hospital_SERVICE h_s = new Hospital_SERVICE();
		hospital.setName("suguna");
		hospital.setWebsite("www.suguna-cares.com");
		h_s.saveHospital(hospital);
	}
}
