package numberTheory;

public class Lucas {
	/*
	 * 求 C(n, m) % p ， p 是素数
	 * C(n, m) % p => (C(n / p, m / p) * C(n % p, m % p)) % p
	 * 附：排列组合重要公式
	 * C(n, m) = n! / (m! * (n - m))!
	 * 0! = 1	C(n, 0) = 1
	 * */
	int[] H; // 存放 k 的阶层
	void init(int k) {
		H = new int[k + 1];
		H[0] = H[1] = 1;
		for (int i = 2; i <= k; i++) {
			H[i] = H[i - 1] * i;
		}
	}
	int getResult(int n, int m, int p) {
		if (m == 0) {
			return 1;
		} else {
			return (getResult(n / p, m / p, p) * C(n % p, m % p, p)) % p;
		}
	}
	int C(int n, int m, int p) {
		if (m == 0 || n == 0 || m == n) {
			return 1;
		}
		return (H[n] / (H[m] * H[n - m])) % p;
	}

	public static void main(String[] args) {
		Lucas instance = new Lucas();
		instance.init(100);
		System.out.println(instance.getResult(6, 5, 100));
	}
}
