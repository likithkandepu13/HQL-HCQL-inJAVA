package JFSDS25.JFSDS25_HQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLRetAllclm {

	public static void main(String[] args) {
	Configuration cfg  = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	
	SessionFactory sf= cfg.buildSessionFactory();
	Session s=sf.openSession();
	
	Transaction t= s.beginTransaction();
	
	Query<Object[]> q = s.createQuery("select eid from Employee");
	
	List l=q.list();
	Iterator i= l.iterator();
	while(i.hasNext()) {
		Object ob=(Object)i.next();
		System.out.println(ob);
	}

		// TODO Auto-generated method stub

	}

}
