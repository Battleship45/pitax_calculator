package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import util.StringOperateUtil;
import util.TaxUtil;
import entity.IncomeTax;

/**
 * ��˰�������ܴ���
 * @Description:չʾ��˰����������������
 * @author YanTu
 * @date:2017��5��17������2:12:03
 */
public class TaxCalFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JRadioButtonMenuItem countTaxRadio = new JRadioButtonMenuItem("�����������˰");
	private JRadioButtonMenuItem countSalaryRadio = new JRadioButtonMenuItem("����˰ǰ����");
	//����
	private JLabel salaryLabel = new JLabel("");
	private JLabel socialInsuranceLabel = new JLabel("");
	private JLabel housingFundLabel = new JLabel("");
	private JTextField salaryField = new JTextField("");
	private JTextField socialInsuranceField = new JTextField("");
	private JTextField housingFundField = new JTextField("");
	//���
	private JLabel taxesLabel = new JLabel("");
	private JLabel salaryAfterTaxLabel = new JLabel("");
	private JTextField taxesField = new JTextField("");
	private JTextField salaryAfterTaxField = new JTextField("");
	public TaxCalFrame() {
		init();
	}
	/**
	 * @Description:ҳ���ʼ��
	 * @author:YanTu
	 * @date:2017��5��17������2:17:09
	 */
	private void init() {
		setTitle("��˰������");
		setBounds(450,150,280,350);
		setBackground(Color.white);
		setContentPane(createContentPane());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/**
	 * @Description:����������
	 * @author:YanTu
	 * @date:2017��5��17������2:39:18
	 */
	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(createInputContentPane(),"North");
		pane.add(createOutputPane(),"South");
		pane.setBorder(new EmptyBorder(10,10,10,10));//�ϣ����£���
		pane.setBackground(Color.WHITE);
		return pane;
	}
	
	/**
	 * @Description:���������������
	 * @author:YanTu
	 * @date:2017��5��17������2:52:13
	 */
	private Component createInputContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(createModeSelectPane(),"North");
		pane.add(createInputFieldsPane(),"Center");
		pane.add(createCountButtonPane(),"South");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * 
	 * @Description:����ģʽѡ�����
	 * @author:YanTu
	 * @date:2017��5��17������2:54:30
	 */
	private Component createModeSelectPane() {
		JPanel pane = new JPanel(new GridLayout(2,1,3,3));
		ButtonGroup bg = new ButtonGroup();
		bg.add(countTaxRadio);
		bg.add(countSalaryRadio);
		pane.add(countTaxRadio);
		pane.add(countSalaryRadio);
//		countTaxRadio.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(countTaxRadio.equals(e.getSource())){
//					JLabel salaryLabel = new JLabel("˰ǰ��������");
//					pane.add(salaryLabel,"South");
//				}
//			}
//			private Component countTaxFieldsPane() {
//				JPanel pane = new JPanel(new BorderLayout());
//				JLabel salaryLabel = new JLabel("˰ǰ��������");
//				JTextField salaryField = new JTextField("˰ǰ��������");
//				pane.add(salaryLabel,"North");
//				pane.add(salaryField,"Center");
//				return pane;
//			}
//		});
		//JRadioButton radio = new JRadioButton("�����������˰");
		//pane.add(radio);
		countTaxRadio.setBackground(Color.WHITE);
		countSalaryRadio.setBackground(Color.WHITE);
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * @Description:��������ֵ���
	 * @author:YanTu
	 * @date:2017��5��17������2:51:58
	 */
	private Component createInputFieldsPane() {
		//JPanel pane = new JPanel(new BorderLayout());
		JPanel pane = new JPanel(new GridLayout(3,1,3,3));
		pane.add(createSalaryPane());
		pane.add(createSocialInsurancePane());
		pane.add(createHousingFundPane());
		pane.setBorder(new EmptyBorder(30,10,30,10));//�ϣ����£���
		pane.setBackground(Color.WHITE);
		return pane;
	}
	
	private Component createSalaryPane() {
		JPanel pane = new JPanel(new BorderLayout());
		salaryLabel = new JLabel("˰ǰ���룺");
		salaryField = new JTextField("");
		pane.add(salaryLabel,"West");
		pane.add(salaryField,"Center");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	private Component createSocialInsurancePane() {
		JPanel pane = new JPanel(new BorderLayout());
		socialInsuranceLabel = new JLabel("�籣��");
		socialInsuranceField = new JTextField("");
		pane.add(socialInsuranceLabel,"West");
		pane.add(socialInsuranceField,"Center");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	private Component createHousingFundPane() {
		JPanel pane = new JPanel(new BorderLayout());
		housingFundLabel = new JLabel("������");
		housingFundField = new JTextField("");
		pane.add(housingFundLabel,"West");
		pane.add(housingFundField,"Center");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * @Description:�������㰴ť���
	 * @author:YanTu
	 * @date:2017��5��17������2:51:27
	 */
	private Component createCountButtonPane() {
		JPanel pane = new JPanel();
		//pane.setSize(300, 30);
		JButton count = new JButton("����");
		pane.add(count);
		count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String salaryText = salaryField.getText();
				String socialInsuranceText =socialInsuranceField.getText();
				String housingFundText = housingFundField.getText();
				double salary = StringOperateUtil.isExist(salaryText)?Double.parseDouble(salaryText):0.0;
				double socialInsurance = StringOperateUtil.isExist(socialInsuranceText)?Double.parseDouble(socialInsuranceText):0.0;
				double housingFund = StringOperateUtil.isExist(housingFundText)?Double.parseDouble(housingFundText):0.0;
				IncomeTax incomeTax = new IncomeTax(salary,socialInsurance,housingFund);
				IncomeTax resultIncomeTax = TaxUtil.getIncomeTaxForSalary(incomeTax);
				taxesField.setText(String.valueOf(resultIncomeTax.getTaxes()));
				salaryAfterTaxField.setText(String.valueOf(resultIncomeTax.getSalaryAfterTax()));
			}
		});
		pane.setBackground(Color.WHITE);
		return pane;
	}

	/**
	 * @Description:����Ҳ�������
	 * @author:YanTu
	 * @date:2017��5��17������2:39:45
	 */
	private Component createOutputPane() {
		JPanel pane = new JPanel(new GridLayout(2,1,3,3));
		pane.add(createTaxesPanel());
		pane.add(createSalaryAfterTaxPanel());
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * @Description:Ӧ�۸�������˰���
	 * @author:YanTu
	 * @date:2017��5��17������5:26:57
	 */
	private Component createTaxesPanel() {
		JPanel pane = new JPanel(new BorderLayout());
		taxesLabel = new JLabel("�㱾��Ӧ�۸�������˰Ϊ��");
		taxesField = new JTextField("");
		pane.add(taxesLabel,"West");
		pane.add(taxesField,"Center");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * @Description:˰���������
	 * @author:YanTu
	 * @date:2017��5��17������5:27:20
	 */
	private Component createSalaryAfterTaxPanel() {
		JPanel pane = new JPanel(new BorderLayout());
		salaryAfterTaxLabel = new JLabel("˰������Ϊ��");
		salaryAfterTaxField = new JTextField("");
		pane.add(salaryAfterTaxLabel,"West");
		pane.add(salaryAfterTaxField,"Center");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	
}
