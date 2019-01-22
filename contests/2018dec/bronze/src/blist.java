// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO December 2018 (2) - Bucket List.

import java.io.*;
import java.util.*;

class blist {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("blist.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));


		int n = Integer.parseInt(f.readLine());
		int[][] data = new int[n][3];

		String[] line;
		for (int i = 0; i < n; i ++) {
			line = f.readLine().split(" ");
			for (int j = 0; j < 3; j ++) {
				data[i][j] = Integer.parseInt(line[j]);
			}
		}
		String[] result = solve(n, data);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(int n, int[][] data) {

		String[] out = new String[1];


		HashMap<Integer, Integer> bucketsAtTime = new HashMap<Integer, Integer>();
		int maxIndex = 0, current;
		int maxAmt = -1;

		// We have a hashmap of the number of buckets at each time.
		// For each cow, we increment the number of buckets needed at
		// that time by the number of buckets the cow requires.

		for (int i = 0; i < n; i ++) {
			for (int j = data[i][0]; j < data[i][1]; j ++) {

			    // If the time has not been initialized, initialize it at zero.
				if (!(bucketsAtTime.containsKey(j))) {
					bucketsAtTime.put(j, 0);
				}

				// Set the number of buckets at the current time to the number of buckets this cow needs
				// plus the number of buckets already there.
				current = data[i][2] + bucketsAtTime.get(j);
				bucketsAtTime.put(j, current);

				// Check if this time has the most buckets, if it does, save the time and amount.
				if (current > maxAmt) {
					maxIndex = j;
					maxAmt = current;
				}
			}
		}


		out[0] = maxAmt + "";


		return out;
	}
}