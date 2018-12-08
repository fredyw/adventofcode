package aoc2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * https://adventofcode.com/2018/day/8
 */
public class Day8 {
    private static final String INPUT = "src/main/resources/aoc2018/day8.txt";

    private static int part1() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT))) {
            String line = reader.readLine();
            String[] array = line.split(" ");
            IntRef sum = new IntRef();
            metadata(array, new IntRef(), sum);
            return sum.val;
        }
    }

    private static void metadata(String[] array, IntRef index, IntRef sum) {
        if (index.val == array.length) {
            return;
        }
        int nChild = Integer.parseInt(array[index.val++]);
        int nMetadata = Integer.parseInt(array[index.val++]);
        for (int i = 0; i < nChild; i++) {
            metadata(array, index, sum);
        }
        for (int i = 0; i < nMetadata; i++) {
            sum.val += Integer.parseInt(array[index.val++]);
        }
    }

    private static class IntRef {
        private int val;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(part1());
    }
}
