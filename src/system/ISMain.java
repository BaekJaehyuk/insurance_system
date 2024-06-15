package src.system;


import src.system.compensation.Compensation;
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
        System.out.println("1. 보험료 납부");
        System.out.println("x. Exit");
    }




        // 사용자를 만들어 그리고 사용자는 가입한 보험 정보를 가지고 있어 그러면 그 보험정보에는 보험료가 나와있어 그럼 그거 납부해



        // 보험료 납부할 보험 id 입력
        // customer Class의 pay(productId) 메서드 호출
        // 납부완료 메시지 출력
    private static void payInsuranceFee() {

        try {
            System.out.println("********************** MENU ***********************");
            showList(customerList.get());

            System.out.println("보험료를 지불할 고객의 customerId를 입력해주세요");
            String sCustomerChoice = objReader.readLine().trim();
            long customerId = Long.parseLong(sCustomerChoice);

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

    private static void showList(ArrayList<?> dataList) {
        String list = "";
        for (int i = 0; i < dataList.size(); i++) {
            list += dataList.get(i) + "\n";
        }
        System.out.println(list);
    }
}

