package src.system.counseling;

import java.util.ArrayList;
import java.util.List;



public class CounsellingListImpl implements CounselingList {
    private List<Counseling> counselingList = new ArrayList<>();

    @Override
    public void add(Counseling counseling) {
        counselingList.add(counseling);
    }

    @Override
    public void delete(Counseling counseling) {
        counselingList.remove(counseling);
    }

    @Override
    public Counseling get(int customerID) {
        for (Counseling counseling : counselingList) {
            if (counseling.getCustomerID() == customerID) {
                return counseling;
            }
        }
        return null;
    }

    @Override
    public void update(Counseling counseling) {
        for (int i = 0; i < counselingList.size(); i++) {
            if (counselingList.get(i).getCustomerID() == counseling.getCustomerID()) {
                counselingList.set(i, counseling);
                break;
            }
        }
    }

    @Override
    public List<Counseling> getAllCounseling() {
        return new ArrayList<>(counselingList);
    }
}
