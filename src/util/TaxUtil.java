package util;

import java.math.BigDecimal;

import entity.IncomeTax;

/**
 * ˰�ռ��㹤����
 * @Description:���ڼ����˰���͸��ݸ�˰���㹤�ʽ���
 * @author YanTu
 * @date:2017��5��17������10:32:28
 */
public class TaxUtil {
	
	/**
	 * ��˰���㷽��
	 * @Description:���ݹ��ʽ�����������������˰
	 * @author:YanTu
	 * @date:2017��5��17������10:40:53
	 */
	public static IncomeTax getIncomeTaxForSalary(IncomeTax incomeTax){
		//������
		double threshold = 3500.0;
		//��˰
		double taxes = 0.0;
		//˰������
		double salaryAfterTax = 0.0;
		//Ӧ��˰���ö�
		double taxableIncome = incomeTax.getSalaryBeforeTax()  - incomeTax.getSocialInsurance() 
				- incomeTax.getHousingFund() - threshold;
		taxes = countIncomeTaxInChengdu2017(taxableIncome);
		taxes = new BigDecimal(taxes).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		incomeTax.setTaxes(taxes);
		salaryAfterTax = getSalaryAfterTax(incomeTax);
		incomeTax.setSalaryAfterTax(salaryAfterTax);
		return incomeTax;
	}
	
	/**
	 * ����˰������
	 * @Description:TODO
	 * @author:YanTu
	 * @date:2017��5��17������10:59:08
	 */
	private static double getSalaryAfterTax(IncomeTax incomeTax) {
		double salaryAfterTax = incomeTax.getSalaryBeforeTax() - incomeTax.getSocialInsurance() 
				- incomeTax.getHousingFund() - incomeTax.getTaxes();
		salaryAfterTax = new BigDecimal(salaryAfterTax).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		return salaryAfterTax;
	}

	/**
	 * �ɶ�2017��������˰�̶����㷽��
	 * @Description:����Ŀǰ�ļ������ͨ��Ӧ��˰���ö�����˰
	 * @author:YanTu
	 * @date:2017��5��17������10:35:00
	 */
	private static double countIncomeTaxInChengdu2017(double taxableIncome){
		//��������˰���㹫ʽ:Ӧ��˰��=Ӧ��˰���ö�*����˰��-����۳���
		double tax = 0.0;
		if(taxableIncome <= 1500){
			tax = taxableIncome * 0.03;
		}else if(taxableIncome > 1500 && taxableIncome <= 4500){
			tax = taxableIncome * 0.1 - 105;
		}else if(taxableIncome > 4500 && taxableIncome <= 9000){
			tax = taxableIncome * 0.2 - 555;
		}else if(taxableIncome > 9000 && taxableIncome <= 35000){
			tax = taxableIncome * 0.25 - 1005;
		}else if(taxableIncome > 35000 && taxableIncome <= 55000){
			tax = taxableIncome * 0.3 - 2755;
		}else if(taxableIncome > 55000 && taxableIncome <= 80000){
			tax = taxableIncome * 0.35 - 5505;
		}else{//����8��
			tax = taxableIncome * 0.45 - 13505;
		}
		return tax;
	}
}
