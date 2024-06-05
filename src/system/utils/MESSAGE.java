package src.system.utils;

public enum MESSAGE {

  WELCOME_MESSAGE("보험사 시스템에 접속하신 것을 환영합니다."),
  MENU_INFO("********************** MENU ***********************"),
  MENU_JOIN("1. 보험 가입"),
  MENU_DESIGN("2. 상품 설계"),
  MENU_PAY("3. 보험료 납부"),
  MENU_DAMAGE_ASSESSMENT("4. 손해사정"),
  MENU_ACCIDENT("5. 사고 접수"),
  MENU_LOAN("6. 대출"),
  MENU_COUNSELLING("7. 상담"),
  MENU_EXIT("X. 종류"),

  MSG_ASSESS_DAMAGE("위 사고 접수 리스트에서 손해사정을 진행할 사고의 accidentId를 입력해주세요"),
  MSG_COMPENSATION_ASK("해당 고객에게 보상을 진행하겠습니까?"),
  MSG_CALCULATE_PAYOUT("고객에게 지급할 보험금을 산정해주세요."),
  MSG_YES_OR_NO("1. 예    2. 아니오"),
  MSG_COUNSELLING_REQUESTED("상담 요청 중입니다."),
  MSG_COUNSELLING_CONFIRMED("상담이 확인되었습니다."),
  MSG_COUNSELLING_SCHEDULED("6월 5일 18시에 상담이 확정되었습니다."),
  MSG_VALIDATE_ID("유효한 accidentId를 입력해주세요");
  public String getMsg() {
    return msg;
  }

  private final String msg;

  MESSAGE(String msg) {
    this.msg = msg;
  }
}
