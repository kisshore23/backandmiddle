package niit.Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.Backend.model.Empdetails;

@Repository("empDAO")
@Transactional
public class Empdaoimp implements Empdao 
{
	
		@Autowired
		private SessionFactory sessionFactory;
        
		@Override
		public List<Empdetails> getemplist() {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().createQuery("from Empdetails").list();
		}
		@Override
		public Empdetails getemp(int empid) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query createQuery = currentSession.createQuery("from Empdetails where id="+empid);
			Object uniqueResult = createQuery.uniqueResult();
			return (Empdetails) uniqueResult;
		}
		@Override
		public boolean addemp(Empdetails emp) {
			try
		     {
		    	System.out.println("in Dao"); 
				sessionFactory.getCurrentSession().save(emp);
		    	 
		    	 return true;
      		}
		     catch(Exception e) {
		    	 return false;
		     }
		}
		@Override
		public boolean updateemp(Empdetails emp) {
			try
			{
				sessionFactory.getCurrentSession().update(emp);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		@Override
		public boolean deleteemp(int empid) {
			try
			{
				sessionFactory.getCurrentSession().delete(findById(empid));
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		@Override
		public Empdetails findById(int empid) {
			// TODO Auto-generated method stub
			 return(Empdetails)sessionFactory.getCurrentSession()
					.createQuery("from Empdetails where id="+empid).uniqueResult();
		}

}