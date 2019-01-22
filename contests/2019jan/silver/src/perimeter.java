// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO January 2019 #2 - Icy perimeter

import java.io.*;
import java.util.*;

class perimeter {

    static int maxArea = 0;
    static int maxPerim = 0;
    static int curArea = 0;
    static int curPerim = 0;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));

        int n = Integer.parseInt(f.readLine());
        boolean[][] grid = new boolean[n][n];
        for (int x = 0; x < n; x ++) {
            String[] line = f.readLine().split("");
            for (int y = 0; y < n; y ++) {
                grid[x][y] = (line[y].equals("#"));
                //x = row, y = column (NOT like coordinate pane)
            }
        }

        String[] result = solve(n, grid);

        //doesn't work well with large outputs.
        for (int i = 0; i < result.length; i++) {
            out.println(result[i]);
        }
        out.close();
    }

    public static String[] solve(int n, boolean[][] grid) {
        boolean[][] visited = new boolean[n][n];

        for (int x = 0; x < n; x ++) {
            for (int y = 0; y < n; y ++) {
                //System.out.println(x + ", " + y);
                if (visited[x][y]) {
                    continue;
                }

                if (grid[x][y]) {
                    curArea = 0;
                    curPerim = 0;
                    dfs(x, y, n, grid, visited);
                }
                if (curArea > maxArea || (curArea == maxArea && curPerim < maxPerim)) {
                    maxArea = curArea;
                    maxPerim = curPerim;
                }
            }
        }


        //replace the following code.
        String[] out = new String[1];
        out[0] = maxArea + " " + maxPerim;
        return out;
    }

    //returns 1 if the item at the location was not ice cream and an item exists, otherwise returns 0
    public static void dfs(int x, int y, int n, boolean[][]grid, boolean[][]visited) {
        if (x >= n || y >= n || x < 0 || y < 0 || !grid[x][y]) {
            curPerim ++;
            return;
        }
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        curArea ++;
        dfs(x + 1, y, n, grid, visited);
        dfs(x - 1, y, n, grid, visited);
        dfs(x, y + 1, n, grid, visited);
        dfs(x, y - 1, n, grid, visited);



    }
}