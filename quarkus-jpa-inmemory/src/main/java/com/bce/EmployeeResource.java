package com.bce;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.bce.model.Employee;
import com.bce.repository.EmployeeRepository;

@Path("/employees")
public class EmployeeResource {

	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GET
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@GET
	@Path("/findby/{name}")
	public Iterable<Employee> findByName(@PathParam String name) {
		return employeeRepository.findByName(name);
	}

	@POST
	@Path("/save")
	public Employee create(Employee e) {
		return employeeRepository.save(e);
	}

	@DELETE
	@Path("/{id}/delete")
	public void delete(@PathParam long id) {
		employeeRepository.deleteById(id);
	}

}
