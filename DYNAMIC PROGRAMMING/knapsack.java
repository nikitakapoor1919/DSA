package DynamicProgramming;

public class KnapSack {

	public static int KnapsackRecursion(int[] wt, int[] price, int cap, int vi) {
		if (vi == wt.length || cap == 0) {
			return 0;
		}
		// exclude
		int e = KnapsackRecursion(wt, price, cap, vi + 1);

		int i = 0;
		// include
		if (cap >= wt[vi]) {
			i = KnapsackRecursion(wt, price, cap - wt[vi], vi + 1) + price[vi];
		}
		int ans = Math.max(i, e);

		return ans;
	}
	
	public static int KnapsackRecursionTD(int[] wt, int[] price, int cap, int vi,int[][] strg) {
		if (vi == wt.length || cap == 0) {
			return 0;
		}
		if(strg[vi][cap]!=0) {
			return strg[vi][cap];
		}
		// exclude
		int e = KnapsackRecursionTD(wt, price, cap, vi + 1,strg);

		int i = 0;
		// include
		if (cap >= wt[vi]) {
			i = KnapsackRecursionTD(wt, price, cap - wt[vi], vi + 1,strg) + price[vi];
		}
		int ans = Math.max(i, e);
		strg[vi][cap]=ans;
		return ans;
	}
	
	public static int KnapsackRecursionBU(int[] wt, int[] price, int cap) {
		int [][] strg=new int[wt.length+1][cap+1];
		
		for(int row=wt.length-1;row>=0;row--) {
			for(int col=1;col<=cap;col++) {
				int e = strg[row+1][col];

				int i = 0;
				// include
				if (col >= wt[row]) {
					i = strg[row+1][col-wt[row]]+ price[row];
				}
				int ans = Math.max(i, e);
				strg[row][col]=ans;
			}
		}
//		for(int i=0;i<strg.length;i++) {
//			for(int j=0;j<strg[0].length;j++) {
//				System.out.print(strg[i][j]+"\t");
//			}
//			System.out.println();
//		}
		return strg[0][cap];
	}

	public static void main(String[] args) {

		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
		int cap=7;
		System.out.println(KnapsackRecursion(wt, price, cap, 0));
		System.out.println(KnapsackRecursionTD(wt, price, cap, 0, new int[wt.length][cap+1]));
		System.out.println(KnapsackRecursionBU(wt, price, cap));

	}

}
