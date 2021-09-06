package com.animalapp.many2many;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "food_item_table")
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer food_item_id;

	private String name;
	private Integer quantity;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "animal_food_item", joinColumns = {
	@JoinColumn(name = "food_item_id", referencedColumnName = "food_item_id") }, inverseJoinColumns = {
	@JoinColumn(name = "animal_id", referencedColumnName = "animal_id") 
	})
	private List<Animal> animalList = new ArrayList<Animal>();

	public FoodItem() {
	}

	public FoodItem(String name, Integer quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public Integer getFood_item_id() {
		return food_item_id;
	}

	public void setFood_item_id(Integer food_item_id) {
		this.food_item_id = food_item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	@Override
	public String toString() {
		return "FoodItem [food_item_id=" + food_item_id + ", name=" + name + ", quantity=" + quantity + "]";
	}

}
