package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.*;

public class UserDAO {
	private static UserDAO instance;
	protected Session session;
	
	public static UserDAO getInstance(){
		if (instance == null){
			instance = new UserDAO();
		}

		return instance;
	}

	private UserDAO() {
		session = getEntityManager();
	}

	private Session getEntityManager() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		return session;
	}
	
	public List<User> listUsers(){
		List<User> users = new ArrayList<>();				
		User user = (User) session.get(User.class, 1);		
		users.add(user);
		
		session.close();
		
		return users;
	} 
}
