// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO November 2012 - Find the cow! (cowfind)

import java.io.*;
//import java.util.*;

class Cowfind {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("cowfind.in"));


		PrintWriter out =
				new PrintWriter(new BufferedWriter(new FileWriter("cowfind.out")));

		String field = f.readLine();

		String[] result = solve(field);

		//doesn't work well with large outputs.
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
		out.close();
	}

	public static String[] solve(String field) {
		char[] fieldArr = field.toCharArray();

		boolean lastIsOpen = (fieldArr[0] == '(');

		//the pairs of hind legs up to this index
		int frontLegsToPoint = 0;

		int result = 0;

		for (int i = 1; i < fieldArr.length; i++) {

			//we have a set of hind legs
			if (lastIsOpen && fieldArr[i] == '(') {
				frontLegsToPoint++;

				//we have a set of front legs
			} else if (!lastIsOpen && fieldArr[i] == ')') {
				// each set of closing parentheses closes every single
				// opening set before it, so we increment result by the number
				// of opening legs before this point.

				result += frontLegsToPoint;
			}

			//we could omit this line and compare fieldArr[i-1] too
			lastIsOpen = (fieldArr[i] == '(');


		}
		String[] out = new String[1];
		out[0] = Integer.toString(result);
		return out;
	}
}