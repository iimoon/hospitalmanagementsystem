package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Item;

public interface Item_DAO {
	public Item saveItem(int iid,Item item);
	public List<Item> getAllItem();
	public boolean deleteById(int iid);
	public Item getItemById(int iid);
	
}
