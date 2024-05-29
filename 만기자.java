package 설계.도메인2;


/**
 * @author SW인재육성사업단
 * @version 1.0
 * @created 29-5-2024 오후 10:34:58
 */
public class 만기자 extends Customer {

	public 만기자(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}