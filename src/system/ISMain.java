package src.system;


import src.system.user.Customer;
import src.system.user.CustomerListImpl;

import java.rmi.RemoteException;
import java.io.*;
import java.util.*;

public class ISMain {
    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    private static CustomerListImpl customerList;



    private static void setData() {
        customerList = new CustomerListImpl();
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


    private static void showList(ArrayList<?> dataList) {
        String list = "";
        for (int i = 0; i < dataList.size(); i++) {
            list += dataList.get(i) + "\n";
        }
        System.out.println(list);
    }
}

