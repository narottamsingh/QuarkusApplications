package org.bce;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/employees")
public class EmployeeResource {

	private Set<Employee> employees = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

	@GET
	public Set<Employee> list() {
		return employees;
	}

	@POST
	public Set<Employee> add(Employee employee) {
		employees.add(employee);
		return employees;
	}

	@DELETE
	public Set<Employee> delete(Employee employee) {
		employees.removeIf(existingEmployee -> existingEmployee.name.contentEquals(employee.name));
		return employees;
	}
}