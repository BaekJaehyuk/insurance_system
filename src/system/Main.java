package src.system;



import static src.system.utils.MESSAGE.MENU_ACCIDENT;
import static src.system.utils.MESSAGE.MENU_DESIGN;
import static src.system.utils.MESSAGE.MENU_EXIT;
import static src.system.utils.MESSAGE.MENU_INFO;
import static src.system.utils.MESSAGE.MENU_JOIN;
import static src.system.utils.MESSAGE.MENU_LOAN;
import static src.system.utils.MESSAGE.MENU_PAY;
import static src.system.utils.MESSAGE.WELCOME_MESSAGE;
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

  // 보험 가입  JOIN
  // 상품  설계
  // 보상  Compensation
  // 보험료  납부
  // 사고 접수  AccidentFactory
  // 대출  Loan
  public static void main(String[] args) {
    setData();
    try {
      while (true) {
        printMenu();
        String sChoice = input();
        switch (sChoice) {
          case "1": // 보험 가입
            registerInsurance();
            break;
          case "2": // 상품 설계

          case "3": // 보험료 납부
            payInsuranceFee();
            break;
          case "4": // 손해사정
            toAssessDamages();
          case "5": // 사고 접수
            accidentReport();
            break;
          case "6": // 대출
          case "7": // 상담
            counselling();
            System.out.println("2");
          case "x":
            return;

          default:
            System.out.println("Invalid Choice !!!");
        }
      }
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void toAssessDamages() {
    accidentList.add(new Accident(1, "교통사고", "2024-06-04", "명지대", 1) {
      @Override
      public void receiveAccident() {

      }
    }); // test data

    try {
      System.out.println("********************** MENU ***********************");
      showList(accidentList.get());

      System.out.println("위 사고 접수 리스트에서 손해사정을 진행할 사고의 accidentId를 입력해주세요");
      String sAcidentChoice = objReader.readLine().trim();
      long accidentId = Long.parseLong(sAcidentChoice);
      if (accidentList.get(accidentId) != null) {
        System.out.println("해당 고객에게 보상을 진행하겠습니까?");
        System.out.println("(1) 예    (2) 아니오");

        String sChoice = objReader.readLine().trim();
        switch (sChoice) {
          case "1":
            System.out.println("고객에게 지급할 보험금을 산정해주세요.");
            String iMoney  = objReader.readLine().trim();
            long money = Long.parseLong(iMoney);
            customerList.add(customerList.get(accidentList.get(accidentId).getCustomerId()));
            compensationList.add(new Compensation(money, accidentList.get(accidentId).getCustomerId(), customerList));
            break;
          case "2":
            accidentList.delete(accidentId);
            break;
          case "x":
            return;
          default:
            System.out.println("Invalid Choice !!!");
        }
      } else {
        System.out.println("유효한 accidentId를 입력해주세요");
      }

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void counselling() {
    System.out.println("상담 요청 중입니다.");
    Counseling counseling = new Counseling(1, 101, "Test Counseling", "This is a test counseling.");
    counselingList.add(counseling);

    System.out.println("상담이 확인되었습니다.");
    counseling.confirm();
    counselingList.update(counseling);

    System.out.println(" 6월 5일 18시에 상담이 확정되었습니다.");
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

  }


  private static void payInsuranceFee() {

    try {
      System.out.println("********************** MENU ***********************");

      System.out.println("보험료를 지불할 고객의 customerId를 입력해주세요");
      String sCustomerChoice = input();
      long customerId = Long.parseLong(sCustomerChoice);
      makeInsurance(sCustomerChoice); // 여기서 가입 보험 정보 사용자에게 임의로 지정하고 보험 정보 출력

      System.out.println("지불할 InsuranceId를 입력해주세요");
      String sInsuranceChoice = input(); // 보험료 납부할 보험 id 입력

      long insuranceId = Long.parseLong(sInsuranceChoice);

      if (customerList.get(customerId) != null) {
        if (insuranceList.get(insuranceId) != null) {
          Customer customer = customerList.get(customerId);
          Insurance insurance = insuranceList.get(insuranceId);
          customer.pay(insurance);
          System.out.println(
              "보험료가 납부되었습니다. 납부일자 : " + insurance.getInsuranceFee().getDateOfPayment());
        } else {
          System.out.println("유효한 insuranceId를 입력해주세요");
        }
      } else {
        System.out.println("유효한 customerId를 입력해주세요");
      }
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void makeInsurance(String sCustomerChoice) {
    int customerId = Integer.parseInt(sCustomerChoice);
    insuranceList.add(
        new OwnCar(customerId, new InsuranceFee(10000), 100, new Policy(), 100, 1, 1, 1));
    insuranceList.add(
        new Driver(customerId, new InsuranceFee(20000), 100, new Policy(), 100, 1, new Date()));
    showList(insuranceList.get());
  }

  private static void showList(ArrayList<?> dataList) {
    String list = "";
    for (Object o : dataList) {
      list += o + "\n";
    }
    System.out.println(list);
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

