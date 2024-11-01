package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.MedOrder;

public interface MedOrder_DAO {
	public MedOrder saveMedOrder(int mid,MedOrder medOrder);
	public boolean deleteMedOrderById(int mid);
	public MedOrder getMedOrderById(int mid);
	public List<MedOrder> getAllMedOrder();
	public List<MedOrder> getMedOrderByDoctorName(String name);
	public List<MedOrder> getMedOrderByData(String name);
	public MedOrder updateMedOrderById(int mid,MedOrder medOrder);
}
