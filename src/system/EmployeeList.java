package src.system;

/**
 * @author tiemo
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:53
 */
public interface EmployeeList {


	public boolean add(Employee employee);

	public boolean delete(long employeeID);

	public Employee get(long employeeID);

	public Employee get(String id, String password);

	public boolean update(long employeeID, Employee employee);

}