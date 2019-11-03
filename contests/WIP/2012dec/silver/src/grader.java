import java.io.IOException;
import java.nio.file.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// Note: for basic testing only
class Result {
    String result; // TODO: Support timeout and stuff
    long time;
    Result(String result) {
        this.result = result; // For now, can be * (success) or E (error) or I (incorrect)
        this.time = 0;
    }
    Result(String result, long time) {
        this.result = result; // * (success) or E (error) or I (incorrect)
        this.time = time; // if not error
    }

    String getResult() {
        return this.result;
    }
    boolean hasTime() {
        return this.time != 0;
    }
    long getTime() {
        return this.time;
    }
}
public class grader {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String name = "wifi";
        // Each case has an input and output file
        int cases = new File(name).listFiles().length / 2;

        Result[] result = new Result[cases];

        for (int i = 1; i < cases + 1; i ++) {
            Files.deleteIfExists(Paths.get(name+ ".in"));
            Files.copy(Paths.get(name + "/" + i + ".in"), Paths.get(  name + ".in"));
            long start = System.currentTimeMillis();
            try {
                wifi.main(null);
            } catch (Error e) {
                System.out.println(e.getMessage());
                result[i - 1] = new Result("E");
            }
            long end = System.currentTimeMillis();

            long time = end - start;
            System.out.println(time);
            result[i - 1] = new Result(compareFiles(Paths.get(name + "/" + i + ".out"), Paths.get(  name + ".out")) ? "*" : "I", time);
            System.out.println(time);

        }

        for (int i = 0; i < result.length; i ++) {
            System.out.println("Test " + (i + 1) + ": " + result[i].getResult() + (result[i].hasTime() ? " (" + result[i].getTime() + "ms)" : ""));
        }

    }


    static boolean compareFiles(Path file1, Path file2) throws IOException {
        //https://stackoverflow.com/a/27379566/5511561
        final long size = Files.size(file1);
        if (size != Files.size(file2))
            return false;

        if (size < 4096)
            return Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2));

        try (InputStream is1 = Files.newInputStream(file1);
             InputStream is2 = Files.newInputStream(file2)) {
            // Compare byte-by-byte.
            // Note that this can be sped up drastically by reading large chunks
            // (e.g. 16 KBs) but care must be taken as InputStream.read(byte[])
            // does not necessarily read a whole array!
            int data;
            while ((data = is1.read()) != -1)
                if (data != is2.read())
                    return false;
        }

        return true;
    }
}
