package src.system;


import src.system.user.Customer;
import src.system.user.CustomerList;
import src.system.user.CustomerListImpl;

import java.rmi.RemoteException;
import java.io.*;
import java.util.*;

public class ISMain {
    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    private static CustomerListImpl customerList;
    private static InsuranceListImpl insuranceList;

    private static void setData() {
        customerList = new CustomerListImpl();
        insuranceList = new InsuranceListImpl();
    }

    public static void main(String[] args) {
        setData();
        try {
            while (true) {
                printMenu();
                String sChoice = objReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        conpansate();
                        break;
                    case "2":
                        payInsuranceFee();
                        break;
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

    private static void printMenu() {
        System.out.println("********************** MENU ***********************");
        System.out.println("1. 보상하기");
        System.out.println("2. 보험료 납부");
        System.out.println("x. Exit");
    }


    /**
     * 사고 접수 내역 -> 손해사정 -> 보상금 지급 고객 리스트 -> 보상지급
     *
     */
    private static void conpansate() {

        customerList.add(new Customer("hello1", "F", "phone number", "abc"));
        customerList.add(new Customer("hello2", "F", "phone number", "abc"));
        customerList.add(new Customer("hello3", "F", "phone number", "abc"));

        try {
            System.out.println("********************** MENU ***********************");
            showList(customerList.get());

            System.out.println("위 리스트에서 보상을 지급할 고객의 customerId를 입력해주세요");
            String sCustomerChoice = objReader.readLine().trim();

            makeInsurance(sCustomerChoice);
            long customerId = Long.parseLong(sCustomerChoice);

            if (customerList.get(customerId) != null) {
                Compensation compensation = new Compensation(1, customerId, customerList);
                int money = 2000;
                if (compensation.pay(money)) {
                    System.out.println(customerList.get(customerId).getName() + "고객님에게 " + money + "원이 지급되었습니디.");
                    customerList.delete(customerId);
                } else {
                    System.out.println(customerList.get(customerId).getName() + "고객님의 계좌 정보가 없습니다.");

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

        // 사용자를 만들어 그리고 사용자는 가입한 보험 정보를 가지고 있어 그러면 그 보험정보에는 보험료가 나와있어 그럼 그거 납부해



        // 보험료 납부할 보험 id 입력
        // customer Class의 pay(productId) 메서드 호출
        // 납부완료 메시지 출력
    private static void payInsuranceFee() {

        customerList.add(new Customer("hello1", "M", "phone number", "abc")); // 여기서 사용자 생성
        customerList.add(new Customer("hello2", "M", "phone number", "abc"));
        customerList.add(new Customer("hello3", "M", "phone number", "abc"));

        try {
            System.out.println("********************** MENU ***********************");
            showList(customerList.get());

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
        for (int i = 0; i < dataList.size(); i++) {
            list += dataList.get(i) + "\n";
        }
        System.out.println(list);
    }
}

