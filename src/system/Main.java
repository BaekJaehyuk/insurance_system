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

public class Main {

    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    // 보험 가입 JOIN
    // 상품 설계
    // 보상 Compensation
    // 보험료 납부
    // 사고 접수 AccidentFactory
    // 대출 Loan
    public static void main(String[] args) {

         try {
                while (true) {
                    printMenu();
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
}

