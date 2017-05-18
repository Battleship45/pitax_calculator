package util;
/**
 * �ַ�������������
 * @Description:TODO
 * @author YanTu
 * @date:2017��5��17������5:07:03
 */
public class StringOperateUtil {
	/**
	 * �ж��ַ����Ƿ����
	 * @Description:TODO
	 * @author:YanTu
	 * @date:2017��5��17������5:07:58
	 */
	public static boolean isExist(String str) {
		if(str != null && !str.equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * �ж��ַ����Ƿ񲻴���
	 * @Description:TODO
	 * @author:YanTu
	 * @date:2017��5��17������5:07:38
	 */
	public static boolean isNotExist(String str){
		if(str == null || "".equals(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * �ж��ַ������Ƿ�Ϊ�����֣�������
	 * @Description:TODO
	 * @author:YanTu
	 * @date:2017��5��17������5:08:10
	 */
	public static boolean isPureNumber(String inputStr) {
		String regStr = "^[+-]?[1-9][0-9]*$|^0$";
		return inputStr.matches(regStr);
	}
	
	/**
	 * �ж��ַ����Ƿ�Ϊ���֣�������������
	 * @Description:TODO
	 * @author:YanTu
	 * @date:2017��5��18������11:34:36
	 */
	public static boolean isNumber(String inputStr){
		String regStr = "^[+-]?(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
		return inputStr.matches(regStr);
	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("-0.23"));
		System.out.println(isNumber("-23"));
		System.out.println(isNumber("23"));
		System.out.println(isNumber("23.5343"));
	}
}
