package src.system.employee;

import java.util.*;

public class EmployeeListImpl implements EmployeeList {

	private ArrayList<Employee> employeeList;

	public EmployeeListImpl() {
		this.employeeList = new ArrayList<Employee>();
	}

	public long lastOfIndex() {
		if (employeeList.size() > 0) {
			return employeeList.get(employeeList.size() - 1).getEmployeeID();
		}
		return -1;
	}

	@Override
	public boolean add(Employee employee) {
		return this.employeeList.add(employee);
	}

	@Override
	public boolean delete(long employeeID) {
		for (Employee employee : this.employeeList) {
			if (employee.getEmployeeID() == employeeID) {
				this.employeeList.remove(employee);
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee get(long employeeID) {
		for (Employee employee : this.employeeList) {
			if (employee.getEmployeeID() == employeeID)
				return employee;
		}
		return null;
	}

	@Override
	public Employee get(String id, String password) {
		for (Employee employee : this.employeeList) {
			if (employee.getID().equals(id) && employee.getPassword().equals(password))
				return employee;
		}
		return null;
	}

	@Override
	public boolean update(long employeeID, Employee employee) {
		for (Employee prevEmployee : this.employeeList) {
			if (prevEmployee.getEmployeeID() == employeeID) {
				prevEmployee.setDepartment(employee.getDepartment());
				prevEmployee.setName(employee.getName());
				prevEmployee.setPhoneNumber(employee.getPhoneNumber());
				return true;
			}
		}
		return false;
	}

}
