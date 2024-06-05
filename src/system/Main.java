package src.system;

import static src.system.utils.MESSAGE.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import src.system.accident.Accident;
import src.system.accident.AccidentListImpl;
import src.system.compensation.Compensation;
import src.system.compensation.CompensationListImpl;
import src.system.counseling.Counseling;
import src.system.counseling.CounsellingListImpl;
import src.system.user.Customer;
import src.system.user.CustomerListImpl;

public class Main {

  static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

  private static CounsellingListImpl counselingList;
  private static CustomerListImpl customerList;
  private static InsuranceListImpl insuranceList;
  private static AccidentListImpl accidentList;
  private static CompensationListImpl compensationList;

  private static void setData() {
    customerList = new CustomerListImpl();
    insuranceList = new InsuranceListImpl();
    accidentList = new AccidentListImpl();
    counselingList = new CounsellingListImpl();
    compensationList = new CompensationListImpl();
  }

  public static void main(String[] args) {
    setData();
    try {
      while (true) {
        printMenu();
        String choice = input();
        handleUserChoice(choice);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private static void handleUserChoice(String choice) throws IOException, InterruptedException {
    switch (choice) {
      case "1":
        registerInsurance();
        break;
      case "2":
        // 상품 설계 로직 추가
        break;
      case "3":
        payInsuranceFee();
        break;
      case "4":
        toAssessDamages();
        break;
      case "5":
        accidentReport();
        break;
      case "6":
        // 대출 로직 추가
        break;
      case "7":
        counselling();
        break;
      case "x":
        System.exit(0);
        break;
      default:
        System.out.println("Invalid Choice !!!");
    }
  }

  private static void toAssessDamages() {
    accidentList.add(new Accident(1, "교통사고", "2024-06-04", "명지대", 1) {
      @Override
      public void receiveAccident() {
        // 사고 접수 로직
      }
    }); // test data

    try {
      System.out.println(MENU_INFO.getMsg());
      showList(accidentList.get());

      System.out.println(MSG_ASSESS_DAMAGE.getMsg());
      long accidentId = Long.parseLong(input());
      Accident accident = accidentList.get(accidentId);

      if (accident != null) {
        handleCompensation(accidentId);
      } else {
        System.out.println(MSG_VALIDATE_ID.getMsg());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void handleCompensation(long accidentId) throws IOException {
    System.out.println(MSG_COMPENSATION_ASK.getMsg());
    System.out.println(MSG_YES_OR_NO.getMsg());

    String choice = input();
    switch (choice) {
      case "1":
        System.out.println(MSG_CALCULATE_PAYOUT.getMsg());
        long money = Long.parseLong(input());
        Compensation compensation = new Compensation(money, accidentList.get(accidentId).getCustomerId(), customerList);
        compensationList.add(compensation);
        break;
      case "2":
        accidentList.delete(accidentId);
        break;
      case "x":
        return;
      default:
        System.out.println("Invalid Choice !!!");
    }
  }

  private static void counselling() throws InterruptedException {
    System.out.println(MSG_COUNSELLING_REQUESTED.getMsg());
    Counseling counseling = new Counseling(1, 101, "Test Counseling", "This is a test counseling.");
    counselingList.add(counseling);

    Thread.sleep(2000);

    System.out.println(MSG_COUNSELLING_CONFIRMED.getMsg());
    counseling.confirm();
    counselingList.update(counseling);

    Thread.sleep(2000);

    System.out.println(MSG_COUNSELLING_SCHEDULED.getMsg());
    counseling.complete();
    counselingList.update(counseling);
  }

  private static String input() throws IOException {
    return objReader.readLine().trim();
  }

  private static void registerInsurance() throws IOException {
    Join join = new Join();
    Customer registerCustomer = join.register(input(), input(), input(), input());
    System.out.println(registerCustomer.getName() + "님 보험가입이 완료되었습니다.");
  }

  private static void accidentReport() {
    // 사고 접수 로직 추가
  }

  private static void payInsuranceFee() {
    try {
      System.out.println("********************** MENU ***********************");
      System.out.println("보험료를 지불할 고객의 customerId를 입력해주세요");
      long customerId = Long.parseLong(input());
      makeInsurance(customerId);

      System.out.println("지불할 InsuranceId를 입력해주세요");
      long insuranceId = Long.parseLong(input());

      Customer customer = customerList.get(customerId);
      Insurance insurance = insuranceList.get(insuranceId);

      if (customer != null && insurance != null) {
        customer.pay(insurance);
        System.out.println("보험료가 납부되었습니다. 납부일자 : " + insurance.getInsuranceFee().getDateOfPayment());
      } else {
        System.out.println("유효한 customerId 또는 insuranceId를 입력해주세요");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void makeInsurance(long customerId) {
    insuranceList.add(new OwnCar((int) customerId, new InsuranceFee(10000), 100, new Policy(), 100, 1, 1, 1));
    insuranceList.add(new Driver((int) customerId, new InsuranceFee(20000), 100, new Policy(), 100, 1, new Date()));
    showList(insuranceList.get());
  }

  private static void showList(ArrayList<?> dataList) {
    for (Object o : dataList) {
      System.out.println(o);
    }
  }

  private static void printMenu() {
    System.out.println(WELCOME_MESSAGE.getMsg());
    System.out.println(MENU_INFO.getMsg());
    System.out.println(MENU_JOIN.getMsg());
    System.out.println(MENU_DESIGN.getMsg());
    System.out.println(MENU_PAY.getMsg());
    System.out.println(MENU_ACCIDENT.getMsg());
    System.out.println(MENU_LOAN.getMsg());
    System.out.println(MENU_EXIT.getMsg());
  }
}
