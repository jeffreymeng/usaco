// Copyright (c) 2019 Jeffrey Meng - Licensed under the MIT License
// USACO December 2012 Silver #2 - Wifi Setup (wifi)

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


class wifi {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("wifi.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wifi.out")));

		// INPUT
		// Read first line and convert into integer array
		int[] temp = Arrays.stream(f.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

		int N = temp[0], A = temp[1], B = temp[2];
		int[] cows = new int[N];
        for (int i = 0; i < N; i ++) {
            cows[i] = Integer.parseInt(f.readLine());
        }

		// SOLUTION
		// The array must be sorted so we can compare adjacent cows.
		Arrays.sort(cows);

		double[] dp = new double[N];
		dp[0] = A; // Base case: the cost of providing wifi to just one cow is always just A.

		// We either
		for (int i = 1; i < N; i ++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j <= i; j ++) {

				dp[i] = Math.min(dp[i], (j > 0 ? dp[j - 1] : 0) + A + (((cows[i] - cows[j])*B)/2.0));
			}

		}

		// OUTPUT
//        System.out.println("DPA");
//		for (int i = 0; i < dp.length; i ++) {
//			System.out.print(dp[i] + " ");
//			System.out.println();
//		}
		System.out.println(N + " " + A + " " + B);

		// Remove any trailing zeros (e.g. 6.0 -> 6; 4.5 -> 4.5)

		if (dp[dp.length - 1] == (int) dp[dp.length - 1]) {
			out.println((int) dp[dp.length - 1]);
		} else {
			out.println(dp[dp.length - 1]);
		}


		out.close();
	}

}
