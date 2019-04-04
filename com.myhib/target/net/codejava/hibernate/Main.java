package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import net.codejava.hibernate.HibernateUtil;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessions = HibernateUtil.getSessionFactory();
		Session session = sessions.openSession(); // open a new Session
		//oupsi
		
	}
}
