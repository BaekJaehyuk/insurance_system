package src.system.counseling;


import java.util.List;

public interface CounselingList {
    void add(Counseling counseling);
    void delete(Counseling counseling);
    Counseling get(int customerID);
    void update(Counseling counseling);
    List<Counseling> getAllCounseling();
}
