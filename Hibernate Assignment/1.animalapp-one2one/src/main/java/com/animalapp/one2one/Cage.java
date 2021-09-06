package com.animalapp.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cage_table")
public class Cage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cage_id;
	private Integer cage_no;
	private String location;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "animal_id")
	private Animal animal;

	public Cage() {
	}

	public Cage(Integer cage_no, String location) {
		this.cage_no = cage_no;
		this.location = location;
	}

	public Integer getCage_id() {
		return cage_id;
	}

	public void setCage_id(Integer cage_id) {
		this.cage_id = cage_id;
	}

	public Integer getCage_no() {
		return cage_no;
	}

	public void setCage_no(Integer cage_no) {
		this.cage_no = cage_no;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Cage [cage_id=" + cage_id + ", cage_no=" + cage_no + ", location=" + location + "]";
	}
}
