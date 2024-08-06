package JFSDS25.JFSDS25_HQL;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HQLsplRet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Configuration cfg  = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				
				SessionFactory sf= cfg.buildSessionFactory();
				Session s=sf.openSession();
				
				Transaction t= s.beginTransaction();
				
				Query<Object[]> q = s.createQuery("select eid,ename from Employee");
				
				List<Object[]>l=q.list();
				Iterator<Object[]> i= l.iterator();
				while(i.hasNext()) {
					Object ob[]=i.next();
					System.out.println(ob[0]+" "+ob[1]);
				}

		// TODO Auto-generated method stub

	}

}
