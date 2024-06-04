package src.system;

import src.system.user.Customer;

import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList{

    private final ArrayList<Insurance> insuranceList;

    public InsuranceListImpl() {
        this.insuranceList = new ArrayList<>();
    }

    @Override
    public void add(Insurance insurance) {
        insuranceList.add(insurance);
    }

    @Override
    public void delete() {

    }

    @Override
    public ArrayList<Insurance> get() {
        return insuranceList;
    }
    @Override
    public Insurance get(long customerID) {
        for (Insurance insurance : this.insuranceList) {
            if (insurance.getInsuranceID() == customerID)
                return insurance;
        }
        return null;
    }

    @Override
    public void update() {

    }
}
