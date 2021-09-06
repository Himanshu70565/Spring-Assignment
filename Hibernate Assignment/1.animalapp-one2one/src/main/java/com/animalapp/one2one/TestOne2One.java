package com.animalapp.one2one;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.animalapp.factory.HibernateSessionFactory;

public class TestOne2One {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Animal animal1=new Animal("Carnivores",25);
		Animal animal2=new Animal("Herbivores",35);
		Animal animal3=new Animal("Ominivores",45);
		
		
		Cage cage1=new Cage(1, "location1");
		Cage cage2=new Cage(2, "location2");
		Cage cage3=new Cage(3, "location3");
		
		cage1.setAnimal(animal1);
		cage2.setAnimal(animal2);
		cage3.setAnimal(animal3);
		
		animal1.setCage(cage1);
		animal2.setCage(cage2);
		animal3.setCage(cage3);
		
		
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			
			session.persist(cage1);
			session.persist(cage2);
			session.persist(cage3);
			
			
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		}
		
		session.close();
		sessionFactory.close();
		
	}
}
