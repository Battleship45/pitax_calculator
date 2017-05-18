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
import javax.swing.JRadioButton;
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
	
	//����ģʽѡ��
	private JRadioButton countTaxRadio = new JRadioButton("����˰ǰ��������������˰");
	private JRadioButton countSalaryRadio = new JRadioButton("���ݸ�������˰����˰ǰ����");
	//����
	private JTextField salaryField = new JTextField("");
	private JTextField socialInsuranceField = new JTextField("");
	private JTextField housingFundField = new JTextField("");
	private JTextField taxesInputField = new JTextField("");
	
	private JPanel inputPane = new JPanel();
	private JPanel taxesInputPane = new JPanel();
	private JPanel salaryPane = new JPanel();
	//���
	private JTextField taxesOutPutField = new JTextField("");
	private JTextField salaryAfterTaxField = new JTextField("");
	private JTextField salaryBeforeTaxField = new JTextField("");
	
	private JPanel outPutPane = new JPanel();
	private JPanel taxesOutputPane = new JPanel();
	private JPanel salaryAfterTaxPane = new JPanel();
	private JPanel salaryBeforeTaxPane = new JPanel();
	
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
		setSize(280,360);
		setLocationRelativeTo(null);//�ô��ھ���
		this.setResizable(false);//���ɸı��С
		setBackground(Color.white);
		setContentPane(createContentPane());
		initContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/**
	 * @Description:��ʼ������
	 * @author:YanTu
	 * @date:2017��5��18������10:33:12
	 */
	private void initContentPane() {
		countTaxRadio.setSelected(true);
		inputPane.remove(taxesInputPane);//���ظ�˰�������
		outPutPane.remove(salaryBeforeTaxPane);//����˰ǰ����������
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
		pane.add(createCountButtonAreaPane(),"South");
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
		JPanel pane = new JPanel(new GridLayout(0,1,3,3));
		ButtonGroup bg = new ButtonGroup();
		bg.add(countTaxRadio);
		bg.add(countSalaryRadio);
		pane.add(countTaxRadio);
		pane.add(countSalaryRadio);
		pane.add(createPartingLine());
		countTaxRadio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				taxesInputPane.setVisible(false);
				inputPane.remove(taxesInputPane);
				salaryPane.setVisible(true);
				inputPane.add(salaryPane);
				
				salaryBeforeTaxPane.setVisible(false);
				outPutPane.remove(salaryBeforeTaxPane);
				taxesOutputPane.setVisible(true);
				salaryAfterTaxPane.setVisible(true);
				outPutPane.add(taxesOutputPane);
				outPutPane.add(salaryAfterTaxPane);
			}
		});
		countSalaryRadio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				salaryPane.setVisible(false);
				inputPane.remove(salaryPane);
				taxesInputPane.setVisible(true);
				inputPane.add(taxesInputPane);
				
				taxesOutputPane.setVisible(false);
				salaryAfterTaxPane.setVisible(false);
				outPutPane.remove(taxesOutputPane);
				outPutPane.remove(salaryAfterTaxPane);
				salaryBeforeTaxPane.setVisible(true);
				outPutPane.add(salaryBeforeTaxPane);
			}
		});
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
		GridLayout inputLayout = new GridLayout(0,1,3,3);
		//JPanel pane = new JPanel(new BorderLayout());
		inputPane = new JPanel(inputLayout);
//		JPanel pane = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		inputPane.add(createSocialInsurancePane());
		inputPane.add(createHousingFundPane());
		inputPane.add(createSalaryPane());
		inputPane.add(createTaxesInputPane());
		inputPane.setBorder(new EmptyBorder(15,10,10,10));//�ϣ����£���
		inputPane.setBackground(Color.WHITE);
		return inputPane;
	}
	/**
	 * @Description:����˰ǰ�����������
	 * @author:YanTu
	 * @date:2017��5��18������9:33:47
	 */
	private Component createSalaryPane() {
		//salaryPane = new JPanel(new GridLayout(1, 2));
		salaryPane = new JPanel(new BorderLayout());
		JLabel salaryLabel = new JLabel("˰ǰ���룺");
		salaryField = new JTextField("");
		salaryPane.add(salaryLabel,"West");
		salaryPane.add(salaryField,"Center");
		salaryPane.setBackground(Color.WHITE);
		//salaryPane.setSize(250, 320);
		return salaryPane;
	}
	
	/**
	 * @Description:������������˰�������
	 * @author:YanTu
	 * @date:2017��5��18������9:47:36
	 */
	private Component createTaxesInputPane() {
		taxesInputPane = new JPanel(new BorderLayout());
		JLabel taxesInputLabel = new JLabel("��������˰��");
		taxesInputField = new JTextField("");
		taxesInputPane.add(taxesInputLabel,"West");
		taxesInputPane.add(taxesInputField,"Center");
		taxesInputPane.setBackground(Color.WHITE);
		return taxesInputPane;
	}
	
	/**
	 * @Description:�����籣�������
	 * @author:YanTu
	 * @date:2017��5��18������9:34:03
	 */
	private Component createSocialInsurancePane() {
		JPanel pane = new JPanel(new BorderLayout());
		JLabel socialInsuranceLabel = new JLabel("�籣��");
		socialInsuranceField = new JTextField("");
		pane.add(socialInsuranceLabel,"West");
		pane.add(socialInsuranceField,"Center");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * @Description:�����������������
	 * @author:YanTu
	 * @date:2017��5��18������9:34:30
	 */
	private Component createHousingFundPane() {
		JPanel pane = new JPanel(new BorderLayout());
		JLabel housingFundLabel = new JLabel("������");
		housingFundField = new JTextField("");
		pane.add(housingFundLabel,"West");
		pane.add(housingFundField,"Center");
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * @Description:�������㰴ť�������
	 * @author:YanTu
	 * @date:2017��5��17������2:51:27
	 */
	private Component createCountButtonAreaPane() {
		JPanel pane = new JPanel(new GridLayout(0,1,3,3));
		pane.add(createCountButtonPane());
		pane.add(createPartingLine());
		pane.setBackground(Color.WHITE);
		return pane;
	}

	/**
	 * @Description:�������㰴ť���
	 * @author:YanTu
	 * @date:2017��5��18������11:19:43
	 */
	private Component createCountButtonPane() {
		JPanel pane = new JPanel();
		JButton count = new JButton("����");
		pane.add(count);
		count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String salaryText = salaryField.getText();
				String socialInsuranceText =socialInsuranceField.getText();
				String housingFundText = housingFundField.getText();
				double salary = StringOperateUtil.isNumber(salaryText)?Double.parseDouble(salaryText):0.0;
				double socialInsurance = StringOperateUtil.isNumber(socialInsuranceText)?Double.parseDouble(socialInsuranceText):0.0;
				double housingFund = StringOperateUtil.isNumber(housingFundText)?Double.parseDouble(housingFundText):0.0;
				IncomeTax incomeTax = new IncomeTax(salary,socialInsurance,housingFund);
				IncomeTax resultIncomeTax = TaxUtil.getIncomeTaxForSalary(incomeTax);
				taxesOutPutField.setText(String.valueOf(resultIncomeTax.getTaxes()));
				salaryAfterTaxField.setText(String.valueOf(resultIncomeTax.getSalaryAfterTax()));
			}
		});
		pane.setBackground(Color.WHITE);
		return pane;
	}
	/**
	 * @Description:����������
	 * @author:YanTu
	 * @date:2017��5��17������2:39:45
	 */
	private Component createOutputPane() {
		outPutPane = new JPanel(new GridLayout(0,1,3,3));
		outPutPane.add(createTaxesPanel());
		outPutPane.add(createSalaryAfterTaxPanel());
		outPutPane.add(createSalaryBeforeTaxPanel());
		outPutPane.setBorder(new EmptyBorder(15,10,0,10));//�ϣ����£���
		outPutPane.setBackground(Color.WHITE);
		return outPutPane;
	}
	/**
	 * @Description:Ӧ�۸�������˰������
	 * @author:YanTu
	 * @date:2017��5��17������5:26:57
	 */
	private Component createTaxesPanel() {
		taxesOutputPane = new JPanel(new BorderLayout());
		JLabel taxesLabel = new JLabel("Ӧ�۸�������˰Ϊ��");
		taxesOutPutField = new JTextField("");
		taxesOutputPane.add(taxesLabel,"West");
		taxesOutputPane.add(taxesOutPutField,"Center");
		taxesOutputPane.setBackground(Color.WHITE);
		return taxesOutputPane;
	}
	/**
	 * @Description:˰�����������
	 * @author:YanTu
	 * @date:2017��5��17������5:27:20
	 */
	private Component createSalaryAfterTaxPanel() {
		salaryAfterTaxPane = new JPanel(new BorderLayout());
		JLabel salaryAfterTaxLabel = new JLabel("˰������Ϊ��");
		salaryAfterTaxField = new JTextField("");
		salaryAfterTaxPane.add(salaryAfterTaxLabel,"West");
		salaryAfterTaxPane.add(salaryAfterTaxField,"Center");
		salaryAfterTaxPane.setBackground(Color.WHITE);
		return salaryAfterTaxPane;
	}
	/**
	 * @Description:˰ǰ���������
	 * @author:YanTu
	 * @date:2017��5��18������10:50:43
	 */
	private Component createSalaryBeforeTaxPanel() {
		salaryBeforeTaxPane = new JPanel(new BorderLayout());
		JLabel salaryBeforeTaxLabel = new JLabel("˰ǰ����Ϊ��");
		salaryBeforeTaxField = new JTextField("");
		salaryBeforeTaxPane.add(salaryBeforeTaxLabel,"West");
		salaryBeforeTaxPane.add(salaryBeforeTaxField,"Center");
		salaryBeforeTaxPane.setBackground(Color.WHITE);
		return salaryBeforeTaxPane;
	}
	
	/**
	 * @Description:�����ָ���
	 * @author:YanTu
	 * @date:2017��5��18������11:09:56
	 */
	private Component createPartingLine() {
		JLabel partingLine = new JLabel();
		partingLine.setText("_________________________________");
		partingLine.setBorder(new EmptyBorder(0,10,5,10));//�ϣ����£���
		return partingLine;
	}
}
