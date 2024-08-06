//package JFSDS25.JFSDS25_HQL;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//
//public class HQLInsert {
//
//	public static void main(String[] args) {
//		Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//
//        SessionFactory sf = cfg.buildSessionFactory();
//        Session s = sf.openSession();
//
//        Transaction t = s.beginTransaction();
//        Query q = s.createSQLQuery("insert into Employee(eid,ename,esal) values (111,'querty',85254)");
//       
//        q.executeUpdate();
//        
//        t.commit();
//        s.close();
//        sf.close();
//		// TODO Auto-generated method stub
//
//	}
//
//}

package JFSDS25.JFSDS25_HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLInsert {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        Query q = s.createSQLQuery("insert into Employee(eid,ename,esal) values (111,'querty',85254)");
       
        q.executeUpdate();
        
        t.commit();
        s.close();
        sf.close();
		// TODO Auto-generated method stub

	}

}



