package src.system;



import src.system.user.Customer;
import src.system.user.CustomerListImpl;

import java.rmi.RemoteException;
import java.io.*;
import java.util.*;

public class ISMain {
    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    private static CustomerListImpl customerList;
    private static EmployeeListImpl employeeList;
    private static ProductListImpl productList;


    private static void setData() {
        customerList = new CustomerListImpl();
        employeeList = new EmployeeListImpl();
        productList = new ProductListImpl();
    }


    public static void main(String[] args) {
        setData();
        try {
            while (true) {
                printMenu();
                String sChoice = objReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        printCustomerInitMenu();
                        break;
                    case "2":
                        printEmployeeInitMenu();
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
        System.out.println("1. customer");
        System.out.println("2. employee");
        System.out.println("x. Exit");
    }

    static boolean customerMenuFlag = true;

    private static void printCustomerInitMenu() {
        try {
            while (customerMenuFlag) {
                System.out.println("********************** Customer MENU ***********************");
                System.out.println("1. login");
                System.out.println("2. sign in");
                System.out.println("x. Exit");

                String sChoice = objReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        break;
                    case "2":
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





    private static void printCustomerMenu() {
        System.out.println("********************** Customer MENU ***********************");
        System.out.println("1. 상담 요청");
        System.out.println("2. 보험 가입");
        System.out.println("3. 가입삼사 확인");
        System.out.println("x. Exit");
    }

    private static void printMemberMenu() {
        System.out.println("********************** Member MENU ***********************");
        System.out.println("1. 사고 접수");
        System.out.println("2. 상담 요청");
        System.out.println("3. 내 보험 확인");
        System.out.println("4. 보험 가입");
        System.out.println("5. 가입심사 확인");
        System.out.println("6. 보험료 납부");
        System.out.println("7. 대출");
        System.out.println("x. Exit");
    }


    static boolean employeeMenuFlag = true;

    private static void printEmployeeInitMenu() {
        try {
            while (employeeMenuFlag) {
                System.out.println("********************** Employee MENU ***********************");
                System.out.println("1. 로그인");
                System.out.println("x. Exit");

                String sChoice = objReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        loginEmployee();
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

    /**
     * 직원 로그인
     */
    private static void loginEmployee() {
        try {
            System.out.println("ID를 입력해주세요");
            String id = objReader.readLine().trim();
            System.out.println("Password를 입력해주세요");
            String password = objReader.readLine().trim();

            if (employeeList.get(id, password) != null) {
                employeeMenuFlag = false;
                printEmployeeMenu();
            } else {
                System.out.println("로그인 실패");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void printEmployeeMenu() {
        System.out.println("********************** Employee MENU ***********************");
        System.out.println("1. 사고 접수 관리"); // > 사고접수 확인, 보험금 산정
        System.out.println("2. 보험 설계"); // > 보험 설계서, 설계서 조회
        System.out.println("3. 고객 서비스"); // > 보험가입신청 내역, 상담요청 내역
        System.out.println("x. Exit");
    }


    private static void showList(ArrayList<?> dataList) {
        String list = "";
        for (int i = 0; i < dataList.size(); i++) {
            list += dataList.get(i) + "\n";
        }
        System.out.println(list);
    }
}

