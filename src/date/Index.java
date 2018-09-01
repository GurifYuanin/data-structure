package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Index {
	// 格式化日期
	// y 年 YEAR
	// M 月 MONTH 0-11
	// d 日 DATE / DAY_OF_MONTH 1-31
	// H 时 HOUR_OF_DAY 0-23
	// m 分 MINUTE 0-59
	// s 秒 SECOND 0-59
	// S 毫秒 MILLISECOND 0-999
	// 星期几 DAY_OF_WEEK 1-7
	// 一年中的第几周 WEEK_OF_YEAR
	// 一年中的第几天 DAY_OF_YEAR
	static String formatDate (String format, Calendar date) {
		return new SimpleDateFormat(format).format(date);
	}
	public static void main(String[] args) {
		// 获得基于当前时间的实例
		Calendar date = Calendar.getInstance();
		// 使用 get(Calendar.字段) 进行读取
		System.out.println(date.get(Calendar.DAY_OF_WEEK));
		// 使用 set(Calendar.字段, 值) 进行设置
		date.set(Calendar.DAY_OF_YEAR, 1);
		System.out.println(date.get(Calendar.DAY_OF_YEAR));
		// 使用 add(Calendar.字段, 值) 进行运算
		date.add(Calendar.DATE, 1);
		System.out.println(date.get(Calendar.DAY_OF_YEAR));
	}
}
