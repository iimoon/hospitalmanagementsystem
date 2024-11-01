package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Address;

public interface Address_DAO {
	public Address saveAddress(int aid, Address address);
	public boolean deleteAddressById(int aid);
	public List<Address> getAddressAll();
	public Address getAddressById(int aid);
	public Address updateAddressById(int aid, Address address);
}
