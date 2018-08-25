package numberTheory;

public class InverseElement {
	/*
	 * �� a ���� p ����Ԫ x
	 * a * x % p = 1
	 * ��ʹ x �� a ���� y �� p �ټ�һ
	 * */
	/*
	 * ����С����
	 * ��� a �� p ���� / p Ϊ��������
	 * a^(p - 1) % p = 1
	 * �� a * a^(p - 2) % p = 1
	 * �� a ����ԪΪ a^(p - 2)
	 * */
	/*
	 * ��չŷ���
	 * ��� a �� p ���ʣ��������չŷ���� / շת����������Լ��
	 * */
	//  ���������Լ�� / ax + by = 1 �Ľ��
	static int gcdExt(int a, int b, int[] x, int[] y) {
		if (b == 0) {
			x[0] = 1;
			y[0] = 0;
			return a;
		} else {
			int r = gcdExt(b, a % b, x, y);
			int t = x[0];
			x[0] = y[0];
			y[0] = t - a / b * y[0];
			return r;
		}
	}
	public static void main(String[] args) {
		System.out.println(gcdExt(12, 6, new int[1], new int[1]));
	}
}
