package DynamicProgramming;

import java.util.Arrays;

public class MCM {
	// (aXb)*(bXc)
	// M1(M2.M3)=M1(M2.M3)
	// Multiplication is associative res same but operation req different
	// (4X2)*(2X3) = 4X2X3 multiplication operations
	// [4,2,3,5,1]=> 4X2,2X3,3X5,5X1(4 matrices)
	// Base Case: [4] (si,k)=(0,1) (k,ei)=(1,2)
	// Self Work: (M1.M2).(M3.M4)
	// [(4x2)*(2x3)].[(3X5)*(5X1)]
	// fp=4x2x3=24 sp=3x5x1=15
	// sw=(4x3)*(3x1)=4X3x1=12 i.e arr[si]*arr[k]*arr[ei]
	// fp+sp+sw= 24+15+12=51

	// TC=2^N SC=Recursion extra space
	public static int MCMR(int[] arr, int si, int ei) {
		// max operation required for multiplication will be 0
		if (si + 1 == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		// splits
		for (int k = si + 1; k <= ei - 1; k++) {
			int f1 = MCMR(arr, si, k);
			int s2 = MCMR(arr, k, ei);
			// Self Work:
			int sw = arr[si] * arr[k] * arr[ei];
			int ans = f1 + s2 + sw;
			if (ans < min) {
				min = ans;
			}
		}
		return min;
	}

	// TC=0(N*N) SC=0(N*N)+Recursion extra space
	// Dimension of Array? 2d beacuse 2 arg are changing
	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {
		if (si + 1 == ei) {
			return 0;
		}
		// Reuse
		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		// splits
		for (int k = si + 1; k <= ei - 1; k++) {
			int f1 = MCMTD(arr, si, k,strg);
			int s2 = MCMTD(arr, k, ei,strg);
			// Self Work:
			int sw = arr[si] * arr[k] * arr[ei];
			int ans = f1 + s2 + sw;
			if (ans < min) {
				min = ans;
			}
		}
		// Store
		strg[si][ei] = min;
		return min;
	}

	// TC=0(N*N) SC=0(N*N)
	// fill 2d array diagonally
	public static int MCMBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[arr.length][arr.length];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				if (si + 1 == ei) {
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					// splits
					for (int k = si + 1; k <= ei - 1; k++) {
						int f1 = strg[si][k];
						int s2 = strg[k][ei];
						// Self Work:
						int sw = arr[si] * arr[k] * arr[ei];
						int ans = f1 + s2 + sw;
						if (ans < min) {
							min = ans;
						}
					}
					strg[si][ei] = min;
				}
			}
		}
		return strg[0][n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 5, 1 };
		System.out.println(MCMR(arr, 0, arr.length - 1));
		int[][] strg = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(strg[i], -1);
		}
		System.out.println(MCMTD(arr, 0, arr.length - 1, strg));
		System.out.println(MCMBU(arr));
	}

}
