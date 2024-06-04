package src.system.utils;

public enum MESSAGE {

  WELCOME_MESSAGE("보험사 시스템에 접속하신 것을 환영합니다."),
  MENU_INFO("********************** MENU ***********************"),
  MENU_JOIN("1. 보험 가입"),
  MENU_DESIGN("2. 상품 설계"),
  MENU_PAY("3. 보험료 납부"),
  MENU_ACCIDENT("4. 사고 접수"),
  MENU_LOAN("5. 대출"),
  MENU_EXIT("X. 종류");



  private final String msg;

  MESSAGE(String msg) {
    this.msg = msg;
  }
}
