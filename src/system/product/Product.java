package src.system.product;

public class Product {
	private static long lastID = 0L;
	private String description;
	private String name;
	private double basePremium;
	private double coverageLimit;

	private long productId;

	public Product() {}

	public Product(String name, double basePremium, double coverageLimit) {
		lastID++;
		this.productId = lastID;
		this.name = name;
		this.basePremium = basePremium;
		this.coverageLimit = coverageLimit;
	}

	public long getProductId() {
		return productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
	}

	public double getCoverageLimit() {
		return coverageLimit;
	}

	public void setCoverageLimit(double coverageLimit) {
		this.coverageLimit = coverageLimit;
	}

	public void approve() {
		// 승인 로직
	}

	public void confirm() {
		// 확인 로직
	}

	public void makePlan() {
		// 계획 수립 로직
	}

	@Override
	public String toString() {
		return "Product{" +
				"name='" + name + '\'' +
				", basePremium=" + basePremium +
				", coverageLimit=" + coverageLimit +
				'}';
	}
}
