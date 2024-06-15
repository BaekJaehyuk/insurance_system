package src.system;


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
