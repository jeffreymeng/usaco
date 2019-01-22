// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// 2018 December Silver #1 - Convention (convention)

import java.io.*;
import java.util.*;

class convention {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("convention.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));

		String[] line = f.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int c = Integer.parseInt(line[2]);


		line = f.readLine().split(" ");
		ArrayList<Integer> cows = new ArrayList<Integer>();
		for (int i = 0; i < line.length; i ++) {
			cows.add(Integer.parseInt(line[i]));
		}

		String input = f.readLine();

		String[] result = solve(n, m, c, cows);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(int n, int busses, int capacity, ArrayList<Integer> cows) {
		//replace the following code.
		String[] out = new String[1];
		int maxWait = 0;
		int earliestNotSent = cows.get(0);
		int bussesSent = 0;
		int waiting = 0;
		int cow;
		sort(cows);
		ArrayList<Integer> assignments = new ArrayList<Integer>();

		while(cows.size() > 0) {
			assignments.add(cows.get(0));
			cows.remove(0);

		}

		//now optimize the solution.
		while(assignments.size() < busses * capacity) {
			//find the place where adding a cow the same time as the last cow in that bus would be most beneficial.
			int startSize = assignments.size();
			for (int i = 1; i < startSize; i ++) {
				assignments.add(i, assignments.get(i - 1));
				int thisTime = getMinMaxWaitTime(capacity, assignments);

				if (thisTime < maxWait) {
					System.out.println("MIN " + i);
					maxWait = thisTime;
				}
			}
		}
		maxWait = getMinMaxWaitTime(capacity, assignments);
		System.out.println(maxWait);
		out[0] = maxWait + "";
		return out;
	}
	public static int getMinMaxWaitTime(int capacity, ArrayList<Integer> cows) {
		int maxWait = -1;
		System.out.println("S " + cows.size());
		for (int i = capacity - 1; i < cows.size(); i += capacity) {
			System.out.println("I " + i + "    I-C " + (i - capacity + 1) + "    GETI " + cows.get(i) + "    GETF " + cows.get(i - capacity + 1));
			if ((cows.get(i) - cows.get(i - capacity + 1)) > maxWait) {
				maxWait = cows.get(i) - cows.get(i - capacity + 1);
			}
		}
		return maxWait;
	}
	public static void sort(ArrayList<Integer> cows) {
		quicksort(cows, 0, cows.size() - 1);
	}

	public static void quicksort(ArrayList<Integer> cows, int low, int high) {
		int i = low, j = high;

		int pivot = cows.get(low + (high-low)/2);

		while (i <= j) {

			while (cows.get(i) < pivot) {
				i++;
			}

			while (cows.get(j) > pivot) {
				j--;
			}
			if (i <= j) {
				swap(cows, i, j);
				i++;
				j--;
			}
		}

		// Recursion
		if (low < j) {
			quicksort(cows, low, j);
		}
		if (i < high) {
			quicksort(cows, i, high);
		}
	}

	public static void swap(ArrayList<Integer> cows, int i, int j) {
		int temp = cows.get(i);
		cows.set(i, cows.get(j));
		cows.set(j, temp);
	}
}