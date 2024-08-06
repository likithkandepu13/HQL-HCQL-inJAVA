package JFSDS25.JFSDS25_HQL;


import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLRetIter {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        
        Transaction t = s.beginTransaction();
        
        Query q = s.createQuery("from Employee");
        List<Employee> l = q.list();
        
        Iterator<Employee> i =l.iterator();
        
        while(i.hasNext()) {
        	Employee e=i.next();
        	System.out.println(e.getEsal());
        }
        
        t.commit();
        s.close();
        sf.close();
    }
}
