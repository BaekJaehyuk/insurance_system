package src.system.user;


public class Join {

	private static final CustomerListImpl customerList = new CustomerListImpl();
	private int customerID;
	private int insuranceID;

	public Join(){

	}

	/**
	 * @return
	 */
	public Customer register(String name, String sex, String phoneNumber, String birthDay, int drivingExperience) {
//		Insurance insurance = new Insurance();
//		long productId = insurance.makeContract();

		if (customerList.isExistedMember(name)) {
			Customer existingCustomer = customerList.findMemberByName(name);
			//existingCustomer.addProduct(productId);
			customerList.update(existingCustomer.getCustomerID(), existingCustomer);
			return existingCustomer;
		}

		Customer customer = new Customer(name, sex, phoneNumber, birthDay, drivingExperience);
		//customer.addProduct(productId);
		customerList.add(customer);
		return customer;

		}


	public void finalize() throws Throwable {

	}

	public void examine(){

	}

}
