package numberTheory;

/* *
 * ���ֻ�������
 * Integer.parseInt(string, radix)���� radix ���Ƶ��ַ��� string ת��Ϊʮ���Ƶ� int
 * 	radix Ĭ��Ϊ 10
 * 	string ֻ��Ϊ String ����Ϊ char
 * Integer.toBinaryString(int)��int ת��Ϊ�������ַ���
 * 		  .toOctalString(int)��int ת��Ϊ�˽����ַ���
 * 		  .toHexString(int)��int ת��Ϊʮ�������ַ���
 * 
 * (char)���֣����� ASCII ��������ֶ�Ӧλ�õ��ַ�
 * (int)�ַ������� ASCII ������ַ���Ӧλ�õ�����
 * 	�������ַ�֮������㣬�Ƚ��ַ�ת��Ϊ��Ӧλ�õ����֣�������Ϊ����
 * 	��ˣ�char -> int ��Ҫ -48
 * 	���� int n = '1' - 48
 * 	'1' �� ASCII ��ת����Ϊ 49����ȥ 48 �õ����� 1
 * */
public class Index {
	// ��ø�λ��
	static int getLowPosition (int num) {
		return num % 10;
	}
	
	// ������λ
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
