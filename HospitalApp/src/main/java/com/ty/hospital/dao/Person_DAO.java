package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Person;

public interface Person_DAO {
	public Person savePerson(int pid,Person person);
	public Person getPersonById(int pid);
	public List<Person> getAllPerson();
	public boolean deleteByPersonId(int pid);
	public List<Person> getPersonByGender(String gender);
	public List<Person> getPersonByAge(int age);
	public Person getPersonByPhone(long phno);
	
}
