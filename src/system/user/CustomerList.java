package src.system.user;
import java.util.*;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:51
 */
public interface CustomerList {

	/**
	 *
	 * @param customerID
	 */
	public boolean add(Customer customer);

	public boolean delete(long customerID);

	public Customer get(long customerID);

	public ArrayList<Customer> get();

	public boolean update(long customerID, Customer customer);

}