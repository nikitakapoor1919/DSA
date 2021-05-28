package DynamicProgramming;

public class BoardPath {

	// TC=0(6^N) SC=Recursion extra space
	public static int BP(int curr, int end) {
		// Positive Base Case
		if (curr == end) {
			return 1;
		}
		// Negative Base Case
		if (curr > end) {
			return 0;
		}
		int count = 0;
		// 6 Recursive Calls
		for (int dice = 1; dice <= 6; dice++) {
			count += BP(curr + dice, end);
		}
		return count;
	}

	// TC=0(N) SC=0(N)+Recursion extra space
	public static int BPTD(int curr, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		// 2. Retrieve
		if (strg[curr] != 0) {
			return strg[curr];
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += BPTD(curr + dice, end, strg);
		}
		// 1: Store
		strg[curr] = count;
		return count;
	}

	// TC=0(N) SC=0(N)
	public static int BPBU(int end) {
		int[] strg = new int[end + 6];
		strg[end] = 1;
		for (int i = end - 1; i >= 0; i--) {
			for (int j = 1; j <= 6; j++) {
				strg[i] += strg[i + j];
			}
		}
		return strg[0];

	}

	// TC=0(N) SC=0(1)
	public static int BPBUSE(int end) {
		int[] strg = new int[6];
		strg[0] = 1;
		for (int i = 1; i <= end; i++) {
			int sum = 0;
			for (int j = 0; j <= 5; j++) {
				sum += strg[j];
			}
			for (int j = 5; j > 0; j--) {
				strg[j] = strg[j - 1];
			}
			strg[0] = sum;
		}
		return strg[0];

	}

	public static void main(String[] args) {
		System.out.println(BP(0, 10));
		System.out.println(BPTD(0, 10, new int[10]));
		System.out.println(BPBU(10));
		System.out.println(BPBUSE(10));
	}

}
