package numberTheory;

/* *
 * 数字基本操作
 * Integer.parseInt(string, radix)：将 radix 进制的字符串 string 转化为十进制的 int
 * 	radix 默认为 10
 * 	string 只能为 String 不能为 char
 * Integer.toBinaryString(int)：int 转化为二进制字符串
 * 		  .toOctalString(int)：int 转化为八进制字符串
 * 		  .toHexString(int)：int 转化为十六进制字符串
 * 
 * (char)数字：查找 ASCII 表，获得数字对应位置的字符
 * (int)字符：查找 ASCII 表，获得字符对应位置的数字
 * 	数字与字符之间的运算，先将字符转化为对应位置的数字，运算结果为数字
 * 	因此，char -> int 需要 -48
 * 	比如 int n = '1' - 48
 * 	'1' 查 ASCII 表转化后为 49，减去 48 得到数字 1
 * */
public class Index {
	// 获得个位数
	static int getLowPosition (int num) {
		return num % 10;
	}
	
	// 获得最高位
	static int getHightPosition (int num) {
		while (num >= 10) {
			num /= 10;
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(getLowPosition(987));
		System.out.println(getHightPosition(987));
	}
}
