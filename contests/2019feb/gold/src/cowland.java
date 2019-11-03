// Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO February 2018 Gold #2 - Dishwashing (dishes)

import java.io.*;
import java.util.*;

class cowland {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowland.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowland.out")));

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

        int freq[] = {2, 1, 1, 3, 2, 3,
                4, 5, 6, 7, 8, 9};
        int n = freq.length;
        BIT tree = new BIT();

        // Build fenwick tree from given array
        tree.constructBITree(freq, n);

        System.out.println("Sum of elements in arr[0..5]"+
                " is "+ tree.getSum(5));

        // Let use test the update operation
        freq[3] += 6;

        // Update BIT for above change in arr[]
        BIT.updateBIT(n, 3, 6);

        // Find sum after the value is updated
        System.out.println("Sum of elements in arr[0..5]"+
                " after update is " + tree.getSum(5));


        String[] out = new String[1];

        return out;
    }
}

//BIT
// see https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
class BIT
{
    // Max tree size
    final static int MAX = 1000;

    static int BITree[] = new int[MAX];

    int getSum(int index)
    {
        int sum = 0;
        index = index + 1;

        // Traverse ancestors
        while(index>0)
        {
            // Add current element
            sum += BITree[index];

            // Move index to parent node
            index -= index & (-index);
        }
        return sum;
    }

    // Updates a node in Binary Index Tree (BITree)
    public static void updateBIT(int n, int index,
                                 int val)
    {
        // index in BITree[] is 1 more than
        // the index in arr[]
        index = index + 1;

        // Traverse all ancestors and add 'val'
        while(index <= n)
        {
            // Add 'val' to current node of BIT Tree
            BITree[index] += val;

            // Update index to that of parent
            // in update View
            index += index & (-index);
        }
    }

    /* Function to construct fenwick tree
    from given array.*/
    void constructBITree(int arr[], int n)
    {
        // Initialize BITree[] as 0
        for(int i=1; i<=n; i++)
            BITree[i] = 0;

        // Store the actual values in BITree[]
        // using update()
        for(int i = 0; i < n; i++)
            updateBIT(n, i, arr[i]);
    }

}