package view;

import java.util.List;
import java.util.Set;






import model.College;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static final SessionFactory concreteSessionFactory;
	//private static String SQL_READ_STOCKLEVEL="FROM College";
	 static {
	        try {
	        	
	            concreteSessionFactory = new AnnotationConfiguration()
	                    .configure().buildSessionFactory();
	                    /*Configuration config= new Configuration().configure().addAnnotatedClass(Student.class);
	        	StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties())
					.build();
	        	concreteSessionFactory= config.buildSessionFactory(registry); */
	        
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	public static void main(String args[]){
		Session session=getSession();
    	session.beginTransaction();
    	/*
    	College c=new College(1,"S.S.P.C");
    	session.persist(c);
        Student s1=new Student(1,"Atul",1);
        session.persist(s1);
        Student s2=new Student(2,"Saurabh",1);
        session.persist(s2);
    		    	
       	session.getTransaction().commit();
       	session.refresh(c);*/
       	College ob=(College)session.get(College.class, new Integer(1));
       	Set<String> names=ob.getStudents();
       	for(String s:names){
       		System.out.println(s);	
       	}
        System.out.println("Git is cool");
	}

	private static Session getSession()throws HibernateException {
        return concreteSessionFactory.openSession();
	}
}
