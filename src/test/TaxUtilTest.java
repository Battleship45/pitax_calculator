package test;

import util.TaxUtil;
import entity.IncomeTax;

public class TaxUtilTest {
	public static void main(String[] args) {
		IncomeTax incomeTax = new IncomeTax(7350,230.34,120);
		IncomeTax resultIncomeTax = TaxUtil.getIncomeTaxForSalary(incomeTax);
		System.out.println("�㱾��Ӧ�۸�������˰Ϊ:"+resultIncomeTax.getTaxes()+"��˰������Ϊ��"+resultIncomeTax.getSalaryAfterTax());

//		IncomeTax incomeTax = new IncomeTax(1200);//ͨ����˰�������
//		incomeTax.setSocialInsurance(300.0);//�籣��
//		incomeTax.setHousingFund(600.0);//���������
//		IncomeTax resultIncomeTax = TaxUtil.getSalaryByTax(incomeTax);
//		System.out.println("�㱾��˰ǰ����Ϊ:"+resultIncomeTax.getSalaryBeforeTax()+"��˰������Ϊ��"+resultIncomeTax.getSalaryAfterTax());
	}
}
