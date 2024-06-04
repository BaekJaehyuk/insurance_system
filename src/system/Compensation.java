package src.system;

import src.system.user.Customer;
import src.system.user.CustomerListImpl;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:50
 */
public class Compensation {

    private long insuranceId;
    private long customerId;
    private Customer customer;

    public Compensation(long insuranceId, long customerId, CustomerListImpl customerList) {
        this.customerId = customerId;
        this.insuranceId = insuranceId;
        this.customer = customerList.get(customerId);
    }

    public void finalize() throws Throwable {

    }


    public boolean pay(int money) {
        if(customer == null){
            return false;
        }
        return true;
    }

}