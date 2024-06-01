package src.system.user;
import java.util.*;

public interface CustomerList {

	public boolean add(Customer customer);

	public boolean delete(long customerID);

	public Customer get(long customerID);

	public ArrayList<Customer> get();

	public boolean update(long customerID, Customer customer);

}
