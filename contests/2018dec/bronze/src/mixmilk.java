// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO December 2018 (1) - Mixing Milk.

import java.io.*;
import java.util.*;

class mixmilk {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

		long[] buckets = new long[3];
		long[] bucketCapacities = new long[3];

        // Collect the data
		String[] line = f.readLine().split(" ");
		bucketCapacities[0] = Long.parseLong(line[0]);
		buckets[0] = Long.parseLong(line[1]);
		line = f.readLine().split(" ");
		bucketCapacities[1] = Long.parseLong(line[0]);
		buckets[1] = Long.parseLong(line[1]);
		line = f.readLine().split(" ");
		bucketCapacities[2] = Long.parseLong(line[0]);
		buckets[2] = Long.parseLong(line[1]);

		String[] result = solve(buckets, bucketCapacities);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(long[] buckets, long[] bucketCapacities) {

		String[] out = new String[3];
		int bucket, next;
		long amt;

		for (int i = 0; i < 100; i ++) {

			bucket = i % 3;

			//The next bucket is the bucket numbered one higher then the current bucket,
			//unless it's the third bucket, in which case we loop around.
			next = bucket < 2 ? bucket + 1 : 0;

			//the smaller of two ints, the amount in the current bucket or the
			//remaining capacity in the bucket to pour into.
			amt = Math.min(buckets[bucket], bucketCapacities[next] - buckets[next]);
			buckets[bucket] -= amt;
			buckets[next] += amt;

		}


		for (int i = 0; i < 3; i ++) {
			out[i] = buckets[i] + "";
		}


		return out;
	}
}