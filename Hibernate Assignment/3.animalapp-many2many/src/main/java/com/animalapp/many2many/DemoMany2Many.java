package com.animalapp.many2many;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.animalapp.factory.HibernateSessionFactory;

public class DemoMany2Many {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();

		Animal lions = new Animal("lions", 25);
		Animal tigers = new Animal("tigers", 35);
		Animal sparrows = new Animal("sparrows", 45);
	
		FoodItem carrots=new FoodItem("carrots", 50);
		FoodItem potatoes=new FoodItem("potatoes", 40);
		FoodItem meat=new FoodItem("meat", 30);
		FoodItem beaf=new FoodItem("beaf", 20);
		
		lions.getFoodItemList().add(meat);
		lions.getFoodItemList().add(beaf);
		tigers.getFoodItemList().add(meat);
		tigers.getFoodItemList().add(beaf);
		
		sparrows.getFoodItemList().add(carrots);
		sparrows.getFoodItemList().add(potatoes);
		
		carrots.getAnimalList().add(sparrows);
		potatoes.getAnimalList().add(sparrows);
		
		meat.getAnimalList().add(lions);
		meat.getAnimalList().add(tigers);

		beaf.getAnimalList().add(lions);
		beaf.getAnimalList().add(tigers);
		
		
		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();

			session.persist(potatoes);
			session.persist(carrots);
			session.persist(meat);
			session.persist(beaf);
			
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		}
		session.close();
		sessionFactory.close();
	}
}
