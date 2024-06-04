package src.system.user;

import java.util.ArrayList;

public class CustomerListImpl implements CustomerList {
	private final ArrayList<Customer> customerList;

	public CustomerListImpl() {
		this.customerList = new ArrayList<Customer>();
	}

	public void finalize() throws Throwable {

	}

	public long lastOfIndex() {
		if (!customerList.isEmpty()) {
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

	public Customer findMemberByName(String name) {
		for (Customer customer : customerList) {
			if (customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public boolean isExistedMember(String name) {
		for (Customer customer : this.customerList) {
			if (customer.getName().equals(name))
				return true;
		}
		return false;
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
