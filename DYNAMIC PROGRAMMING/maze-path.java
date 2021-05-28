package DynamicProgramming;

import java.util.Arrays;

public class MazePath {

	// TC=0(2^(er+ec)) SC=Recursion extra space
	public static int MazePathRecursion(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int ch = MazePathRecursion(cr, cc + 1, er, ec);
		int cv = MazePathRecursion(cr + 1, cc, er, ec);
		return ch + cv;
	}

	// TC=0(er*ec) SC=0(er*ec)+Recursion extra space
	public static int MazePathRecursionTD(int cr, int cc, int er, int ec, int[][] strg) {
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
		int ch = MazePathRecursionTD(cr, cc + 1, er, ec, strg);
		int cv = MazePathRecursionTD(cr + 1, cc, er, ec, strg);

		// 1. Store
		strg[cr][cc] = ch + cv;
		return ch + cv;

	}

	// TC=0(er*ec) SC=0(er*ec)
	public static int MazePathBU(int er, int ec) {
		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er || col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row][col + 1] + strg[row + 1][col];
				}
			}
		}
		return strg[0][0];
	}

	// TC=0(er*ec) SC=0(ec)
	public static int MazePathBUSE(int er, int ec) {
		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);
		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}
		return strg[0];
	}

	public static void main(String[] args) {
		System.out.println(MazePathRecursion(0, 0, 2, 2));
		System.out.println(MazePathRecursionTD(0, 0, 2, 2, new int[3][3]));
		System.out.println(MazePathBU(2, 2));
		System.out.println(MazePathBUSE(2, 2));

	}

}
