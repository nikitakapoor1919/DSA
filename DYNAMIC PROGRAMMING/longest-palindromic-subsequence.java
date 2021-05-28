package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubSequence {
	
	// TC=0(2^N) SC=Recursion Extra Space
	public static int LPSR(String str, int si, int ei) {
		// Negative Base Case
		if (si > ei) {
			return 0;
		}
		// Positive Base Case
		if (si == ei) {
			return 1;
		}
		char ch1 = str.charAt(si);
		char ch2 = str.charAt(ei);
		int ans;
		if (ch1 == ch2) {
			// 2 needs to be added as palindrome is would be of length 2
			ans = LPSR(str, si + 1, ei - 1) + 2;
		} else {
			int o1 = LPSR(str, si, ei - 1);
			int o2 = LPSR(str, si + 1, ei);
			ans = Math.max(o1, o2);
		}
		return ans;
	}

	// TC=0(N*N) SC=0(N*N)+Recursion Extra Space
	public static int LPSTD(String str, int si, int ei, int[][] strg) {
		// Negative Base Case
		if (si > ei) {
			return 0;
		}
		// Positive Base Case
		if (si == ei) {
			return 1;
		}
		// Reuse
		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}
		char ch1 = str.charAt(si);
		char ch2 = str.charAt(ei);
		int ans;
		if (ch1 == ch2) {
			// 2 needs to be added as palindrome is would be of length 2
			ans = LPSR(str, si + 1, ei - 1) + 2;
		} else {
			int o1 = LPSR(str, si, ei - 1);
			int o2 = LPSR(str, si + 1, ei);
			ans = Math.max(o1, o2);
		}
		// Store
		strg[si][ei] = ans;
		return ans;
	}

	// TC=0(N*N) SC=0(N*N)
	public static int LPSBU(String str) {
		int n = str.length();
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				// Negative Base Case
				if (si > ei) {
					strg[si][ei] = 0;
				}
				// Positive Base Case
				if (si == ei) {
					strg[si][ei] = 1;
				} else {
					char ch1 = str.charAt(si);
					char ch2 = str.charAt(ei);
					int ans;
					if (ch1 == ch2) {
						// 2 needs to be added as palindrome is would be of length 2
						ans = LPSR(str, si + 1, ei - 1) + 2;
					} else {
						int o1 = LPSR(str, si, ei - 1);
						int o2 = LPSR(str, si + 1, ei);
						ans = Math.max(o1, o2);
					}
					strg[si][ei] = ans;
				}
			}
		}
		return strg[0][n - 1];
	}

	public static void main(String[] args) {
		String s = "acdcga";
		System.out.println(LPSR(s, 0, s.length() - 1));
		int[][] strg = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			Arrays.fill(strg[i], -1);
		}
		System.out.println(LPSTD(s, 0, s.length() - 1, strg));
		System.out.println(LPSBU(s));
	}

}
