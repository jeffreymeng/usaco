// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO December 2018 Silver #3 - Mooyo Mooyo (mooyomooyo)

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


class mooyomooyo {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));


		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));

		String[] line = f.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		int[][]board = new int[10][n];
		for (int row = 0; row < n; row ++) {
			line = f.readLine().split("");
			for (int col = 0; col < 10; col ++) {
				board[col][row] = Integer.parseInt(line[col]);
			}
		}

		String[] result = solve(n, k, board);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(int n, int k, int[][] board) {
		String[] solution = new String[n];

		boolean removed = true;
		while (removed) {
			removed = false;

			for (int col = 0; col < board.length; col++) {
				for (int row = 0; row < board[0].length; row++) {
					if (board[col][row] != 0 && floodfillCount(col, row, board[col][row], board,new boolean[board.length][board[0].length]) >= k) {
						floodfillRemove(col, row, board[col][row], board);
						removed = true;
					}

				}
			}
			//System.out.println();
			//System.out.println("B");
			gravity(board);
			//System.out.println("A");
		}






		int[][] transformed = new int[n][10];
		for (int col = 0; col < 10; col ++) {
			//transform a array of columns into an array of rows
			for (int row = 0; row < n; row ++) {
				transformed[row][col] = board[col][row];
			}

		}
		for (int col = 0; col < n; col ++) {
			//join int array
			solution[col] = IntStream.of(transformed[col]).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(""));




		}
		return solution;
	}

	public static void gravity(int[][] board) {
		for (int i = 0; i < board.length; i ++) {
			//System.out.println("COL " + i);
			boolean swapped = true;
			while (swapped) {
				swapped = false;

				for (int j = board[i].length - 1; j > 0; j --) {

					if (board[i][j] == 0 && board[i][j - 1] != 0) {
						//swap
						swapped = true;
						//System.out.println(j);
						board[i][j] = board[i][j - 1];
						board[i][j - 1] = 0;
					}
					//if this is a zero and the next one is not a zero, swap

				}
			}
		}
	}

	public static int floodfillCount(int col, int row, int color, int[][] board, boolean[][] counted) {

		if (counted[col][row]) return 0;
		counted[col][row] = true;
		if (board[col][row] != color) return 0;

		int result = 1;

		if (board[0].length > row + 1) result += floodfillCount(col, row + 1, color, board, counted);
		if (row > 0) result += floodfillCount(col, row - 1, color, board, counted);
		if (board.length > col + 1) result += floodfillCount(col + 1, row, color, board, counted);
		if (col > 0) result += floodfillCount(col - 1, row, color, board, counted);
		return result;
	}
	public static void floodfillRemove(int col, int row, int color, int[][] board) {

		if (board[col][row] != color) return;
		board[col][row] = 0;

		if (board[0].length > row + 1) floodfillRemove(col, row + 1, color, board);
		if (row > 0) floodfillRemove(col, row - 1, color, board);
		if (board.length > col + 1) floodfillRemove(col + 1, row, color, board);
		if (col > 0) floodfillRemove(col - 1, row, color, board);
	}

}
