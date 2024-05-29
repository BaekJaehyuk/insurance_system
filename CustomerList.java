package 설계.도메인2;


/**
 * @author SW인재육성사업단
 * @version 1.0
 * @created 29-5-2024 오후 10:34:51
 */
public interface CustomerList {

	/**
	 * 
	 * @param customerID
	 */
	public void add(int customerID);

	public void delete();

	public void get();

	public void update();

}