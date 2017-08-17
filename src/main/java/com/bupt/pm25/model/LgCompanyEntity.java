package com.bupt.pm25.model;

public class LgCompanyEntity {
	private int id;
	private String companyFullName;//站点ID
	private String companyShortName;//站点名称
	private String companyCode;//检测站点所在区域
	private String companyLogo;
	private String city;
	private String industryField;
	private String companyFeatures;//空气质量指数
	private String financeStage;//pm25含量
	private int interviewRemarkNum;//pm10含量
	private int processRate;//一氧化碳含量
	private int approve;//二氧化氮含量
	private String countryScore;//臭氧含量
	private String cityScore;//二氧化硫含量
	private String introduce;
	private String product;
	private String process;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyFullName() {
		return companyFullName;
	}

	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}

	public String getCompanyShortName() {
		return companyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIndustryField() {
		return industryField;
	}

	public void setIndustryField(String industryField) {
		this.industryField = industryField;
	}

	public String getCompanyFeatures() {
		return companyFeatures;
	}

	public void setCompanyFeatures(String companyFeatures) {
		this.companyFeatures = companyFeatures;
	}

	public String getFinanceStage() {
		return financeStage;
	}

	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}

	public int getInterviewRemarkNum() {
		return interviewRemarkNum;
	}

	public void setInterviewRemarkNum(int interviewRemarkNum) {
		this.interviewRemarkNum = interviewRemarkNum;
	}

	public int getProcessRate() {
		return processRate;
	}

	public void setProcessRate(int processRate) {
		this.processRate = processRate;
	}

	public int getApprove() {
		return approve;
	}

	public void setApprove(int approve) {
		this.approve = approve;
	}

	public String getCountryScore() {
		return countryScore;
	}

	public void setCountryScore(String countryScore) {
		this.countryScore = countryScore;
	}

	public String getCityScore() {
		return cityScore;
	}

	public void setCityScore(String cityScore) {
		this.cityScore = cityScore;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}
}
