// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO November 2012 - Horseshoes! (hshoe)

import java.io.*;

class Hshoe {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("template.in"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("template.out")));

		String[] field = new String[Integer.parseInt(f.readLine())];
		for (int i = 0; i < field.length; i ++) {
			field[i] = f.readLine().split("");
		}

		String[] result = solve(field);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(String[] field) {
		int size = field.length;
		boolean[][] visited = new boolean[size][size];

		return dfs(0,0, true, visited, field);


	}

	public static int dfs(int x, int y, boolean pickingUp, boolean[][] visited, boolean[][] field) {

	}
}