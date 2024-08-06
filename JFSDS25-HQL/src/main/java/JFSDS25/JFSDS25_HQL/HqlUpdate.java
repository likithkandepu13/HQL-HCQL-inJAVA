package JFSDS25.JFSDS25_HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HqlUpdate {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        Query q = s.createQuery("update Employee set ename=:n where eid=:i");
        q.setParameter("n", "saibaba");
        q.setParameter("i", 30837);
        q.executeUpdate();
        
        t.commit();
        s.close();
        sf.close();
    }
}
