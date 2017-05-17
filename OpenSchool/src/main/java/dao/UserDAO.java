package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.*;

public class UserDAO {
	private static UserDAO instance;
	private SessionFactory sessionFactory;
	
	public static UserDAO getInstance(){
		if (instance == null){
			instance = new UserDAO();
		}

		return instance;
	}

	private UserDAO() {
		sessionFactory = getEntityManager();
	}

	private SessionFactory getEntityManager() {
		return new Configuration().configure().buildSessionFactory();
	}
	
	public User getUser(final int id) {
		Session session = sessionFactory.openSession();;
		session.beginTransaction();	
		
		User user = (User) session.get(User.class, id);
		
		session.close();
		return user;
	}
	
	public void deleteUser(final int id) {
		User user = getUser(id);
		
		deleteUser(user);
	}
	
	public void deleteUser(final User user) {
		Session session = sessionFactory.openSession();;
		session.beginTransaction();	
		
		session.delete(user);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void addUser(final User user) {
		Session session = sessionFactory.openSession();;
		session.beginTransaction();	
		
		session.persist(user);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void updateUser(final User user) {
		Session session = sessionFactory.openSession();;
		session.beginTransaction();	
		
		session.merge(user);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public List<User> listUsers(){
		List<User> users = new ArrayList<>();		
		
		Session session = sessionFactory.openSession();;
		session.beginTransaction();		
		
		/*User user = (User) session.get(User.class, 1);*/
		users = session.createQuery("FROM " + User.class.getName()).list();
		
		session.close();
		
		return users;
	} 
	
	public User authenticateUser(String userName, String password){
		List<User> users = new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		
		/*User user = (User) session.get(User.class, 1);*/
		String hql = "FROM " + User.class.getName() + " as u WHERE u.userName = '"+userName+"' and u.password = '"+password+"'";
		users = session.createQuery(hql).list();
		
		session.close();
		
		return users.size() > 0 ? users.get(0) : null;
	} 
}
