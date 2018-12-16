package hackerrank.arrays.twodarrays;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;

        int[][] offsets = {{0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}, {2, 1}, {2, 2}};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int hgSum = 0;
                for (int[] offset : offsets) {
                    hgSum = hgSum + arr[i + offset[0]][j + offset[1]];
                }
                if (hgSum > max) {
                    max = hgSum;
                }
            }
        }

        return max;
    }


    private static void runTestCase(String testCase, Scanner input, Scanner output) {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = input.nextLine().split(" ");
            input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);


        String outputStr = output.useDelimiter("\\A").next();
        String resultStr = String.valueOf(result);

        if (!outputStr.equals(resultStr)) {
            System.out.println(String.format("FAIL: %s\nEXPECTED: %s\nACTUAL: %s\n---",
                    testCase, outputStr, resultStr));
        }

    }

    public static void main(String[] args) throws IOException {

        String testCases = System.getenv("TESTCASES") + "/2d-array-testcases.zip";

        Pattern pattern = Pattern.compile("input/input(\\d+).txt");

        ZipFile zipFile = new ZipFile(testCases);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            Matcher matcher = pattern.matcher(entry.getName());
            while (matcher.find()) {
                String testCase = matcher.group(1);

                Scanner inputScanner = new Scanner(zipFile.getInputStream(entry));

                ZipEntry output = zipFile.getEntry(String.format("output/output%s.txt",
                        testCase));
                Scanner outputScanner = new Scanner(zipFile.getInputStream(output));

                runTestCase(testCase, inputScanner, outputScanner);

                inputScanner.close();
                outputScanner.close();
            }

        }

    }
}
