package src.system;

import java.util.ArrayList;

public interface InsuranceList {

    public void delete();

    public ArrayList<?> get();

    public void update();

    void add(Insurance insurance);
}
