package com.animalapp.many2many;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "animal_table3")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer animal_id;

	private String type;
	private Integer total_no;

	@ManyToMany(mappedBy = "animalList")
	private List<FoodItem> foodItemList = new ArrayList<FoodItem>();

	public Animal() {
	}

	public Animal(String type, Integer total_no) {
		this.type = type;
		this.total_no = total_no;
	}

	public Integer getAnimal_id() {
		return animal_id;
	}

	public void setAnimal_id(Integer animal_id) {
		this.animal_id = animal_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTotal_no() {
		return total_no;
	}

	public void setTotal_no(Integer total_no) {
		this.total_no = total_no;
	}

	public List<FoodItem> getFoodItemList() {
		return foodItemList;
	}

	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemList = foodItemList;
	}

	@Override
	public String toString() {
		return "Animal [animal_id=" + animal_id + ", type=" + type + ", total_no=" + total_no + "]";
	}

}
