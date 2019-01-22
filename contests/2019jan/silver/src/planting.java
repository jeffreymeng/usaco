// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// Janurary 2019 Silver #1 - Grass planting

import java.io.*;
import java.util.*;

class Field {
    int id;
    int grassType;
    ArrayList<Integer> neighbors;

    public Field(int id) {
        this.id = id;
        this.neighbors = new ArrayList<Integer>();
    }
}

class planting {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));

        int n = Integer.parseInt(f.readLine());
        int[][] paths = new int[n][2];
        String[] line;
        for (int i = 0; i < n - 1; i ++) {
            line = f.readLine().split(" ");
            paths[i][0] = Integer.parseInt(line[0]);
            paths[i][1] = Integer.parseInt(line[1]);
        }

        String[] result = solve(n, paths);

        //doesn't work well with large outputs.
        for (int i = 0; i < result.length; i++) {
            out.println(result[i]);
        }
        out.close();
    }

    public static String[] solve(int n, int[][] paths) {


        Field[] fields = new Field[n];

        int a, b;
        for (int i = 0; i < n - 1; i ++) {
            a = paths[i][0] - 1;
            b = paths[i][1] - 1;

            if (fields[a] == null) {
                fields[a] = new Field(a);

            }
            if (fields[b] == null) {
                fields[b] = new Field(b);
            }

            fields[a].neighbors.add(b);
            fields[b].neighbors.add(a);

        }

        int minTypes = 1;
        //loop through each field and find what type of grass it can use.
        // Each number, starting from 1, is a different type of grass.
        boolean[] nums;

        for (int i = 0; i < n; i ++) {

            nums = new boolean[n];
            for (int j = 0; j < fields[i].neighbors.size(); j ++) {
                if (j > i) continue;
                Field neighbor = fields[fields[i].neighbors.get(j)];
                nums[neighbor.grassType] = true;

                for (int k = 0; k < fields[neighbor.id].neighbors.size(); k ++) {
                    if (k > i) continue;

                    nums[fields[fields[neighbor.id].neighbors.get(k)].grassType] = true;

                }

            }

            for (int j = 0; j < nums.length; j ++) {
                if (!nums[j]) {
                    if (j < minTypes) {
                        fields[i].grassType = j;
                    } else {
                        fields[i].grassType = minTypes;
                        minTypes ++;
                    }
                    break;

                }
            }


        }



        String[] out = new String[1];
        out[0] = (minTypes - 1) + "";
        return out;
    }
}