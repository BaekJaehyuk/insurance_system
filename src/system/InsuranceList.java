package src.system;

import src.system.user.Customer;

import java.util.ArrayList;

public interface InsuranceList {

    public void delete();

    public Insurance get(long insuranceId);

    public ArrayList<?> get();

    public void update();

    void add(Insurance insurance);
}
