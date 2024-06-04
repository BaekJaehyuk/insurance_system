package src.system;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:50
 */
public class Car extends Insurance {

	private float mileage;


	public float getMileage(){
		return this.mileage;
	}

	public void setMileage(float mileage){
		this.mileage = mileage;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}