package src.system;


import src.system.accident.Accident;
import src.system.accident.AccidentListImpl;
import src.system.compensation.Compensation;
import src.system.compensation.CompensationListImpl;
import src.system.user.Customer;
import src.system.user.CustomerListImpl;

import java.rmi.RemoteException;
import java.io.*;
import java.util.*;

public class OSMain {
    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    private static CustomerListImpl customerList;
    private static CustomerListImpl c_customerList; // 보상받을 고객 리스트
    private  static AccidentListImpl accidentList;

    private  static CompensationListImpl compensationList;


    private static void setData() {
        customerList = new CustomerListImpl();
        c_customerList = new CustomerListImpl();
        accidentList = new AccidentListImpl();
        compensationList = new CompensationListImpl();
    }


    public static void main(String[] args) {
        setData();
        customerList.add(new Customer("kim", "F", "010", "11111")); // test data
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
                    case "3":
                        toAssessDamages();
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
        System.out.println("3. 손해사정");
        System.out.println("x. Exit");
    }


    /**
     * 보험금을 산정하다
     */
    private static void toAssessDamages() {
        accidentList.add(new Accident(1, "교통사고", "2024-06-04", "명지대", 1, "Pending") {
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
                        c_customerList.add(customerList.get(accidentList.get(accidentId).getCustomerId()));
                        compensationList.add(new Compensation(money, accidentList.get(accidentId).getCustomerId(), c_customerList));
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


    /**
     * 보상금을 지급하다.
     */
    private static void conpansate() {
        try {
            System.out.println("********************** MENU ***********************");
            showList(compensationList.get());

            System.out.println("보상 확정 리스트에서 보상금을 지급할 compensationId를 입력해주세요");
            String sCompensationChoice = objReader.readLine().trim();
            long compensationId = Long.parseLong(sCompensationChoice);
            if (compensationList.get(compensationId) != null) {
                long customerId = compensationList.get(compensationId).getCustomerId();
                if (compensationList.get(compensationId).pay()) {
                    System.out.println(c_customerList.get(customerId).getName() + "고객님에게 " + compensationList.get(compensationId).getMoney() + "원이 지급되었습니디.");
                    customerList.delete(customerId);
                } else {
                    System.out.println(c_customerList.get(customerId).getName() + "고객님의 계좌 정보가 없습니다.");
                }

            } else {
                System.out.println("유효한 compensationId를 입력해주세요");
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void payInsuranceFee() {
        System.out.println("********************** MENU ***********************");
        // 사용자를 만들어 그리고 사용자는 가입한 보험 정보를 가지고 있어 그러면 그 보험정보에는 보험료가 나와있어 그럼 그거 납부해
        // 여기서 사용자 생성
        // 여기서 가입 보험 정보 사용자에게 임의로 지정
        // 보험료 있는 정보들 가져와서 여기서 출력해줌
        // 보험료 납부할 보험 id 입력
        // customer Class의 pay(productId) 메서드 호출
        // // 납부완료 메시지 출력
    }


    private static void showList(ArrayList<?> dataList) {
        String list = "";
        for (int i = 0; i < dataList.size(); i++) {
            list += dataList.get(i) + "\n";
        }
        System.out.println(list);
    }
}

