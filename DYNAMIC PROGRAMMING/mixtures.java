package DynamicProgramming;

import java.util.Arrays;

public class Mixtures {

	// [40,60,20,50]=>(40)(60,20,50) (40,60)(20,50) (40,60,20)(50)
	// (40,60)(20,50)=>(si,k)(k,ei)=> (0,1)(2,3)

	// TC=0(2^N) SC=Recursion extra space
	public static int MR(int[] arr, int si, int ei) {
		if (si == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fp = MR(arr, si, k);
			int sp = MR(arr, k + 1, ei);
			int sw = color(arr, si, k) * color(arr, k + 1, ei);
			int ans = fp + sp + sw;
			if (ans < min) {
				min = ans;
			}
		}
		return min;
	}

	// TC=0(N*N) SC=0(N*N)+Recursion extra space
	public static int MTD(int[] arr, int si, int ei, int[][] strg) {
		if (si == ei) {
			return 0;
		}
		// Reuse
		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fp = MTD(arr, si, k,strg);
			int sp = MTD(arr, k + 1, ei,strg);
			int sw = color(arr, si, k) * color(arr, k + 1, ei);
			int ans = fp + sp + sw;
			if (ans < min) {
				min = ans;
			}
		}
		// Store
		strg[si][ei] = min;
		return min;
	}

	// TC=0(N*N) SC=0(N*N)
	public static int MBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				if (si == ei) {
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = si; k <= ei - 1; k++) {
						int fp = strg[si][k];
						int sp = strg[k+1][ei];
						int sw = color(arr, si, k) * color(arr, k + 1, ei);
						int ans = fp + sp + sw;
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

	private static int color(int[] arr, int si, int ei) {
		int sum = 0;
		for (int k = si; k <= ei; k++) {
			sum += arr[k];
		}
		return sum % 100;
	}

	public static void main(String[] args) {
		int[] arr = { 40,60,20 };
		System.out.println(MR(arr, 0, arr.length - 1));
		int[][] strg = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(strg[i], -1);
		}
		System.out.println(MTD(arr, 0, arr.length - 1, strg));
		System.out.println(MBU(arr));

	}

}
