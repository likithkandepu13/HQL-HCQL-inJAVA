package JFSDS25.JFSDS25_HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Insert {

		public static void main(String[] args) 
		{
			Configuration cfg= new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = sf.openSession();
			
			Transaction t= s.beginTransaction();
			
			Employee emp=new Employee();
			emp.setEid(398319);
			emp.setEname("abrgav");
			emp.setEsal(999998);;
			
			s.save(emp);
			t.commit();
			System.out.println("Inserted completed");
			s.close();
			sf.close();
		}

		// TODO Auto-generated method stub

	}


