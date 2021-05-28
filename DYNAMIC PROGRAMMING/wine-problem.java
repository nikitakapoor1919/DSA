package DynamicProgramming;

public class WineProblem {

	// [2,1,3,6]->[2,1,3]->[1,3]->[1]
	// (0,3)->(0,2)->(1,2)->(1,1)[Base Case]
	// [2,1,3,6](si=0,ei=3,year=1)-> Left(si=1,ei=3,year=2)[Sold si=0] ,
	// Right(si=0,ei=2,year=2)[Sold si=4]
	// [3,6](si=2,ei=3,year=3)-> Left(si=3,ei=3,year=4)[Sold si=2] ,
	// Right(si=2,ei=2,year=4)[Sold si=4]

	// TC=0(2^N) SC=Recursion extra space
	public static int WPRecursion(int[] arr, int year, int si, int ei) {
		if (si == ei) {
			return arr[si] * year;
		}
		// Smaller Problem
		int start = WPRecursion(arr, year + 1, si + 1, ei) + arr[si] * year;
		int end = WPRecursion(arr, year + 1, si, ei - 1) + arr[ei] * year;

		// Self Work
		int ans = Math.max(start, end);

		return ans;
	}

	// [2,1,3,6](si=0,ei=3,year=1)-> n=4,si=0,ei=3 ---> left:4 (3-0+1)[ei-si+1] ,
	// sell:0 [4-4=0] [n-left] , year=sell+1
	// year=sell+1-> (n-left)+1 -> (n-(ei-si+1))+1

	// TC=0(2^N) SC=Recursion extra space
	public static int WPRecursion(int[] arr, int si, int ei) {
		int n = arr.length;
		int year = (n - (ei - si + 1)) + 1;
		if (si == ei) {
			return arr[si] * year;
		}
		// Smaller Problem
		int start = WPRecursion(arr, si + 1, ei) + arr[si] * year;
		int end = WPRecursion(arr, si, ei - 1) + arr[ei] * year;

		// Self Work
		int ans = Math.max(start, end);

		return ans;
	}

	// TC=0(N*N) SC=0(N*N)+Recursion extra space
	public static int WPTD(int[] arr, int si, int ei, int[][] strg) {
		int n = arr.length;
		int year = (n - (ei - si + 1)) + 1;
		if (si == ei) {
			return arr[si] * year;
		}
		// 2. reuse
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int start = WPTD(arr, si + 1, ei, strg) + arr[si] * year;
		int end = WPTD(arr, si, ei - 1, strg) + arr[ei] * year;

		int ans = Math.max(start, end);

		// 1. store
		strg[si][ei] = ans;

		return ans;
	}

	// TC=0(N*N/2)->0(N*N) SC=0(N*N)
	public static int WPBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				int year = (n - (ei - si + 1)) + 1;
				if (si == ei) {
					strg[si][ei] = arr[si] * year;
				} else {
					int start = strg[si + 1][ei] + arr[si] * year;
					int end = strg[si][ei - 1] + arr[ei] * year;

					strg[si][ei] = Math.max(start, end);

				}
			}
		}
//		for(int i=0;i<strg.length;i++) {
//			for(int j=0;j<strg[0].length;j++) {
//				System.out.print(strg[i][j]+"\t");
//			}
//			System.out.println();
//		}
		return strg[0][n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 1, 4 };
		System.out.println(WPRecursion(arr, 1, 0, arr.length - 1));
		System.out.println(WPRecursion(arr, 0, arr.length - 1));
		System.out.println(WPTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(WPBU(arr));

	}

}
