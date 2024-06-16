package src.system;

import static src.system.utils.MESSAGE.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import src.system.accident.*;
import src.system.compensation.Compensation;
import src.system.compensation.CompensationListImpl;
import src.system.counseling.Counseling;
import src.system.counseling.CounsellingListImpl;
import src.system.loan.Loan;
import src.system.loan.LoanListImpl;
import src.system.user.Customer;
import src.system.user.CustomerListImpl;

public class Main {

    static BufferedReader objReader = new BufferedReader(new InputStreamReader(System.in));

    private static CounsellingListImpl counselingList;
    private static CustomerListImpl customerList;
    private static CustomerListImpl c_customerList;
    private static InsuranceListImpl insuranceList;
    private static AccidentListImpl accidentList;
    private static CompensationListImpl compensationList;
    private static LoanListImpl loanList;

    private static void setData() {
        customerList = new CustomerListImpl();
        c_customerList = new CustomerListImpl();
        insuranceList = new InsuranceListImpl();
        accidentList = new AccidentListImpl();
        counselingList = new CounsellingListImpl();
        compensationList = new CompensationListImpl();
        loanList = new LoanListImpl();
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
                loan();
                break;
            case "7":
                counselling();
                break;
            case "8":
                compensate();
                break;
            case "9":
                makeAccount();
                break;
            case "10":
                judgeLoan();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println(MENU_INVALID_CHOICE.getMsg());
        }
    }

    private static void toAssessDamages() {
        // accidentList.add(new Accident(1, "교통사고", "2024-06-04", "명지대", 1, "Pending", assessmentStatus) {
//            @Override
//            public void receiveAccident() {
//                // 사고 접수 로직
//            }
//        }); // test data

        try {
            System.out.println(gitMENU_INFO.getMsg());
            showList(accidentList.get());

            System.out.println(MSG_ASSESS_DAMAGE.getMsg());
            long accidentId = Long.parseLong(input());
            Accident accident = accidentList.get(accidentId);

            if (accident != null) {
                handleCompensation(accidentId);
            } else {
                System.out.println(MSG_VALIDATE_ACCIDENT_ID.getMsg());
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
                c_customerList.add(customerList.get(accidentList.get(accidentId).getCustomerId()));
                Compensation compensation = new Compensation(money, accidentList.get(accidentId).getCustomerId(), customerList);
                compensationList.add(compensation);
                break;
            case "2":
                accidentList.delete(accidentId);
                break;
            case "x":
                return;
            default:
                System.out.println(MENU_INVALID_CHOICE.getMsg());
        }
    }

    private static void compensate() {
        try {
            System.out.println(gitMENU_INFO.getMsg());
            showList(compensationList.get());
            System.out.println(MSG_ASSESS_COMPENSATE.getMsg());

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
                System.out.println(MSG_VALIDATE_COMPENSATE_ID.getMsg());
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        System.out.println("이름, 성별, 전화번호, 생일, 운전경력(개월) 입력");
        Customer registerCustomer = join.register(input(), input(), input(), input(),
                Integer.parseInt(input()));
        customerList.add(registerCustomer); // 고객 리스트에 추가

        System.out.println("가입할 보험 종류를 선택하세요: 1. 운전자 보험 2. 자차 보험");
        String insuranceChoice = input();

        Insurance insurance = null;

        switch (insuranceChoice) {
            case "1":
                if (underwritingDriver(registerCustomer)) {
                    System.out.println("고객님께서 이용 중이신 자동차의 주행 거리를 입력해 주세요.");
                    insurance = new Driver((int) registerCustomer.getCustomerID(), new InsuranceFee(20000), "X", new Policy(),
                            100, Integer.parseInt(input()), new Date());
                    registerCustomer.addInsurance(insurance); // 고객의 보험 리스트에 추가
                    System.out.println(registerCustomer.getName() + "님, 운전자 보험 가입이 완료되었습니다.");
                } else {
                    System.out.println(registerCustomer.getName() + "님, 운전자 보험 가입 심사에 실패하였습니다.");
                }
                break;
            case "2":
                if (underwritingOwnCar(registerCustomer)) {
                    System.out.println("고객님께서 이용 중인 자동차의 주행거리, 차량 모델, 차량 번호를 입력해 주세요");
                    insurance = new OwnCar((int) registerCustomer.getCustomerID(), new InsuranceFee(10000), "X", new Policy(), 100,
                            Integer.parseInt(input()), Integer.parseInt(input()), Integer.parseInt(input()));
                    registerCustomer.addInsurance(insurance); // 고객의 보험 리스트에 추가
                    insuranceList.add(insurance);
                    System.out.println(registerCustomer.getName() + "님, 자차 보험 가입이 완료되었습니다.");
                } else {
                    System.out.println(registerCustomer.getName() + "님, 자차 보험 가입 심사에 실패하였습니다.");
                }
                break;
            default:
                System.out.println("유효하지 않은 선택입니다.");
                return;
        }

        registerCustomer.addInsurance(insurance); // 고객의 보험 리스트에 추가
        insuranceList.add(insurance); // InsuranceListImpl에 추가
    }


    // 운전자 보험 심사 로직
    public static boolean underwritingDriver(Customer customer) {
        if (customer.getDrivingExperience() < 3) {
            System.out.println("운전 경력이 3년 미만인 경우 운전자 보험에 가입할 수 없습니다.");
            return false;
        }
        // 추가적인 심사 조건들을 여기에 추가할 수 있습니다.
        return true;
    }

    // 자차 보험 심사 로직
    public static boolean underwritingOwnCar(Customer customer) {
        if (customer.getDrivingExperience() < 3) {
            System.out.println("운전 경력이 3년 미만인 경우 운전자 보험에 가입할 수 없습니다.");
            return false;
        }

        // 추가적인 심사 조건들을 여기에 추가할 수 있습니다.
        return true;
    }

    private static void accidentReport() {
        try {
            System.out.println(MSG_ASK_CUSTOMER_ID.getMsg());
            long customerId = Long.parseLong(input());

            Customer customer = customerList.get(customerId);
            if (customer == null) {
                System.out.println(MSG_VALIDATE_ID.getMsg());
                return;
            }

            System.out.println(MSG_ASK_ACCIDENT_DETAILS.getMsg());
            String accidentDetails = input();

            System.out.println(MSG_ASK_ACCIDENT_DATE.getMsg());
            String date = input();

            System.out.println(MSG_ASK_ACCIDENT_LOCATION.getMsg());
            String location = input();

            System.out.println(MSG_ASK_CAR_NUMBER.getMsg());
            String carNumber = input();

            System.out.println(MSG_ASK_ACCIDENT_TYPE.getMsg());
            String accidentType = input();

            boolean hasDriverInsurance = customer.getInsuranceList().stream().anyMatch(insurance -> insurance instanceof Driver);
            boolean hasAutoInsurance = customer.getInsuranceList().stream().anyMatch(insurance -> insurance instanceof OwnCar);
            if ("본인상해".equals(accidentType) && !hasDriverInsurance) {
                System.out.println("운전자 보험에 가입된 고객만 본인 상해 사고를 접수할 수 있습니다.");
                return;
            }

            if (("대인배상".equals(accidentType) || "대물배상".equals(accidentType)) && !hasAutoInsurance) {
                System.out.println("자차 보험에 가입된 고객만 대인배상 및 대물배상 사고를 접수할 수 있습니다.");
                return;
            }

            String[] additionalParams;
            if ("본인상해".equals(accidentType)) {
                System.out.println("부상의 정도를 입력하세요(1~10):");
                String severity = input();
                System.out.println("차량피해정도 입력하세요(1~10):");
                String carDamage = input();
                System.out.println("의료기록 영수증을 입력하세요:");
                String medicalReceipt = input();
                System.out.println("차량수리비 영수증을 입력하세요:");
                String repairReceipt = input();
                additionalParams = new String[]{severity, carDamage, medicalReceipt, repairReceipt};
            } else if ("대인배상".equals(accidentType)) {
                System.out.println("피해자 이름을 입력하세요:");
                String victimName = input();
                System.out.println("피해자 연락처를 입력하세요:");
                String victimContact = input();
                System.out.println("피해자 부상 정도를 입력하세요:");
                String injurySeverity = input();
                System.out.println("피해자 의료기록 및 영수증을 입력하세요:");
                String medicalRecordsAndReceipts = input();
                additionalParams = new String[]{victimName, victimContact, injurySeverity, medicalRecordsAndReceipts};
            } else if ("대물배상".equals(accidentType)) {
                System.out.println("피해재산종류를 입력하세요:");
                String propertyType = input();
                System.out.println("사고현장사진을 첨부하세요:");
                String accidentPhotoUrl = input();
                System.out.println("청구비 영수증을 첨부하세요:");
                String receiptUrl = input();
                additionalParams = new String[]{propertyType, accidentPhotoUrl, receiptUrl};
            } else {
                System.out.println("유효하지 않은 사고 유형입니다.");
                return;
            }

            Accident accident = AccidentFactory.createAccident(accidentType, accidentDetails, date, location, customer, carNumber, additionalParams);
            accidentList.add(accident);
            System.out.println(MSG_ACCIDENT_REPORTED.getMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void payInsuranceFee() {
        showList(customerList.get());

        try {
            System.out.println(MSG_ASK_CUSTOMER_ID.getMsg());
            long customerId = Long.parseLong(input());
            showList(insuranceList.get());
            System.out.println(MSG_ASK_INSURANCE_ID.getMsg());
            long insuranceId = Long.parseLong(input());
            Customer customer = customerList.get(customerId);
            Insurance insurance = insuranceList.get(insuranceId);
            if (customer != null && insurance != null) {
                if (insurance.getPaymentStatus().equals(MSG_FALSE.getMsg())) {
                    System.out.println(MSG_CHECK_PAY.getMsg());
                    String checkPay = input();
                    if (checkPay.equals(MSG_TRUE.getMsg())) {
                        System.out.println(MSG_PAY_INFO.getMsg());
                        customer.pay(insurance);
                        System.out.println(MSG_COMPLETE_INSURANCE_FEE.getMsg());
                        System.out.println(MSG_PAYMENT_FEE.getMsg() + insurance.getInsuranceFee().getAmount() + MSG_PAYMENT_DATE.getMsg() + insurance.getInsuranceFee().getDateOfPayment());
                        System.out.println();
                    } else {
                        System.out.println(MSG_CANCEL_PAY.getMsg());
                    }
                } else {
                    System.out.println(MSG_ALREADY_PAY.getMsg());
                    System.out.println();
                }
            } else {
                System.out.println(MSG_VALIDATE_ID.getMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void makeAccount() { // 예외처리 안함
        try {
            System.out.println("1. 계좌확인");
            System.out.println("2. 계좌등록");
            System.out.println("3. 입출금 내역 확인");
            Customer customer = customerList.get(1);
            String choice = input();
            switch (choice) {
                case "1": // 계좌 확인
                    if (customer.getAccount() == null) {
                        System.out.println("등록된 계좌가 없습니다.");
                    } else {
                        System.out.println(customer.getAccount());
                    }
                    break;
                case "2": // 계좌 등록
                    System.out.print("계좌번호: ");
                    String accountNumber = input();

                    System.out.print("\n은행이름: ");
                    String bankName = input();

                    System.out.print("\n계좌주: ");
                    String depositor = input();

                    Account account = new Account(accountNumber, bankName, depositor);
                    customer.setAccount(account);

                    System.out.println("고객님의 계좌가 등록되었습니다.");
                    break;
                case "3":
                    // 입출금 내역 확인
                    break;
                case "4":
                    showList(customerList.get());
                    break;
                case "x":
                    System.exit(0);
                    break;
                default:
                    System.out.println(MENU_INVALID_CHOICE.getMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void loan() {
        if(customerList.get().isEmpty()){
            System.out.println("\n\n대출 실행 대상은 보험사 고객만 해당됩니다.\n\n");
            return;
        }
        try {
            Customer customer = customerList.get(1); // test code

            System.out.println("1. 대출 정보 확인");
            System.out.println("2. 대출 신청");
            System.out.println("3. 대출 실행");
            System.out.println("4. 대출금 상환");

            String choice = input();
            switch (choice) {
                case "1": // 대출 정보 확인

                    break;
                case "2": //  대출 신청
//                    if (customer.getInsuranceList().isEmpty()) { // 찐
                    if (false) { // test
                        System.out.println("대출 실행 대상은 보험사 고객만 해당됩니다.");
                    } else {
                        System.out.print("\n신분증 사본: ");
                        String copyOfIdenrificationCard = input();

                        System.out.print("\n소득증빙 서류: ");
                        String incomeProofDocument = input();

                        Loan loan = new Loan(copyOfIdenrificationCard, incomeProofDocument, customer);
                        customer.setLoan(loan);
                        loanList.add(loan);
                        System.out.println("대출이 신청되었습니다. 심사기간은 약 1-2주 소요되며 심사결과는 메시지로 확인 가능합니다.");
                    }
                    break;
                case "3": //  대출 실행
                    if (customer.getLoan().isLoanStatus()) { // 대출 심사에 의해 대출이 승인된 경우
                        long capacity = 100000;
                        System.out.println("대출 가능 금액: " + capacity + "원");

                        System.out.print("대출 신청 금액: ");
                        long money = Long.parseLong(input());

                        while (money > capacity) {
                            System.out.println("대출 가능 금약을 초과하지 않는 금액을 입력해주세요");
                            System.out.print("대출 신청 금액: ");
                            money = Long.parseLong(input());
                        }
                        System.out.println("대출 실행이 완료되었습니다.");
                    } else {
                        long loanId = customer.getLoan().getLoanID();
                        System.out.println(loanList.get(loanId).getRejectionReason());
                    }
                    break;
                case "4": //  대출금 상환

                    break;
                case "x":
                    System.exit(0);
                    break;
                default:
                    System.out.println(MENU_INVALID_CHOICE.getMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void judgeLoan() {
        if (loanList.get() == null) {
            System.out.println("현재 대출 심사 건이 없습니다.");
            return;
        }

        try {
            showList(loanList.get());

            System.out.println("대출심사를 잔행할 내역을 입력하세요.");
            long loanId = Long.parseLong(input());

            if (loanList.get(loanId) != null) {
                System.out.println("1. [승인] ");
                System.out.println("2. [거절] ");

                int choice = Integer.parseInt(input());

                switch (choice) {
                    case 1: // 승인
                        loanList.get(loanId).setLoanStatus(true);
                        System.out.println("대출 승인이 완료되었습니다.");
                        break;
                    case 2: // 거절
                        loanList.delete(loanId);
                        System.out.print("거절 사유: ");
                        String rejectionReason = input();
                        loanList.get(loanId).setRejectionReason("대출 신청이 다음 사유에 의해 거절되었습니다.\n" + rejectionReason);
                        break;
                    default:
                        System.out.println(MENU_INVALID_CHOICE.getMsg());
                }
            } else {
                System.out.println(MSG_VALIDATE_LOAN_ID.getMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void showList(ArrayList<?> dataList) {
        for (Object o : dataList) {
            System.out.println(o);
        }
    }

    private static void printMenu() {
        System.out.println(WELCOME_MESSAGE.getMsg());
        System.out.println(gitMENU_INFO.getMsg());
        System.out.println(MENU_JOIN.getMsg());
        System.out.println(MENU_DESIGN.getMsg());
        System.out.println(MENU_PAY.getMsg());
        System.out.println(MENU_DAMAGE_ASSESSMENT.getMsg());
        System.out.println(MENU_ACCIDENT.getMsg());
        System.out.println(MENU_LOAN.getMsg());
        System.out.println(MENU_COUNSELLING.getMsg());
        System.out.println(MENU_CONPENSATE.getMsg());
        System.out.println(MENU_ACCOUNT.getMsg());
        System.out.println(MENU_LOAN_EMPLOYEE.getMsg());
        System.out.println(MENU_EXIT.getMsg());
    }
}
