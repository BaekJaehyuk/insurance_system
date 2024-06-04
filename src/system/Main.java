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
import src.system.user.Customer;
import src.system.user.CustomerListImpl;

public class Main {

    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    private static CustomerListImpl customerList;
    private static InsuranceListImpl insuranceList;

    private static void setData() {
        customerList = new CustomerListImpl();
        insuranceList = new InsuranceListImpl();
    }
    // 보험 가입 JOIN
    // 상품 설계
    // 보상 Compensation
    // 보험료 납부
    // 사고 접수 AccidentFactory
    // 대출 Loan
    public static void main(String[] args) {
         setData();
         try {
                while (true) {
                    printMenu();
                    String sChoice = objReader.readLine().trim();
                    switch (sChoice) {
                        case "1": // 보험 가입

                            break;
                        case "2": // 상품 설계
                            System.out.println("1");
                            break;

                        case "3" : // 보험료 납부
                            payInsuranceFee();
                            System.out.println("2");
                        case "4" : // 사고 접수

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

    private static void printMenu() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(MENU_INFO);
        System.out.println(MENU_JOIN);
        System.out.println(MENU_DESIGN);
        System.out.println(MENU_PAY);
        System.out.println(MENU_ACCIDENT);
        System.out.println(MENU_LOAN);
        System.out.println(MENU_EXIT);
    }

    private static void payInsuranceFee() {

        try {
            System.out.println("********************** MENU ***********************");

            System.out.println("보험료를 지불할 고객의 customerId를 입력해주세요");
            String sCustomerChoice = objReader.readLine().trim();
            long customerId = Long.parseLong(sCustomerChoice);
            makeInsurance(sCustomerChoice); // 여기서 가입 보험 정보 사용자에게 임의로 지정하고 보험 정보 출력

            System.out.println("지불할 InsuranceId를 입력해주세요");
            String sInsuranceChoice = objReader.readLine().trim(); // 보험료 납부할 보험 id 입력

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

