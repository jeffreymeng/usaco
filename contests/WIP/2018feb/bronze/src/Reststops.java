//// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
//// Revised based on concepts from the USACO problem notes for this problem
//// USACO November 2012 - Typo! (typo)
//
//import java.io.*;
////import java.util.*;
//
//class Reststops {
//	public static void main(String[] args) throws IOException {
//		// Use BufferedReader rather than RandomAccessFile; it's much faster
//		BufferedReader f = new BufferedReader(new FileReader("paint.in"));
//
//
//		PrintWriter out =
//				new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
//
//		int[] coords = new int[4];
//		String line = f.readLine();
//		coords[0] = Integer.parseInt(line.split(" ")[0]);
//		coords[1] = Integer.parseInt(line.split(" ")[1]);
//		line = f.readLine();
//		coords[2] = Integer.parseInt(line.split(" ")[0]);
//		coords[3] = Integer.parseInt(line.split(" ")[1]);
//
//
//		String[] result = solve(coords[0], coords[1], coords[2], coords[3]);
//
//		//doesn't work well with large outputs.
//		for (int i = 0; i < result.length; i++) {
//			out.println(result[i]);
//		}
//		out.close();
//	}
//
//	public static String[] solve(int a, int b, int c, int d) {
//
//		int result = d - a;
//
//		if (!(d > a)) {
//			result -= c - b;
//		}
//
//		String[] out = new String[1];
//		out[0] = Integer.toString(result);
//		return out;
//
//
//
//		}
//	}
//}

// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// Revised based on concepts from the USACO problem notes for this problem
// USACO November 2012 - Typo! (typo)

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Reststops {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("reststops.in"));


		PrintWriter out =
				new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));


		String[] line = f.readLine().split(" ");
		int trailLength = Integer.parseInt(line[0]);
		int numStops = Integer.parseInt(line[1]);
		int john = Integer.parseInt(line[2]);
		int bessie = Integer.parseInt(line[3]);
		int[][] stops = new int[numStops][2];
		for (int i = 0; i < numStops; i ++) {
			line = f.readLine().split(" ");
			stops[i][0] = Integer.parseInt(line[0]);
			stops[i][1] = Integer.parseInt(line[1]);
		}


		String[] result = solve(trailLength, numStops, bessie, john, stops);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(int length, int numStops, int bessie, int john, int[][] stops) {

		//greedy

		//sort stops in descending order by tastiness
		Arrays.sort(stops, (int[] a, int[] b) -> a[1] < b[1] ? 1 : b[1] < a[1] ? -1 : 0);


		long waitTime;
		long distance;
		BigInteger result = BigInteger.ZERO;
		long location = 0;

		//loop through rest stops
		for (int i = 0; i < numStops; i ++) {

			//make sure we haven't passed the rest stop
			if (stops[i][0] < location) continue;

			//make sure we won't pass the rest stop next time
			location = stops[i][0];

			//calculate how far away this stop is from the last stop (or zero if this is the first stop)
			distance = location - (i <= 0 ? 0 : stops[i - 1][0]);

			//how far away
			waitTime = (john * distance) - (bessie * distance);
			if (waitTime <= 0) continue;
			result = result.add(BigInteger.valueOf(stops[i][1] * waitTime));

		}


		String[] out = new String[1];
		out[0] = result.toString();
		return out;
	}

}