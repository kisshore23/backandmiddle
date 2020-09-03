package niit.Backend.Testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.Backend.model.Empdetails;
import niit.Backend.service.Empservice;

public class Etest {

	static Empservice empService;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("initialize");
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("niit.Backend");
	    context.refresh();
		System.out.println("Bean Initialization");
		empService = (Empservice) context.getBean("empService");
		System.out.println("Successfully bean initiated");
	}
	
	//@Ignore
	@Test
	public void addemptest() {
		Empdetails emp=new Empdetails();
		System.out.println("inside add");
		emp.setEmpid(1);
		emp.setName("Kisshore");
		emp.setEmail("kisshore1997@gmail.com");
		emp.setPhone("9710781249");
		emp.setCity("Chennai");
		System.out.println("before");
		empService.addemp(emp);
		System.out.println("Inside test");
	}
	
	//@Ignore
	@Test
	public void listEmployeeDetails() {
		List<Empdetails> listemp=empService.getemplist();
		assertNotNull("problem in listing faculty:",empService.getemplist());
		for(Empdetails emp:listemp)
		{
			System.out.println(emp.getEmpid()+"||"+emp.getName()+"||"+emp.getEmail()+"||"+emp.getPhone()+"||"+emp.getCity()+"||");
			
		}
	}
	
     //@Ignore
	@Test
	public void updateEmployeeDetails() {
		System.out.println("inside update method");
		Empdetails emp;
		emp=empService.getemp(167);
		emp.setName("Erohssik");
		System.out.println("after update method");
		assertTrue("problem in updating faculty:",empService.updateemp(emp));
		
	}
	
	//@Ignore
	@Test
	public void deleteemp() {
		//EmployeeDetails emp=empService.getEmployeeDetails(2);
		int empId=46;
		assertTrue("problem in deleting faculty:",empService.deleteemp(empId));
	}

}
