package com.ty.hospitalapp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String reason;
	private String dateofjoin;
	private int discharge;
	@OneToMany(mappedBy = "encounter")
	private List<Observation>observations;
	@ManyToOne
	@JoinColumn
	private Person persons;
	@ManyToOne
	@JoinColumn
	private Branch branches;
	@OneToMany(mappedBy = "encounters")
	private List<MedOrder>medorders;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) { 
		this.eid = eid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public int getDischarge() {
		return discharge;
	}
	public void setDischarge(int discharge) {
		this.discharge = discharge;
	}
	public List<Observation> getObservations() {
		return observations;
	}
	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}
	public Person getPersons() {
		return persons;
	}
	public void setPersons(Person persons) {
		this.persons = persons;
	}
	public Branch getBranches() {
		return branches;
	}
	public void setBranches(Branch branches) {
		this.branches = branches;
	}
	public List<MedOrder> getMedorders() {
		return medorders;
	}
	public void setMedorders(List<MedOrder> medorders) {
		this.medorders = medorders;
	}
	

}

