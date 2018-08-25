package numberTheory;

public class InverseElement {
	/*
	 * 求 a 关于 p 的逆元 x
	 * a * x % p = 1
	 * 即使 x 个 a 等于 y 个 p 再加一
	 * */
	/*
	 * 费马小定理：
	 * 如果 a 与 p 互质 / p 为质数，则
	 * a^(p - 1) % p = 1
	 * ∴ a * a^(p - 2) % p = 1
	 * ∴ a 的逆元为 a^(p - 2)
	 * */
	/*
	 * 扩展欧几里：
	 * 如果 a 与 p 互质，则可用扩展欧几里 / 辗转相除法求最大公约数
	 * */
	//  求两数最大公约数 / ax + by = 1 的解除
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
