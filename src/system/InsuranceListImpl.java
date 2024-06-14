package src.system;

import src.system.user.Customer;

import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

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
        // 삭제 로직 추가 필요
    }

    @Override
    public ArrayList<Insurance> get() {
        return insuranceList;
    }

    @Override
    public Insurance get(long customerID) {
        for (Insurance insurance : this.insuranceList) {
            if (insurance.getCustomerID() == customerID) // customerID로 검색
                return insurance;
        }
        return null;
    }

    @Override
    public void update() {
        // 업데이트 로직 추가 필요
    }
}
