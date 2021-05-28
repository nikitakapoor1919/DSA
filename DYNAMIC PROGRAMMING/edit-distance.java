package DynamicProgramming;

public class EditDistances {

	// TC=0(2^(m+n)) SC=Recursion extra space
	public static int EDRecursion(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans;
		if (ch1 == ch2) {
			ans = EDRecursion(ros1, ros2);
		} else {
			int i = EDRecursion(ros1, s2);
			int d = EDRecursion(s1, ros2);
			int r = EDRecursion(ros1, ros2);
			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		return ans;
	}

	// TC=0(2^(m+n)) SC=Recursion extra space
	public static int EDRecursion(String s1, String s2, int v1, int v2) {

		if (s1.length() == v1 || s2.length() == v2) {
			return 0;
		}
		char ch1 = s1.charAt(v1);
		char ch2 = s2.charAt(v2);

		int ans;
		if (ch1 == ch2) {
			ans = EDRecursion(s1, s2, v1 + 1, v2 + 1);
		} else {
			int i = EDRecursion(s1, s2, v1 + 1, v2);
			int d = EDRecursion(s1, s2, v1, v2 + 1);
			int r = EDRecursion(s1, s2, v1 + 1, v2 + 1);
			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		return ans;
	}

	// TC=0(m*n) SC=0(m*n)+Recursion extra space
	public static int EDTD(String s1, String s2, int v1, int v2, int[][] strg) {

		if (s1.length() == v1 || s2.length() == v2) {
			return 0;
		}
		char ch1 = s1.charAt(v1);
		char ch2 = s2.charAt(v2);

		if (strg[v1][v2] != 0) {
			return strg[v1][v2];
		}
		int ans;
		if (ch1 == ch2) {
			ans = EDTD(s1, s2, v1 + 1, v2 + 1, strg);
		} else {
			int i = EDTD(s1, s2, v1 + 1, v2, strg);
			int d = EDTD(s1, s2, v1, v2 + 1, strg);
			int r = EDTD(s1, s2, v1 + 1, v2 + 1, strg);
			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		strg[v1][v2] = ans;
		return ans;
	}

	// TC=0(m*n) SC=0(m*n)
	public static int EDBU(String s1, String s2) {

		int[][] strg=new int[s1.length()+1][s2.length()+1];
		
		for(int row=s1.length();row>=0;row--) {
			for(int col=s2.length();col>=0;col--) {
				if(row==s1.length()) {
					strg[row][col]=s2.length()-col;
				}
				else if(col==s2.length()) {
					strg[row][col]=s1.length()-row;
				}
				else {
					char ch1 = s1.charAt(row);
					char ch2 = s2.charAt(col);

					int ans;
					if (ch1 == ch2) {
						ans = strg[row+1][col+1];
					} else {
						int i = strg[row+1][col];
						int d = strg[row][col+1];
						int r = strg[row+1][col+1];
						ans = Math.min(i, Math.min(d, r)) + 1;
					}
					strg[row][col] = ans;
				}
			}
		}
		return strg[0][0];
	}

	public static void main(String[] args) {
		String m = "abcd";
		String n = "agcfd";
		System.out.println(EDRecursion(m, n));
		System.out.println(EDRecursion(m, n, 0, 0));
		System.out.println(EDTD(m, n, 0, 0, new int[m.length()][n.length()]));
		System.out.println(EDBU(m, n));

	}

}
