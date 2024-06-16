package src.system.utils;

public enum MESSAGE {

  WELCOME_MESSAGE("보험사 시스템에 접속하신 것을 환영합니다."),
  gitMENU_INFO("********************** MENU ***********************"),
  MENU_JOIN("1. 보험 가입"),
  MENU_DESIGN("2. 상품 설계"),
  MENU_PAY("3. 보험료 납부"),
  MENU_DAMAGE_ASSESSMENT("4. 손해사정"),
  MENU_ACCIDENT("5. 사고 접수"),
  MENU_LOAN("6. 대출"),
  MENU_COUNSELLING("7. 상담"),
  MENU_CONPENSATE("8. 보험금 지급"),

  MENU_ACCOUNT("9. 입출금 계좌 관리"),
  MENU_LOAN_EMPLOYEE("10. 대출 심사"),
  MENU_VERIFY_ACCIDENT_REPORT("11. 사고 접수 심사"),
  MENU_EXIT("X. 종료"),
  MENU_INVALID_CHOICE("Invalid Choice !!!"),

  MSG_ASSESS_DAMAGE("위 사고 접수 리스트에서 손해사정을 진행할 사고 번호를 입력해주세요"),
  MSG_ASSESS_COMPENSATE("보상 확정 리스트에서 보상금을 지급할 compensationId를 입력해주세요"),

  MSG_COMPENSATION_ASK("해당 고객에게 보상을 진행하겠습니까?"),
  MSG_CALCULATE_PAYOUT("고객에게 지급할 보험금을 산정해주세요."),
  MSG_YES_OR_NO("1. 예    2. 아니오"),
  MSG_COUNSELLING_REQUESTED("상담 요청 중입니다."),
  MSG_COUNSELLING_CONFIRMED("상담이 확인되었습니다."),
  MSG_COUNSELLING_SCHEDULED("6월 5일 18시에 상담이 확정되었습니다."),
  MSG_ASK_CUSTOMER_ID("보험료를 지불할 고객의 customerId를 입력해주세요"),
  MSG_PAY_INFO("********************** 결제정보 ***********************"),
  MSG_PAYMENT_FEE("결제금액: "),
  MSG_PAYMENT_DATE(", 납부일자: "),
  MSG_CHECK_PAY("정말 결제하시겠습니까? (O)(X)"),
  MSG_ALREADY_PAY("이미 납부한 보험입니다."),
  MSG_CANCEL_PAY("결제가 취소되었습니다."),
  MSG_ASK_INSURANCE_ID("지불할 InsuranceId를 입력해주세요"),
  MSG_COMPLETE_INSURANCE_FEE("보험료가 납부되었습니다."),
  MSG_VALIDATE_ID("유효한 customerId 또는 insuranceId를 입력해주세요"),
  MSG_VALIDATE_ACCIDENT_ID("유효한 사고 번호를 입력해주세요"),
  MSG_VALIDATE_COMPENSATE_ID("유효한 compensationId를 입력해주세요"),
  MSG_VALIDATE_LOAN_ID("유효한 loanId를 입력해주세요"),
  MSG_ASK_ACCIDENT_DETAILS("사고 내용을 입력해주세요"),
  MSG_ASK_ACCIDENT_DATE("사고 날짜를 입력해주세요 (예: 2024-05-29)"),
  MSG_ASK_ACCIDENT_LOCATION("사고 장소를 입력해주세요"),
  MSG_ASK_ACCIDENT_TYPE("사고 유형을 입력해주세요 (예: 대인배상, 대물배상, 본인상해)"),
  MSG_ACCIDENT_REPORTED("사고가 접수되었습니다."),
  MSG_TRUE("O"),
  MSG_FALSE("X"),
  MSG_ASK_CAR_NUMBER("차량 번호를 입력해주세요");

  private final String msg;

  MESSAGE(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
