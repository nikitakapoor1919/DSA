package DynamicProgramming;

public class Fibonacci {

	// TC=O(2^N) SC=Recursion extra space
	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fbm1 = fib(n - 1);
		int fbm2 = fib(n - 2);

		int fb = fbm1 + fbm2;
		return fb;
	}

	// TC=O(N) SC=O(N)+Recursion extra space
	public static int fibTD(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}
		// Step 2: Retrieve
		if (strg[n] != 0) {
			return strg[n];
		}
		int fbm1 = fibTD(n - 1, strg);
		int fbm2 = fibTD(n - 2, strg);

		int fb = fbm1 + fbm2;
		// Step1: Store
		strg[n] = fb;
		return fb;
	}

	// TC=O(N) SC=O(N)
	public static int fibBU(int n) {
		if (n == 0) {
			return 0;
		}
		// n+1 size array bcoz we want nth index to be present
		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = strg[i - 1] + strg[i - 2];
			strg[i] = sum;
		}
		return strg[n];

	}

	// TC=O(N) SC=O(1)
	public static int fibBUSE(int n) {
		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;
		if (n == 0) {
			return strg[0];
		}
		for (int i = 1; i <= n - 1; i++) {
			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}
		return strg[1];

	}

	public static void main(String[] args) {
		System.out.println(fib(2));
		System.out.println(fibTD(2, new int[3]));
		System.out.println(fibBU(2));
		System.out.println(fibBUSE(2));
	}

}
