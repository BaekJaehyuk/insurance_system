package src.test.accident;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.system.*;
import src.system.accident.Accident;
import src.system.accident.AccidentFactory;
import src.system.user.Customer;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccidentFactoryTest {

    private Customer customer1;
    private Employee employee;

    @BeforeEach
    void setUp() {
        customer1 = new Customer("John Doe", "M", "010-1234-5678", "1980-01-01",5);
        customer1.addInsurance(new OwnCar((int) customer1.getCustomerID(), new InsuranceFee(10000), "X", new Policy(), 100, 1, 1, 1)); // 자차 보험 가입
        customer1.addInsurance(new Driver((int) customer1.getCustomerID(), new InsuranceFee(20000), "X", new Policy(), 100, 1, new Date(), 1)); // 운전자 보험 가입

        employee = new Employee(1, "alice123", "password123", "Alice", "F", "010-8765-4321", "Claims Department", "2020-01-01");
    }

    @Test
    //운전자 보험이 가입된 고객의 개인 상해 사고를 접수하고 심사하는 테스트입니다. 초기 상태는 Pending이며, 직원의 승인 후 Approved 상태
    void testPersonalInjuryAccidentWithDriverInsurance() {
        Accident accident = AccidentFactory.createAccident("PersonalInjury", 1, "Car accident", "2024-05-29", "Seoul", customer1, "carNumber", new String[]{"3", "2"});
        assertEquals("Pending", accident.getAssessmentStatus(), "Status should be Pending");

        employee.assessAccident(accident, "Y");
        assertEquals("Approved", accident.getAssessmentStatus(), "Status should be Approved");
    }

    @Test
    //자차 보험이 가입된 고객의 대인배상 사고를 접수하고 심사하는 테스트입니다. 초기 상태는 Pending이며, 직원의 거절 후 Rejected 상태
    void testLiabilityAccidentWithAutoInsurance() {
        Accident accident = AccidentFactory.createAccident("Liability", 2, "House fire", "2024-06-01", "Busan", customer1, "carNumber", new String[]{"record1", "4", "Jane Doe", "010-8765-4321"});
        assertEquals("Pending", accident.getAssessmentStatus(), "Status should be Pending");

        employee.assessAccident(accident, "N");
        assertEquals("Rejected", accident.getAssessmentStatus(), "Status should be Rejected");
    }

    @Test
    //자차 보험이 가입된 고객의 대물배상 사고를 접수하고 심사하는 테스트입니다. 초기 상태는 Pending이며, 직원의 승인 후 Approved 상태
    void testPropertyDamageAccidentWithAutoInsurance() {
        Accident accident = AccidentFactory.createAccident("PropertyDamage", 3, "Tree fall on car", "2024-06-15", "Incheon", customer1, "carNumber", new String[]{"Car"});
        assertEquals("Pending", accident.getAssessmentStatus(), "Status should be Pending");

        employee.assessAccident(accident, "Y");
        assertEquals("Approved", accident.getAssessmentStatus(), "Status should be Approved");
    }

    @Test
    //운전자 보험이 가입되지 않은 고객의 개인 상해 사고를 접수하는 테스트입니다. 조건을 만족하지 않으므로 초기 상태가 Rejected
    void testPersonalInjuryAccidentWithoutDriverInsurance() {
        Customer customerWithoutDriverInsurance = new Customer("Jane Doe", "F", "010-8765-4321", "1990-01-01",5);
        customerWithoutDriverInsurance.addInsurance(new OwnCar((int) customerWithoutDriverInsurance.getCustomerID(), new InsuranceFee(10000), "X", new Policy(), 100, 1, 1, 1)); // Only Auto insurance

        Accident accident = AccidentFactory.createAccident("PersonalInjury", 4, "Car accident", "2024-07-01", "Seoul", customerWithoutDriverInsurance, "carNumber", new String[]{"3", "2"});
        assertEquals("Rejected", accident.getAssessmentStatus(), "Status should be Rejected");
    }

    @Test
    //자차 보험이 가입되지 않은 고객의 대인배상 사고를 접수하는 테스트입니다. 조건을 만족하지 않으므로 초기 상태가 Rejected
    void testLiabilityAccidentWithoutAutoInsurance() {
        Customer customerWithoutAutoInsurance = new Customer("Jane Doe", "F", "010-8765-4321", "1990-01-01",7);
        customerWithoutAutoInsurance.addInsurance(new Driver((int) customerWithoutAutoInsurance.getCustomerID(), new InsuranceFee(20000), "X", new Policy(), 100, 1, new Date(), 1)); // Only Driver insurance

        Accident accident = AccidentFactory.createAccident("Liability", 5, "House fire", "2024-07-01", "Busan", customerWithoutAutoInsurance, "carNumber", new String[]{"record1", "4", "Jane Doe", "010-8765-4321"});
        assertEquals("Rejected", accident.getAssessmentStatus(), "Status should be Rejected");
    }
}
