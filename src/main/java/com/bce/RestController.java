package com.bce;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/api")
public class RestController {

	private Set<Employee> employees = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

	public RestController() {
		employees.add(new Employee("Ram", "10001"));
		employees.add(new Employee("Shyam", "10002"));
	}

	@GET
	public Set<Employee> list() {
		return employees;
	}

	@POST
	public Set<Employee> add(Employee Employee) {
		employees.add(Employee);
		return employees;
	}

	@DELETE
	public Set<Employee> delete(Employee Employee) {
		employees.removeIf(existingEmployee -> existingEmployee.name.contentEquals(Employee.name));
		return employees;
	}
}
