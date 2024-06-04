package src.test.counseling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.system.counseling.Counseling;
import src.system.counseling.CounsellingListImpl;
import src.system.counseling.CounsellingStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounsellingListImplTest {
    private CounsellingListImpl counselingList;

    @BeforeEach
    void setUp() {
        counselingList = new CounsellingListImpl();
    }

    @Test
    //새로운 상담을 추가하고, 상담 목록의 크기와 상담 상태가 올바른지 확인
    void testAddCounseling() {
        Counseling counseling = new Counseling(1, 101, "Test Counseling", "This is a test counseling.");
        counselingList.add(counseling);

        assertEquals(1, counselingList.getAllCounseling().size());
        Assertions.assertEquals(CounsellingStatus.REQUESTED, counseling.getStatus());
    }

    @Test
    //상담을 추가하고, 상담 상태를 CONFIRMED로 변경한 후 상태가 올바른지 확인
    void testConfirmCounseling() {
        Counseling counseling = new Counseling(1, 101, "Test Counseling", "This is a test counseling.");
        counselingList.add(counseling);
        counseling.confirm();
        counselingList.update(counseling);

        assertEquals(CounsellingStatus.CONFIRMED, counseling.getStatus());
    }

    @Test
//상담을 추가하고, 상담 상태를 COMPLETED로 변경한 후 상태가 올바른지 확인
    void testCompleteCounseling() {
        Counseling counseling = new Counseling(1, 101, "Test Counseling", "This is a test counseling.");
        counselingList.add(counseling);
        counseling.complete();
        counselingList.update(counseling);

        assertEquals(CounsellingStatus.COMPLETED, counseling.getStatus());
    }

    @Test
        //상담을 추가하고, 상담 상태를 CANCELLED로 변경한 후 상태가 올바른지 확인
    void testCancelCounseling() {
        Counseling counseling = new Counseling(1, 101, "Test Counseling", "This is a test counseling.");
        counselingList.add(counseling);
        counseling.cancel();
        counselingList.update(counseling);

        assertEquals(CounsellingStatus.CANCELLED, counseling.getStatus());
    }
}