package src.system;

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
    public void update() {

    }
}
