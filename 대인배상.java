package 설계.도메인2;


/**
 * @author SW인재육성사업단
 * @version 1.0
 * @created 29-5-2024 오후 10:34:58
 */
public class 대인배상 extends Accident {

	private int 의료기록;
	private int 피해자 부상정도;
	private int 피해자 연락처;
	private int 피해자 이름;

	public 대인배상(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}