package src.system.employee;


public interface EmployeeList {


	public boolean add(Employee employee);

	public boolean delete(long employeeID);

	public Employee get(long employeeID);

	public Employee get(String id, String password);

	public boolean update(long employeeID, Employee employee);

}
