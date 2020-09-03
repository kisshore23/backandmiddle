package niit.Middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import niit.Backend.model.Empdetails;
import niit.Backend.service.Empservice;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/emp")


public class EmpController 
{
	@Autowired
	private Empservice EmployeeService;

	@GetMapping
	public List<Empdetails> listALLEmployeeDetails()
	{
		List<Empdetails> emp = EmployeeService.getemplist();
		return emp;
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployeeDetails(@RequestBody Empdetails emp)
	{

		if(EmployeeService.getemp(emp.getEmpid())==null)
		{
			EmployeeService.addemp(emp);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}

@PutMapping

public ResponseEntity<Void> updateEmployeeDetails(@RequestBody Empdetails emp)
{
	if(EmployeeService.getemp(emp.getEmpid())!=null)
	{
		EmployeeService. updateemp(emp);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
@DeleteMapping
public ResponseEntity<Void> deleteEmployeeDetails(@RequestBody Empdetails emp)
{
	if(EmployeeService.getemp(emp.getEmpid())!=null)
	{
		EmployeeService.deleteemp(0);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}

@GetMapping("/{EmpId}")
public ResponseEntity<Empdetails> getById(@PathVariable("EmpId") int EmpId)
{
	Empdetails emp = null;
	return new ResponseEntity<Empdetails>(EmployeeService.getemp(EmpId),HttpStatus.OK);
}

}
