package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Index {
	// ��ʽ������
	// y �� YEAR
	// M �� MONTH 0-11
	// d �� DATE / DAY_OF_MONTH 1-31
	// H ʱ HOUR_OF_DAY 0-23
	// m �� MINUTE 0-59
	// s �� SECOND 0-59
	// S ���� MILLISECOND 0-999
	// ���ڼ� DAY_OF_WEEK 1-7
	// һ���еĵڼ��� WEEK_OF_YEAR
	// һ���еĵڼ��� DAY_OF_YEAR
	static String formatDate (String format, Calendar date) {
		return new SimpleDateFormat(format).format(date);
	}
	public static void main(String[] args) {
		// ��û��ڵ�ǰʱ���ʵ��
		Calendar date = Calendar.getInstance();
		// ʹ�� get(Calendar.�ֶ�) ���ж�ȡ
		System.out.println(date.get(Calendar.DAY_OF_WEEK));
		// ʹ�� set(Calendar.�ֶ�, ֵ) ��������
		date.set(Calendar.DAY_OF_YEAR, 1);
		System.out.println(date.get(Calendar.DAY_OF_YEAR));
		// ʹ�� add(Calendar.�ֶ�, ֵ) ��������
		date.add(Calendar.DATE, 1);
		System.out.println(date.get(Calendar.DAY_OF_YEAR));
	}
}
