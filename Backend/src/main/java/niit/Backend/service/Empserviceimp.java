package niit.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import niit.Backend.dao.Empdao;
import niit.Backend.model.Empdetails;

@Service
@Repository("empService")
@Transactional


public class Empserviceimp implements Empservice
{
  
	@Autowired
	private Empdao empDAO;
	
    @Override
	public List<Empdetails> getemplist() {
		// TODO Auto-generated method stub
		return empDAO.getemplist();
	}
     
    @Override
	public Empdetails getemp(int empid) {
		// TODO Auto-generated method stub
		return empDAO.getemp(empid);
	}

    @Override
	public boolean addemp(Empdetails emp) {
		// TODO Auto-generated method stub
		
	   return empDAO.addemp(emp);
	}
    
    @Override
	public boolean updateemp(Empdetails emp) {
		
		return empDAO.updateemp(emp);
	}
	
    @Override
	public boolean deleteemp(int empid) {
		
		return 	empDAO.deleteemp(empid);
		}

    @Override
	public Empdetails findById(int empid) {
		// TODO Auto-generated method stub
				return empDAO.findById(empid);
	}
}
