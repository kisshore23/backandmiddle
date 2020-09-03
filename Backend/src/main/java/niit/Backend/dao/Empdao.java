package niit.Backend.dao;

import java.util.List;

import niit.Backend.model.Empdetails;

public interface Empdao {
	

	public List<Empdetails> getemplist(); 
	public Empdetails getemp(int empid); 
	public boolean addemp(Empdetails emp); 
	public boolean updateemp(Empdetails emp);
	 public boolean deleteemp(int empid); 
	public Empdetails findById(int empid);
	

}