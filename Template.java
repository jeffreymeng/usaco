// TODO: Template

import java.io.*;
import java.util.*;

class Template {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("template.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("template.out")));

        String input = f.readLine();

        String[] result = solve(input);

        //doesn't work well with large outputs.
        for (int i = 0; i < result.length; i++) {
            out.println(result[i]);
        }
        out.close();
    }

    public static String[] solve(String input) {
        
        String[] out = new String[1];
        out[0] = input;
        return out;
    }
}