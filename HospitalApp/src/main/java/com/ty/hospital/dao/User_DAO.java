package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.User;

public interface User_DAO {
	public User saveUser(User user);
	public User getUserById(int uid);
	public List<User> getAllUser();
	public User getUserByName(String uname);
	public User getUserByRole(String color);
	public boolean deleteUSerById(int uid);
}
