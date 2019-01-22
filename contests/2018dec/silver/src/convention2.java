// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO December 2018 Silver #2 - Convention II (convention2)

import java.io.*;
import java.util.*;

class convention2 {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("convention2.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));

		int n = Integer.parseInt(f.readLine());
		int[][]cows = new int[n][3];
		for (int i = 0; i < n; i ++) {
			String[] line = f.readLine().split(" ");
			cows[i][0] = i;
			cows[i][1] = Integer.parseInt(line[0]);
			cows[i][2] = Integer.parseInt(line[1]);
		}

		String[] result = solve(n, cows);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(int n, int[][] cows) {
		//replace the following code.
		String[] out = new String[1];

		sort(cows);
		int startTime = 0;
		int endTime = 0;
		ArrayList<int[]> line = new ArrayList<int[]>();
		int maxWaitingTime = 0;
		for (int i = 0; i < cows.length; i ++) {
			if (cows[i][0] == -1) continue;



			if (cows[i][1] > endTime) {
				startTime = cows[i][1];
				endTime = cows[i][2] + startTime;
				cows[i][0] = -1;

			} else {

				boolean ranOnce = false;

				while(!ranOnce || line.size() > 0) {
					for (int j = i; j < cows.length; j ++) {
						if (cows[j][0] == -1) continue;
						if (cows[j][1] > endTime) break;


						line.add(cows[j].clone());

						cows[j][0] = -1; // remove the cow from the cows list and move it to the line

					}
					if (line.size() == 0) break;

					//find the highest seniority -- the lower the number the higher the senority
					int highestSen = line.get(0)[0];
					int highestInd = 0;
					int[] highest = line.get(0);
					for (int j = 0; j < line.size(); j++) {

						if (line.get(j)[0] < highestSen) {
							highest = line.get(j);
							highestSen = line.get(j)[0];
							highestInd = j;
						}
					}

					//remove the highest cow from the line
					line.remove(highestInd);

					int waitTime = endTime  - highest[1];
					startTime = endTime ;
					//if last end time minus the planned start time is more than the max waiting time
					if (endTime - highest[1] > maxWaitingTime){

						maxWaitingTime = waitTime;
					}


					endTime = highest[2] + startTime;


					ranOnce = true;

				}

			}



		}


		out[0] = maxWaitingTime + "";
		return out;
	}

	//quick sort
	public static void sort(int[][] cows) {
		quicksort(cows, 0, cows.length - 1);
	}

	public static void quicksort(int[][] cows, int low, int high) {
		int i = low, j = high;

		int pivot = cows[low + (high-low)/2][1];

		while (i <= j) {

			while (cows[i][1] < pivot) {
				i++;
			}

			while (cows[j][1] > pivot) {
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

	public static void swap(int[][] cows, int i, int j) {
		int[] temp = cows[i];
		cows[i] = cows[j];
		cows[j] = temp;
	}

}