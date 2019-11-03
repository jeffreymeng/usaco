// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO February 2018 Gold #2 - Dishwashing (dishes)

import java.io.*;
import java.util.*;

class dishes {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("dishes.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dishes.out")));

        int N = Integer.parseInt(f.readLine());
        int[] stack = new int[N];
        for (int i = 0; i < N; i ++) {
            stack[i] = Integer.parseInt(f.readLine());
        }
        String[] result = solve(N, stack);

        //doesn't work well with large outputs.
        for (int i = 0; i < result.length; i++) {
            out.println(result[i]);
        }
        out.close();
    }

    public static String[] solve(int N, int[] stack) {
        int maxLength = 0;


        for (int i = 0; i <= N; i ++) {
            int length = 1; //length
            int smallest = i;

            ArrayList<Integer> counter = new ArrayList<Integer>();
            counter.add(stack[0]);
            counter.add(-1);// -1 indicates new stack. Top of stack is leftmost/lowest index.

            //label for loop
            stackLoop:
            //j is already defined above
            for (int j = 1; j < N; j ++) {
                if (counter.size() > 0 && counter.get(0) == smallest) {
                    counter.remove(0);
                    if (counter.get(0) == -1) {
                        counter.remove(0);
                    }
                    j--;
                    smallest ++;
                } else {
                    // insert at location
                    // to find the location to insert the element, sweep through the array, then once we find a higher
                    // element insert this element right before. If the place we insert the element is not either a new stack at the end
                    // or the top of a stack, this element cannot be inserted and the length before adding the element is the max
                    for (int k = 0; k < counter.size(); k ++) {
                        if (counter.get(k) > stack[j]) {
                            counter.add(k, stack[j]);

                            System.out.println("Element: " + stack[j] + " J:" + j + " inserted at " + k);
                            if (k > 0 && counter.get(k-1) != -1 && k != counter.size() - 1) {
                                System.out.println("Broken " + (counter.get(k-1) != -1) + ", " + (k != counter.size() - 1));
                                break stackLoop;
                            }
                            length ++;
                            break;
                        }
                    }
                    counter.add(stack[j]);
                    counter.add(-1);

                }
            }
            System.out.println("Length for smallest " + i + " is " + length);
            if (length > maxLength) {
                maxLength = length;
                if (maxLength == N) {
                    break;
                }
            }
        }

        String[] out = new String[1];
        out[0] = maxLength + "";
        return out;
    }
}