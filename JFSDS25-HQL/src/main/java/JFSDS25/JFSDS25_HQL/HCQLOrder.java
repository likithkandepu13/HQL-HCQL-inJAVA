package JFSDS25.JFSDS25_HQL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class HCQLOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        
        Transaction t = s.beginTransaction();
        
        Criteria cr = s.createCriteria(Employee.class);
       cr.add((Restrictions.gt("esal", 100.0)));
       cr.addOrder(Order.asc("esal"));
       List<Employee> l = cr.list();
       
       for (Employee x : l) {
           System.out.println(x.getEsal());
       }
       
       t.commit();
       s.close();
       sf.close();


	}

}
