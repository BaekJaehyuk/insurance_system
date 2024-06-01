package src.system.user;

import java.util.ArrayList;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:51
 */


public class CustomerListImpl implements CustomerList {
	private ArrayList<Customer> customerList;

	public CustomerListImpl() {
		this.customerList = new ArrayList<Customer>();
	}

	public void finalize() throws Throwable {

	}

	public long lastOfIndex() {
		if (customerList.size() > 0) {
			return customerList.get(customerList.size() - 1).getCustomerID();
		}
		return -1;
	}

	@Override
	public boolean add(Customer customer) {
		return this.customerList.add(customer);
	}

	@Override
	public boolean delete(long customerID) {
		for (Customer customer : this.customerList) {
			if (customer.getCustomerID() == customerID) {
				this.customerList.remove(customer);
				return true;
			}
		}
		return false;
	}

	@Override
	public Customer get(long customerID) {
		for (Customer customer : this.customerList) {
			if (customer.getCustomerID() == customerID)
				return customer;
		}
		return null;
	}



	@Override
	public ArrayList<Customer> get() {
		return customerList;
	}

	@Override
	public boolean update(long customerID, Customer customer) {
		for (Customer prevCustomer : this.customerList) {
			if (prevCustomer.getCustomerID() == customerID) {
				prevCustomer.setName(customer.getName());
				prevCustomer.setPhoneNumber(customer.getPhoneNumber());
				prevCustomer.setSex(customer.getSex());

				return true;
			}
		}
		return false;
	}
}