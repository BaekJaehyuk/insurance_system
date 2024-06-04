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
import src.system.accident.AccidentFactory;
import src.system.accident.AccidentListImpl;
import src.system.user.Customer;
import src.system.user.CustomerListImpl;

public class Main {

    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    private static CustomerListImpl customerList;
    private static InsuranceListImpl insuranceList;
    private static AccidentListImpl accidentList;

    private static void setData() {
        customerList = new CustomerListImpl();
        insuranceList = new InsuranceListImpl();
        accidentList = new AccidentListImpl();

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
                            System.out.println("미구현");
                            break;

                        case "3" : // 보험료 납부
                            payInsuranceFee();
                            System.out.println("2");
                        case "4" : // 사고 접수
                            accidentReport();
                            System.out.println("2");
                        case "5" : // 대출

                            System.out.println("2");
                        case "6" : // 상담

                            System.out.println("2");
                        case "x" :
                            return;

                        default :
                            System.out.println("Invalid Choice !!!");
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    private static String input() throws IOException {
        return objReader.readLine().trim();
    }

    private static void registerInsurance() throws IOException {
        Join join = new Join();
        join.join(input(), input(), input(), input());
    }

    private static void accidentReport() {
        Accident personalInjuryAccident = AccidentFactory.createAccident("PersonalInjury", 1, "Car accident",
                                                                         "2024-05-29", "Seoul", 101, new String[]{"3", "2"});
        Accident liabilityAccident = AccidentFactory.createAccident("Liability", 2, "House fire", "2024-06-01",
                                                            "Busan", 102, new String[]{"record1", "4", "Jane Doe", "010-8765-4321"});
        Accident propertyDamageAccident = AccidentFactory.createAccident("PropertyDamage", 3, "Tree fall on car",
                                                               "2024-06-15", "Incheon", 103, new String[]{"Car"});

        accidentList.add(personalInjuryAccident);
        accidentList.add(liabilityAccident);
        accidentList.add(propertyDamageAccident);
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
                if(insuranceList.get(insuranceId) != null){
                    Customer customer = customerList.get(customerId);
                    Insurance insurance = insuranceList.get(insuranceId);
                    customer.pay(insurance);
                    System.out.println("보험료가 납부되었습니다. 납부일자 : "+ insurance.getInsuranceFee().getDateOfPayment());
                }else{
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

    private static void makeInsurance(String sCustomerChoice){
        int customerId = Integer.parseInt(sCustomerChoice);
        insuranceList.add(new OwnCar(customerId, new InsuranceFee(10000), 100, new Policy(), 100, 1, 1, 1));
        insuranceList.add(new Driver(customerId, new InsuranceFee(20000), 100, new Policy(), 100, 1, new Date()));
        showList(insuranceList.get());
    }

    private static void showList(ArrayList<?> dataList) {
        String list = "";
        for (Object o : dataList) {
            list += o + "\n";
        }
        System.out.println(list);
    }

}

