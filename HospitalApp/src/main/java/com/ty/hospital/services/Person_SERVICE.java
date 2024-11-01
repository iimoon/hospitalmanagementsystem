package com.ty.hospital.services;

import java.util.List;

import com.ty.hospital.dao.imp.Person_DAO_IMP;
import com.ty.hospitalapp.dto.Person;

public class Person_SERVICE {
	
	public Person savePerson(int pid, Person p) {
		Person_DAO_IMP p_DAO_IMP = new Person_DAO_IMP();
		Person p_obj = p_DAO_IMP.savePerson(pid, p);
		if(p_obj!=null){
			return p_obj;
		} else {
			return null;
		}
	}
	
	public Person getPersonById( int pid) {
		Person_DAO_IMP p_DAO_IMP = new Person_DAO_IMP();
		Person p_obj = p_DAO_IMP.getPersonById(pid);
		if(p_obj!=null){
			return p_obj;
		} else {
			return null;
		}
	}
	
	public List<Person> getAllPerson() {
		Person_DAO_IMP p_DAO_IMP = new Person_DAO_IMP();
		List<Person> p_obj = p_DAO_IMP.getAllPerson();
		if(p_obj!=null){
			return p_obj;
		} else {
			return null;
		}
	}
	
	public void deletePersonById( int pid) {
		Person_DAO_IMP p_DAO_IMP = new Person_DAO_IMP();
		boolean flag = p_DAO_IMP.deleteByPersonId(pid);
		if(flag){
			System.out.println("Data deleted");;
		} else {
			System.out.println("Failed to delete data");;
		}
	}
	
	public List<Person> getPersonByGender( String gender) {
		Person_DAO_IMP p_DAO_IMP = new Person_DAO_IMP();
		List<Person> p_obj = p_DAO_IMP.getPersonByGender(gender);
		if(p_obj!=null){
			return p_obj;
		} else {
			return null;
		}
	}
	
	public List<Person> getPersonByAge(int age) {
		Person_DAO_IMP p_DAO_IMP = new Person_DAO_IMP();
		List<Person> p_obj = p_DAO_IMP.getPersonByAge(age);
		if(p_obj!=null){
			return p_obj;
		} else {
			return null;
		}
	}
	
	public Person getPersonByPhno( long p) {
		Person_DAO_IMP p_DAO_IMP = new Person_DAO_IMP();
		Person p_obj = p_DAO_IMP.getPersonByPhone(p);
		if(p_obj!=null){
			return p_obj;
		} else {
			return null;
		}
	}
}
