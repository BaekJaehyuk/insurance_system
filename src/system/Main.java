package src.system;

import static src.system.utils.MESSAGE.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.system.accident.*;
import src.system.compensation.Compensation;
import src.system.compensation.CompensationListImpl;
import src.system.counseling.Counseling;
import src.system.counseling.CounsellingListImpl;
import src.system.loan.Loan;
import src.system.loan.LoanListImpl;
import src.system.loan.LoanStatus;
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
            case "11":
                verifyAccidentReport();
                break;
            case "x":
                System.exit(0);
                break;
            default:
                System.out.println(MENU_INVALID_CHOICE.getMsg());
        }
    }

    private static void toAssessDamages() {
        try {
            if (accidentList.get().isEmpty()) {
                System.out.println("\n\n현재 접수된 사고 건이 없습니다.\n\n");
                return;
            }
            System.out.println(gitMENU_INFO.getMsg());

            System.out.println("------------사고 접수 내역------------");
            showList(accidentList.get());
            System.out.println("-----------------------------------");

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
        Accident accident = accidentList.get(accidentId);
        double insuranceMoney = 0;

        if (accident instanceof LiabilityAccident) { // 대인배상
            LiabilityAccident liabilityAccident = (LiabilityAccident) accident;
            System.out.println(liabilityAccident.liabilityAccidentDetail());

            insuranceMoney = Double.parseDouble(liabilityAccident.getMedicalRecords()) * 0.9;
        } else if (accident instanceof PersonalInjuryAccident) { // 본인상해
            PersonalInjuryAccident personalInjuryAccident = (PersonalInjuryAccident) accident;
            System.out.println(personalInjuryAccident.personalInjuryAccidentDetail());

            insuranceMoney = (Double.parseDouble(personalInjuryAccident.getMedicalReceipt()) +
                    Double.parseDouble(personalInjuryAccident.getRepairReceipt())) * 0.9;

        } else if (accident instanceof PropertyDamageAccident) { // 대물배상
            PropertyDamageAccident propertyDamageAccident = (PropertyDamageAccident) accident;
            System.out.println(propertyDamageAccident.propertyDamageAccidentDetail());

            insuranceMoney = Double.parseDouble(propertyDamageAccident.getReceiptUrl()) * 0.9;
        }

        System.out.println("산정된 보험금: " + insuranceMoney +'\n');

        System.out.println(MSG_COMPENSATION_ASK.getMsg());
        System.out.println(MSG_YES_OR_NO.getMsg());

        String choice = input();
        switch (choice) {
            case "1":
                c_customerList.add(customerList.get(accidentList.get(accidentId).getCustomerId()));
                Compensation compensation = new Compensation(insuranceMoney, accidentList.get(accidentId).getCustomerId(),
                        customerList);
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
            long customerId = compensationList.get(compensationId).getCustomerId();

            if (compensationList.get(compensationId) == null) {
                System.out.println(MSG_VALIDATE_COMPENSATE_ID.getMsg());
                return;
            }

            if(compensationList.get(compensationId).pay()){
                System.out.println(c_customerList.get(customerId).getName() + "고객님에게 "
                        + compensationList.get(compensationId).getMoney() + "원이 지급되었습니디.");
                compensationList.delete(compensationId);
                c_customerList.delete(customerId);
            }else{
                System.out.println(c_customerList.get(customerId).getName() + "고객님의 계좌 정보가 없습니다.");
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
                    insurance = new Driver((int) registerCustomer.getCustomerID(), new InsuranceFee(20000), "X",
                            new Policy(),
                            100, Integer.parseInt(input()), new Date());
                    registerCustomer.addInsurance(insurance); // 고객의 보험 리스트에 추가
                    insuranceList.add(insurance); // InsuranceListImpl에 추가
                    System.out.println(registerCustomer.getName() + "님, 운전자 보험 가입이 완료되었습니다.");
                } else {
                    System.out.println(registerCustomer.getName() + "님, 운전자 보험 가입 심사에 실패하였습니다.");
                }
                break;
            case "2":
                if (underwritingOwnCar(registerCustomer)) {
                    System.out.println("고객님께서 이용 중인 자동차의 주행거리, 차량 모델, 차량 번호를 입력해 주세요");
                    insurance = new OwnCar((int) registerCustomer.getCustomerID(), new InsuranceFee(10000), "X",
                            new Policy(), 100,
                            Integer.parseInt(input()), Integer.parseInt(input()), Integer.parseInt(input()));
                    registerCustomer.addInsurance(insurance); // 고객의 보험 리스트에 추가
                    insuranceList.add(insurance); // InsuranceListImpl에 추가
                    System.out.println(registerCustomer.getName() + "님, 자차 보험 가입이 완료되었습니다.");
                } else {
                    System.out.println(registerCustomer.getName() + "님, 자차 보험 가입 심사에 실패하였습니다.");
                }
                break;
            default:
                System.out.println("유효하지 않은 선택입니다.");
                return;
        }
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
            System.out.println("사고를 접수할 고객의 ID를 입력해 주세요");
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

            boolean hasDriverInsurance = customer.getInsuranceList().stream()
                    .anyMatch(insurance -> insurance instanceof Driver);
            boolean hasAutoInsurance = customer.getInsuranceList().stream()
                    .anyMatch(insurance -> insurance instanceof OwnCar);

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
                additionalParams = new String[]{victimName, victimContact, injurySeverity,
                        medicalRecordsAndReceipts};
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

            Accident accident = AccidentFactory.createAccident(accidentType, accidentDetails, date, location, customer,
                    carNumber, additionalParams);
            accidentList.add(accident);
            System.out.println(MSG_ACCIDENT_REPORTED.getMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void verifyAccidentReport() throws IOException {
        System.out.println("사고 접수 확인:");
        List<Accident> accidents = accidentList.get();
        for (Accident accident : accidents) {
            System.out.println("접수번호: " + accident.getAccidentId() + ", 사고유형: " + accident.getType());
        }

        System.out.println("확인할 접수번호를 입력하세요:");
        long accidentId = Long.parseLong(input());

        Accident accident = accidentList.get(accidentId);
        if (accident == null) {
            System.out.println("유효하지 않은 접수번호입니다.");
            return;
        }

        System.out.println("사고 접수 상세 정보:");
        System.out.println(accident);

        System.out.println("고객 가입 상품:");
        Customer customer = customerList.get(accident.getCustomerId());
        showList(customer.getInsuranceList());

        System.out.println("[접수하기]를 클릭하려면 '1'을, [반려하기]를 클릭하려면 '2'를 입력하세요:");
        String choice = input();
        if ("1".equals(choice)) {
            accident.setStatus("접수됨");
            System.out.println("사고가 접수되었습니다.");
        } else if ("2".equals(choice)) {
            accidentList.delete(accidentId);
            System.out.println("사고 접수가 반려되었습니다.");
        } else {
            System.out.println("유효하지 않은 선택입니다.");
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
                        System.out.println(MSG_PAYMENT_FEE.getMsg() + insurance.getInsuranceFee().getAmount()
                                + MSG_PAYMENT_DATE.getMsg() + insurance.getInsuranceFee().getDateOfPayment());
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

    private static void makeAccount() {
        try {
            Customer customer = customerList.get(1);
            if (customer == null) {
                System.out.println("\n\n보험 가입 고객만 이용 가능합니다.\n\n");
                return;
            }

            System.out.println("1. 계좌확인");
            System.out.println("2. 계좌등록");
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
        if (customerList.get().isEmpty()) {
            System.out.println("\n\n대출은 보험사 고객만 이용가능합니다.\n\n");
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
                    if (customer.getLoan() == null) {
                        System.out.println("\n\n대출 정보가 없습니다.\n\n");
                        return;
                    }

                    if (customer.getLoan().getLoanStatus() == null) {
                        System.out.println("\n\n대출 실행 후 확인 가능합니다.\n\n");
                        return;
                    }

                    System.out.println(customer.getLoan().getLoanStatus());
                    break;
                case "2": // 대출 신청
                    if (customer.getInsuranceList().isEmpty()) {
                        System.out.println("\n\n대출 대상은 보험사 고객만 해당됩니다.\n\n");
                        return;
                    }

                    if (customer.getLoan() != null && customer.getLoan().getLoanStatus() != null) {
                        System.out.println("\n\n기대출자는 대출 신청이 불가능합니다.\n\n");
                        return;
                    }
                    System.out.print("\n 신분증 사본: ");
                    String copyOfIdenrificationCard = input();

                    System.out.print("\n 소득증빙 서류: ");
                    String incomeProofDocument = input();

                    Loan loan = new Loan(copyOfIdenrificationCard, incomeProofDocument, customer);
                    customer.setLoan(loan);
                    loanList.add(loan);
                    System.out.println("\n\n대출이 신청되었습니다. 심사기간은 약 1-2주 소요되며 심사결과는 메시지로 확인 가능합니다.\n\n");

                    break;
                case "3": // 대출 실행
                    if (customer.getLoan() == null) {
                        System.out.println("\n\n대출 승인 확정 후 대출 실행이 가능합니다.\n\n");
                        return;
                    }
                    if (customer.getLoan().getLoanStatus() != null) {
                        System.out.println("\n\n기대출자는 대출 실행이 불가능합니다.\n\n");
                        return;
                    }

                    long capacity = 10000000;
                    double interestRate = 0.3;
                    System.out.println("해당 대출 상품은 *원리금균등분할상환 상품입니다." +
                            "\n최대 대출 한도: " + capacity +
                            "\n이자율: " + interestRate +
                            "\n*원리금균등분할상환: 대출기간 동안 매월 원금과 이자를 합한 총 상환금액을 균등하게 상환하는 방식 " +
                            "\n\n계속 진행하시겠습니까? (1) 계속하기 (2) 돌아가기 \n");
                    String continueLoan = input();
                    if (!continueLoan.equals("1"))
                        return;

                    if (customer.getLoan().isApprovalLoan()) { // 대출 심사에 의해 대출이 승인된 경우

                        System.out.println("대출 가능 금액: " + capacity + "원");

                        System.out.print("대출 신청 금액: ");
                        int loanPrincipal = Integer.parseInt(input());
                        while (loanPrincipal > capacity) {
                            System.out.println("대출 가능 금액을 초과하지 않는 금액을 입력해주세요");
                            System.out.print("대출 신청 금액: ");
                            loanPrincipal = Integer.parseInt(input());
                        }

                        System.out.print("상환기간(개월): ");
                        int loanTerm = Integer.parseInt(input());
                        while (loanTerm < 1 || loanTerm > 12) {
                            System.out.println("유효한 일자를 입력해주세요");
                            System.out.print("상환기간(개월): ");
                            loanTerm = Integer.parseInt(input());
                        }

                        System.out.print("상환일자(일): ");
                        int repaymentSchedule = Integer.parseInt(input());
                        while (repaymentSchedule < 1 || repaymentSchedule > 28) {
                            System.out.println("유효한 일자를 입력해주세요");
                            System.out.print("상환일자: ");
                            repaymentSchedule = Integer.parseInt(input());
                        }

                        LoanStatus loanStatus = new LoanStatus(capacity, loanPrincipal, interestRate, loanTerm,
                                repaymentSchedule);
                        customer.getLoan().setLoanStatus(loanStatus);
                        System.out.println("대출 실행이 완료되었습니다.");
                    } else {
                        long loanId = customer.getLoan().getLoanID();
                        System.out.println(loanList.get(loanId).getRejectionReason());
                    }
                    break;
                case "4": // 대출금 상환
                    if (customer.getLoan() == null || customer.getLoan().isApprovalLoan() == false) {
                        System.out.println("대출이 존재하지 않습니다.");
                    }
                    long prevLoanBalance = customer.getLoan().getLoanStatus().getLoanBalance();
                    int prevRepaymentPeriod = customer.getLoan().getLoanStatus().getRepaymentPeriod();
                    long monthlyPayment = customer.getLoan().getLoanStatus().getMonthlyPayment();

                    System.out.println(
                            "\n대출 잔액: " + prevLoanBalance +
                                    "\n상환 회차: " + prevRepaymentPeriod +
                                    "\n월 상환금액: " + monthlyPayment +
                                    "\n\n상환을 진행하시겠습니까? (1) 계속하기 \n");
                    String continueRepayment = input();
                    if (!continueRepayment.equals("1"))
                        return;

                    customer.getLoan().getLoanStatus().setRepaymentPeriod(prevRepaymentPeriod + 1);
                    customer.getLoan().getLoanStatus().setLoanBalance(prevLoanBalance - monthlyPayment);
                    System.out.println("대출금이 상환되었습니다.");

                    if (customer.getLoan().getLoanStatus().getLoanBalance() == 0) {
                        System.out.println("대출잔액이 전액 상환되었습니다.");
                        loanList.delete(customer.getLoan().getLoanID());
                        customer.setLoan(null);
                        return;
                    }

                    break;
                case "x":
                    System.exit(0);
                    break;
                default:
                    System.out.println(MENU_INVALID_CHOICE.getMsg());
            }
        } catch (NumberFormatException e) {
            System.out.println("입력 값이 올바르지 않습니다. 숫자를 입력해 주세요.");
        } catch (IOException e) {
            System.out.println("입력 과정에서 오류가 발생했습니다. 다시 시도해 주세요.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("현재 시스템 오류가 발생하였습니다. 잠시 후 다시 시도해주세요.");
        }
    }

    private static void judgeLoan() {
        if (loanList.get().isEmpty()) {
            System.out.println("\n\n현재 대출 심사 건이 없습니다.\n\n");
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
                        loanList.get(loanId).setApprovalLoan(true);
                        System.out.println("대출 승인이 완료되었습니다.");
                        break;
                    case 2: // 거절
                        System.out.print("거절 사유: ");
                        String rejectionReason = input();
                        loanList.get(loanId)
                                .setRejectionReason("\n\n대출 신청이 다음 사유에 의해 거절되었습니다.\n" + rejectionReason + "\n\n");
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
        System.out.println(MENU_VERIFY_ACCIDENT_REPORT.getMsg());
        System.out.println(MENU_EXIT.getMsg());
    }
}
