package src.system.product;

import java.text.NumberFormat;

public class Product {
	private static long lastID = 0L;
	private String description;
	private String name;
	private double basePremium;
	private double coverageLimit;
	private long productId;
	private String policyDetails;
	private String insuranceType;

	public Product() {}

	public Product(String name, double basePremium, double coverageLimit, String policyDetails, String insuranceType) {
		lastID++;
		this.productId = lastID;
		this.name = name;
		this.basePremium = basePremium;
		this.coverageLimit = coverageLimit;
		this.policyDetails = policyDetails;
		this.insuranceType = insuranceType;
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

	public String getPolicyDetails() {
		return policyDetails;
	}

	public void makePlan() {
		// 계획 수립 로직
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(true);
		return
				"보험 종류: '" + insuranceType + '\'' +
						", 보험 이름: '" + name + '\'' +
						", 보험료: 매월 " + nf.format(basePremium) + "원" +
						", 보상 한도: " + nf.format(coverageLimit) + "원" +
						", 보험 정책: " + policyDetails;
	}

	public void setPolicyDetails(String policyDetails) {
		this.policyDetails = policyDetails;
	}
}
