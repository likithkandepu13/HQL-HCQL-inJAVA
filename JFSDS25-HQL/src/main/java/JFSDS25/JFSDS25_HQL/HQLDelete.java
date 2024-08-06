package JFSDS25.JFSDS25_HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Employee where eid =30837");
        
        q.executeUpdate();
        
        t.commit();
        s.close();
        sf.close();
        

	}

}
