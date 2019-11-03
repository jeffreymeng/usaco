// Copyright (c) 2019 Jeffrey Meng - Licensed under the MIT License
// 2015 December Silver #2 - Cow Hopscotch (Silver) (hopscotch)

import java.io.*;
import java.util.*;

class hopscotch {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("hopscotch.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));

		String[] line = f.readLine().split(" ");
		int r = Integer.parseInt(line[0]);
		int c = Integer.parseInt(line[1]);
		int k = Integer.parseInt(line[2]);


		int[][] squares = new int[r][c];
		for (int i = 0; i < r; i ++) {
			line = f.readLine().split(" ");

			for (int j = 0; j < c; j ++) {
				squares[i][j] = Integer.parseInt(line[j]);
			}
		}


		String result = solve(r, c, k, squares);

		out.println(result);

		out.close();
	}

	public static String solve(int r, int c, int k, int[][] squares) {
		long[][] dp = new long[r][c];
		dp[0][0] = 1;


		// build up a dp array
		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				// Compute the number of ways to get to this square
				for (int l = 0; l < i; l ++) {
					for (int m = 0; m < j; m ++) {
						if (squares[l][m] != squares[i][j]) {
							dp[i][j] += dp[l][m] % 1000000007;
						}
					}
				}
			}
		}

		return dp[r - 1][c - 1] % 1000000007 + "";
	}
}