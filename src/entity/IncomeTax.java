package entity;

import java.io.Serializable;

/**
 * ��������˰ʵ��
 * @Description:TODO
 * @author YanTu
 * @date:2017��5��17������10:29:26
 */
public class IncomeTax implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private double taxes;//˰��
	private double salaryBeforeTax;//˰ǰ���ʽ���������
	private double socialInsurance;//��ᱣ�շ�
	private double housingFund;//ס��������
	private double salaryAfterTax;//˰������
	
	public IncomeTax() {
	}
	
	public IncomeTax(double taxes) {
		this.taxes = taxes;
	}
	
	public IncomeTax(double salaryBeforeTax,double socialInsurance,double housingFund) {
		this.salaryBeforeTax = salaryBeforeTax;
		this.socialInsurance = socialInsurance;
		this.housingFund = housingFund;
	}
	
	public double getTaxes() {
		return taxes;
	}
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	public double getSocialInsurance() {
		return socialInsurance;
	}
	public void setSocialInsurance(double socialInsurance) {
		this.socialInsurance = socialInsurance;
	}
	public double getHousingFund() {
		return housingFund;
	}
	public void setHousingFund(double housingFund) {
		this.housingFund = housingFund;
	}

	public double getSalaryBeforeTax() {
		return salaryBeforeTax;
	}

	public void setSalaryBeforeTax(double salaryBeforeTax) {
		this.salaryBeforeTax = salaryBeforeTax;
	}

	public double getSalaryAfterTax() {
		return salaryAfterTax;
	}

	public void setSalaryAfterTax(double salaryAfterTax) {
		this.salaryAfterTax = salaryAfterTax;
	}
	
	
	
}
