# HQL-HCQL-inJAVA
HCL and HCQL in JAVA Full Stack
							
							**HQL**		

	• HQL Stands for HIBERNATE QUERY LANGUAGE.
	• HQL is database independent query language 
	• HQL is same a SQL, only difference is that SQL depends on the table where as HQL depends on the POJO class.
	• To work with HQL, we need to use Query Interface 


Query Interface :

	• It is an object oriented representation of an Hibernate query 
	• The object of a query interface can be obtained by calling "createQuery"  method to a session object.
	• Query q = s.createQuery("HQL");
	• The methods of query interface are :
		○ executeUpdate()
		○ list()
		○ setFirstResult()
		○ setMaxResults()
		○ setParameter()

Example:
  HQL Example	
(to retrive all the records using ForEach)	package JFSDS25.JFSDS25_HQL;
	
	
	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.query.Query;
	
	public class HqlRet 
	{
	
	    public static void main(String[] args) {
	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session s = sf.openSession();
	        
	        Transaction t = s.beginTransaction();
	        
	        Query<Employee> q = s.createQuery("from Employee", Employee.class);
	        List<Employee> l = q.list();
	        
	        for (Employee x : l) {
	            System.out.println(x.getEname());
	        }
	        
	        t.commit();
	        s.close();
	        sf.close();
	    }
	}
		
		
		
Example 2:
HQL Example	
(To retrive using iterative method)	package JFSDS25.JFSDS25_HQL;
	
	
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
	        
	        Query<Employee> q = s.createQuery("from Employee", Employee.class);
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
	
Example - 3:
HQL Example	package JFSDS25.JFSDS25_HQL;
(to retrive specific range of records- pagination)	
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
	
	Note : Example-1 and wx-2 are to retrive all records from table 
		Ex-3 is to retrive from the specific range of records (Starting record to how many num of records)
		 
	
Example-4 :
To update the record: HQL	
Query-> update Employee set ename=:n where eid =I	package JFSDS25.JFSDS25_HQL;
        	
                q.setParameter(n,"XYZ")	import org.hibernate.Session;
                q.setParameter(I,111)	import org.hibernate.SessionFactory;
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
	


Example-5:
HQL Example (To delete a record)	
	package JFSDS25.JFSDS25_HQL;
Query--> delete from Employee where id="111"	
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

Example-6:
HQL Example to insert a record 	
	package JFSDS25.JFSDS25_HQL;
Query -> Insert into Employee(eid,ename,esal) values (111,"querty",85254);	
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
	
	
	        

Example - 7:
HQL example to retrive all records with partial number of columns	
	package JFSDS25.JFSDS25_HQL;
Eid,ename,esal ->Employee	import java.util.Iterator;
Eid,Ename - > HQL 	import java.util.List;
	
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

Example 8: 
(to retrive all in one column)	
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


HCQL:

	• Hibernate Criteria Query Language
	• Using HCQL, we can able to retrive records with all number of columns every time
	• To implement HCQL in hibernate application we need to use Criteria interface

	Criteria Interface:
		○ Criteria interface object can be obtained by calling createCriteria() method to a session object
		○ Criteria cr = s.createCriteria();
		○ Methods of criteria interface are:
			§ Add()
			§ addOrder()
			§ setFirstResults()
			§ setMaxResults()
			§ list()
		
	Restriction Class:
		○ In order to have restriction/condition/criteria on HQL query
		○ The Methods of restriction class are
			§ lt()
			§ le()
			§ gt()
			§ ge()
			§ eq()
			§ neq()
	Order class:
		○ Consists of many methods, in order to display or retrive the data from the database table. Either in ascending or descinding order.
		○ The methods are:
			§ asc()
			§ dsc()
	
	Example-1	
	HCQL EXAMPLE	package JFSDS25.JFSDS25_HQL;
	(to retrive records using foreach loop)	
		import java.util.List;
		
		import org.hibernate.Criteria;
		import org.hibernate.Session;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		
		public class HCQLRet {
		
		        public static void main(String[] args)
		        {
		                Configuration cfg = new Configuration();
		        cfg.configure("hibernate.cfg.xml");
		        
		        SessionFactory sf = cfg.buildSessionFactory();
		        Session s = sf.openSession();
		        
		        Transaction t = s.beginTransaction();
		        
		        Criteria cr= s.createCriteria(Employee.class);
		        
		        List<Employee> l = cr.list();
		        
		        for (Employee x : l) {
		            System.out.println(x.getEname());
		        }
		        
		        t.commit();
		        s.close();
		        sf.close();
		
		        }
		
		}
		
	
	Example - 2: Iterator	
		package JFSDS25.JFSDS25_HQL;
		
		import java.util.Iterator;
		import java.util.List;
		
		import org.hibernate.Criteria;
		import org.hibernate.Session;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.query.Query;
		
		public class HCQLRetItr {
		
			public static void main(String[] args) 
			{
				// TODO Auto-generated method stub
				 Configuration cfg = new Configuration();
			        cfg.configure("hibernate.cfg.xml");
			        
			        SessionFactory sf = cfg.buildSessionFactory();
			        Session s = sf.openSession();
			        
			        Transaction t = s.beginTransaction();
			        
			        Criteria cr = s.createCriteria(Employee.class);
			        List<Employee> l = cr.list();
			        
			        Iterator<Employee> i =l.iterator();
			        
			        while(i.hasNext()) {
			        	Employee e=i.next();
			        	System.out.println(e.getEname());
			        }
			        
			        t.commit();
			        s.close();
			        sf.close();
		
			}
		
		}
	
	Example-3 : 	
	Padination	package JFSDS25.JFSDS25_HQL;
		
		import java.util.List;
		
		import org.hibernate.Criteria;
		import org.hibernate.Session;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.query.Query;
		
		public class HCQLRetSpec {
		
			public static void main(String[] args)
			{
				 Configuration cfg = new Configuration();
			        cfg.configure("hibernate.cfg.xml");
			        
			        SessionFactory sf = cfg.buildSessionFactory();
			        Session s = sf.openSession();
			        
			        Transaction t = s.beginTransaction();
			        
			        Criteria cr = s.createCriteria(Employee.class);
			        cr.setFirstResult(5);
			        cr.setMaxResults(15);
			        List<Employee> l = cr.list();
			        
			        for (Employee x : l) {
			            System.out.println(x.getEname());
			        }
			        
			        t.commit();
			        s.close();
			        sf.close();
			        
			        t.commit();
			        s.close();
			        sf.close();
		
			}
		
		}
	
	Example-4	
		package JFSDS25.JFSDS25_HQL;
	Restriction class 	
		import java.util.List;
		
		import org.hibernate.Criteria;
		import org.hibernate.Session;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.criterion.Restrictions;
		
		public class HCQLRestriction {
		
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				Configuration cfg = new Configuration();
		        cfg.configure("hibernate.cfg.xml");
		        
		        SessionFactory sf = cfg.buildSessionFactory();
		        Session s = sf.openSession();
		        
		        Transaction t = s.beginTransaction();
		        
		        Criteria cr = s.createCriteria(Employee.class);
		       cr.add((Restrictions.gt("esal", 100.0)));
		       List<Employee> l = cr.list();
		       
		       for (Employee x : l) {
		           System.out.println(x.getEsal());
		       }
		       
		       t.commit();
		       s.close();
		       sf.close();
		
		
			}
		
		}
	
	Example-5:	
		package JFSDS25.JFSDS25_HQL;
	Order class	
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
	
![image](https://github.com/user-attachments/assets/f5260fb5-f5f1-4e69-8736-8b4fec809a26)
