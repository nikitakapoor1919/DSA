package DynamicProgramming;

import java.util.Arrays;

public class MazePathDiagonal {
	// TC=0(2^(er+ec)) SC=Recursion extra space
	public static int MazePathDRecursion(int cr, int cc, int er, int ec) {
			if (cr == er && cc == ec) {
				return 1;
			}
			if (cr > er || cc > ec) {
				return 0;
			}
			int ch = MazePathDRecursion(cr, cc + 1, er, ec);
			int cv = MazePathDRecursion(cr + 1, cc, er, ec);
			int cd = MazePathDRecursion(cr+1, cc+1, er, ec);
			return ch + cv + cd;
		}

	// TC=0(er*ec) SC=0(er*ec)+Recursion extra space
	public static int MazePathDRecursionTD(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		// 2: ReUse/Retrieve
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int ch = MazePathDRecursionTD(cr, cc + 1, er, ec, strg);
		int cv = MazePathDRecursionTD(cr + 1, cc, er, ec, strg);
		int cd = MazePathDRecursion(cr+1, cc+1, er, ec);

		// 1. Store
		strg[cr][cc] = ch + cv + cd;
		return ch + cv + cd;

	}

	// TC=0(er*ec) SC=0(er*ec)
	public static int MazePathDBU(int er, int ec) {
		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er || col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row][col + 1] + strg[row + 1][col] + strg[row+1][col+1];
				}
			}
		}
		return strg[0][0];
	}

	// TC=0(er*ec) SC=0(ec)
	public static int MazePathDBUSE(int er, int ec) {
		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);
		int diag = 0;
		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					strg[col] = 1;
					diag = 1;
				} else {
					int val = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = val;
				}
			}
		}
		return strg[0];
	}

	public static void main(String[] args) {
		System.out.println(MazePathDRecursion(0, 0, 2, 2));
		System.out.println(MazePathDRecursionTD(0, 0, 2, 2, new int[3][3]));
		System.out.println(MazePathDBU(2, 2));
		System.out.println(MazePathDBUSE(2, 2));

	}
}
