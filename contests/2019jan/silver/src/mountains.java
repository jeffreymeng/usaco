// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO January 2019 #3 - Mountain View

import java.io.*;
import java.util.*;

class mountains {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("mountains.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));

        int n = Integer.parseInt(f.readLine());
        int[][] peaks = new int[n][3];
        for (int i = 0; i < n; i ++) {
            String[] line = f.readLine().split(" ");
            peaks[i][0] = Integer.parseInt(line[0]);
            peaks[i][1] = Integer.parseInt(line[1]);
            peaks[i][2] = 1;
        }


        String[] result = solve(n, peaks);

        //doesn't work well with large outputs.
        for (int i = 0; i < result.length; i++) {
            out.println(result[i]);
        }
        out.close();
    }

    public static String[] solve(int n, int[][] peaks) {
        int numPeaks = n;
        for (int i = 0; i < peaks.length; i ++) {
            if (peaks[i][2] < 0) continue;

            for (int j = 0; j < peaks.length; j ++) {
                if (peaks[j][2] < 0) continue;

                int heightDiff = peaks[i][1] - peaks[j][1];
                int horizontalDiff = Math.abs(peaks[i][0] - peaks[j][0]);
                if (i != j && heightDiff > 0 && heightDiff >= horizontalDiff) {
                    //the main peak covers the other
                    peaks[j][2] = -1;
                    numPeaks --;
                }
            }
        }



        //replace the following code.
        String[] out = new String[1];
        out[0] = numPeaks + "";
        return out;
    }
}