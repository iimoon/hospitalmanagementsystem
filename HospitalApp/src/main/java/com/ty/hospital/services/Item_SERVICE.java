package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.Item_DAO_IMP;
import com.ty.hospitalapp.dto.Item;

public class Item_SERVICE {
	
	public Item saveItem(int iid, Item i) {
		Item_DAO_IMP i_DAO_IMP = new Item_DAO_IMP();
		Item i_obj = i_DAO_IMP.saveItem(iid, i);
		if(i_obj!=null) {
			return i_obj;
		}else {
			return null;
		}
	}
	
	public List<Item> getAllItem(){
		Item_DAO_IMP i_DAO_IMP = new Item_DAO_IMP();
		List<Item> i_obj = i_DAO_IMP.getAllItem();
		if(i_obj!=null) {
			return i_obj;
		} else {
			return null;
		}
	}
	
	public void deleteItemById(int iid) {
		Item_DAO_IMP i_DAO_IMP = new Item_DAO_IMP();
		boolean flag = i_DAO_IMP.deleteById(iid);
		if(flag) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Failed to delete");
		}
	}
	
	public Item getItemById(int iid) {
		Item_DAO_IMP i_DAO_IMP = new Item_DAO_IMP();
		Item i_obj = i_DAO_IMP.getItemById(iid);
		if(i_obj!=null) {
			return i_obj;
		} else {
			return null;
		}
	}
}
