package test;

import util.TaxUtil;
import entity.IncomeTax;

public class TaxUtilTest {
	public static void main(String[] args) {
		IncomeTax incomeTax = new IncomeTax(8400,230.34,710);
		IncomeTax resultIncomeTax = TaxUtil.getIncomeTaxForSalary(incomeTax);
		System.out.println("�㱾��Ӧ�۸�������˰Ϊ:"+resultIncomeTax.getTaxes()+"��˰������Ϊ��"+resultIncomeTax.getSalaryAfterTax());
	}
}
