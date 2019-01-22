// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO December 2018 (3) - Back and Forth.

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class backforth {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("backforth.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));



		int[][] data = new int[2][10];

		String[] line;
		for (int i = 0; i < 2; i ++) {
			line = f.readLine().split(" ");
			for (int j = 0; j < 10; j ++) {
				data[i][j] = Integer.parseInt(line[j]);
			}
		}
		String[] result = solve(data);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(int[][] data) {

		String[] out = new String[1];

//		Set<Integer> buckets = new HashSet<Integer>();
//
//		for (int i = 0; i < 10; i ++) {
//			buckets.add(data[0][i]);
//			buckets.add(data[1][i]);
//		}
		int amtA = 1000, amtB = 1000;
		Set<Integer> results = new HashSet<Integer>();
		ArrayList<Integer> bucketsA = new ArrayList<Integer>();
		for (int i = 0; i < data[0].length; i ++) {
			bucketsA.add(data[0][i]);
		}
		ArrayList<Integer> bucketsB = new ArrayList<Integer>();
		for (int i = 0; i < data[0].length; i ++) {
			bucketsB.add(data[1][i]);
		}
		ArrayList<Integer> day2BucketsA, day2BucketsB;
		ArrayList<Integer> day3BucketsA, day3BucketsB;
		ArrayList<Integer> day4BucketsA, day4BucketsB;
		int day2AmtA, day2AmtB;
		int day3AmtA, day3AmtB;
		int day4AmtA, day4AmtB;
int[] debug = new int[4];
		for (int i = 0; i < bucketsA.size(); i ++) {
			day2AmtA = amtA;
			day2AmtB = amtB;
			day2BucketsB = (ArrayList) bucketsB.clone();
			day2BucketsA = (ArrayList) bucketsA.clone();

			day2AmtA -= day2BucketsA.get(i);
			day2AmtB += day2BucketsA.get(i);
			day2BucketsB.add(day2BucketsA.get(i));
			debug[0] = day2BucketsA.get(i);
			day2BucketsA.remove(i);

			for (int j = 0; j < day2BucketsB.size(); j ++) {
				day3AmtA = day2AmtA;
				day3AmtB = day2AmtB;
				day3BucketsB = (ArrayList) day2BucketsB.clone();
				day3BucketsA = (ArrayList) day2BucketsA.clone();

				day3AmtA += day3BucketsB.get(j);
				day3AmtB -= day3BucketsB.get(j);
				day3BucketsA.add(day3BucketsB.get(j));
				debug[1] = day3BucketsB.get(i);
				day3BucketsB.remove(j);

				for (int k = 0; k < day3BucketsA.size(); k ++) {
					day4AmtA = day3AmtA;
					day4AmtB = day3AmtB;
					day4BucketsB = (ArrayList) day3BucketsB.clone();
					day4BucketsA = (ArrayList) day3BucketsA.clone();

					day4AmtA -= day4BucketsA.get(k);
					day4AmtB += day4BucketsA.get(k);
					day4BucketsB.add(day4BucketsA.get(k));
					debug[2] = day4BucketsA.get(k);
					day4BucketsA.remove(k);

					for (int l = 0; l < day4BucketsB.size(); l ++) {
						results.add(day4AmtA + day4BucketsB.get(l));
						debug[3] = day4BucketsB.get(l);
					}
				}
			}
		}
		System.out.println("RESULTS:");
		for (Iterator<Integer> it = results.iterator(); it.hasNext(); ) {
			int f = it.next();
			System.out.print(f + " ");
		}
		out[0] = results.size() + "";


		return out;
	}
}