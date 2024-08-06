package JFSDS25.JFSDS25_HQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLRetSpec {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session s = sf.openSession();
	        
	        Transaction t = s.beginTransaction();
	        
	        Query<Employee> q = s.createQuery("from Employee", Employee.class);
	        q.setFirstResult(5);
	        q.setMaxResults(15);
	        
	        t.commit();
	        s.close();
	        sf.close();


	}

}
