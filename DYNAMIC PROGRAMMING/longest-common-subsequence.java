package DynamicProgramming;

public class LongestCommonSubsequence {

	public static int LCSRecursion(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int res = 0;

		if (ch1 == ch2) {
			res = LCSRecursion(ros1, ros2) + 1;
		} else {
			int o1 = LCSRecursion(s1, ros2);
			int o2 = LCSRecursion(ros1, s2);
			res = Math.max(o1, o2);
		}
		return res;
	}

	// TC=0(2^(m+n)) SC=Recursion extra space
	public static int LCSRecursionVI(String s1, String s2, int v1, int v2) {

		if (s1.length() == v1 || s2.length() == v2) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		int res = 0;

		if (ch1 == ch2) {
			res = LCSRecursionVI(s1, s2, v1 + 1, v2 + 1) + 1;
		} else {
			int o1 = LCSRecursionVI(s1, s2, v1, v2 + 1);
			int o2 = LCSRecursionVI(s1, s2, v1 + 1, v2);
			res = Math.max(o1, o2);
		}
		return res;
	}

	// TC=0(m*n) SC=0(m*n)+Recursion extra space
	public static int LCSRecursionTD(String s1, String s2, int v1, int v2, int[][] strg) {

		if (s1.length() == v1 || s2.length() == v2) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		int res = 0;
		// 2. Reuse
		if (strg[v1][v2] != -1) {
			return strg[v1][v2];
		}
		if (ch1 == ch2) {
			res = LCSRecursionTD(s1, s2, v1 + 1, v2 + 1, strg) + 1;
		} else {
			int o1 = LCSRecursionTD(s1, s2, v1, v2 + 1, strg);
			int o2 = LCSRecursionTD(s1, s2, v1 + 1, v2, strg);
			res = Math.max(o1, o2);
		}
		// 1. Store
		strg[v1][v2] = res;
		return res;
	}

	// TC=0(m*n) SC=0(m*n)+Recursion extra space
	public static int LCSBU(String s1, String s2) {
		int[][] strg=new int[s1.length()+1][s2.length()+1];
		
		for(int row=s1.length()-1;row>=0;row--) {
			for(int col=s2.length()-1;col>=0;col--) {
				if(s1.charAt(row)==s2.charAt(col)) {
					strg[row][col]=strg[row+1][col+1]+1;
				}
				else {
					strg[row][col]=Math.max(strg[row][col+1],strg[row+1][col]);
				}
			}
		}
		return strg[0][0];
	}
	

	public static void main(String[] args) {
		String m = "acd";
		String n = "agcfd";
		System.out.println(LCSRecursion(m, n));
		System.out.println(LCSRecursionVI(m, n, 0, 0));
		int[][] strg=new int[m.length()][n.length()];
		for(int i=0;i<strg.length;i++) {
			for(int j=0;j<strg[0].length;j++) {
				strg[i][j]=-1;
			}
		}
		System.out.println(LCSRecursionTD(m, n, 0, 0, strg));
		System.out.println(LCSBU(m, n));

	}

}
