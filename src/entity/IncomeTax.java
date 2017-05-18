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
	
	private Double taxes;//˰��
	private Double salaryBeforeTax;//˰ǰ���ʽ���������
	private Double socialInsurance;//��ᱣ�շ�
	private Double housingFund;//ס��������
	private Double salaryAfterTax;//˰������
	
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

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Double getSalaryBeforeTax() {
		return salaryBeforeTax;
	}

	public void setSalaryBeforeTax(Double salaryBeforeTax) {
		this.salaryBeforeTax = salaryBeforeTax;
	}

	public Double getSocialInsurance() {
		return socialInsurance;
	}

	public void setSocialInsurance(Double socialInsurance) {
		this.socialInsurance = socialInsurance;
	}

	public Double getHousingFund() {
		return housingFund;
	}

	public void setHousingFund(Double housingFund) {
		this.housingFund = housingFund;
	}

	public Double getSalaryAfterTax() {
		return salaryAfterTax;
	}

	public void setSalaryAfterTax(Double salaryAfterTax) {
		this.salaryAfterTax = salaryAfterTax;
	}
	
}
