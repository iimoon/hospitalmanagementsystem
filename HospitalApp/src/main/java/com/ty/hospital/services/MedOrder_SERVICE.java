package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.MedOrder_DAO_IMP;
import com.ty.hospitalapp.dto.MedOrder;

public class MedOrder_SERVICE {

	public MedOrder saveMedOrder(int mid, MedOrder m) {
		MedOrder_DAO_IMP m_DAO_IMP = new MedOrder_DAO_IMP();
		MedOrder m_obj = m_DAO_IMP.saveMedOrder(mid, m);
		if(m_obj!=null) {
			return m_obj;
		} else {
			return null;
		}
	}
	
	public void deleteMedOrderById(int mid) {
		MedOrder_DAO_IMP m_DAO_IMP = new MedOrder_DAO_IMP();
		boolean flag = m_DAO_IMP.deleteMedOrderById(mid);
		if(flag) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Failed to delete data");
		}
	}
	
	public MedOrder getMedOrderById(int mid) {
		MedOrder_DAO_IMP m_DAO_IMP = new MedOrder_DAO_IMP();
		MedOrder m_obj = m_DAO_IMP.getMedOrderById(mid);
		if(m_obj!=null) {
			return m_obj;
		} else {
			return null;
		}
	}
	
	public List<MedOrder> getAllMedOrder(){
		MedOrder_DAO_IMP m_DAO_IMP = new MedOrder_DAO_IMP();
		List<MedOrder> m_obj = m_DAO_IMP.getAllMedOrder();
		if(m_obj!=null) {
			return m_obj;
		}else {
			return null;
		}
	}
	
	public List<MedOrder> getMedOrderByDoctorName(String n){
		MedOrder_DAO_IMP m_DAO_IMP = new MedOrder_DAO_IMP();
		List<MedOrder> m_obj = m_DAO_IMP.getMedOrderByDoctorName(n);
		if(m_obj!=null) {
			return m_obj;
		} else {
			return null;
		}
	}
	
	public List<MedOrder> getMedOrderByData(String d){
		MedOrder_DAO_IMP m_DAO_IMP = new MedOrder_DAO_IMP();
		List<MedOrder> m_obj = m_DAO_IMP.getMedOrderByData(d);
		if(m_obj!=null) {
			return m_obj;
		} else {
			return  null;
		}
	}
	
	public MedOrder updateMedOrderById(int mid, MedOrder m) {
		MedOrder_DAO_IMP m_DAO_IMP = new MedOrder_DAO_IMP();
		MedOrder m_obj = m_DAO_IMP.updateMedOrderById(mid, m);
		if(m_obj!=null) {
			return m_obj;
		} else {
			return null;
		}
	}
}
