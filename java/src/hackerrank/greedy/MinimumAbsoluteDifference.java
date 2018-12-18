package hackerrank.greedy;

import java.awt.Toolkit;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class MinimumAbsoluteDifference {

    private static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int minimumDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if (diff < minimumDiff) {
                minimumDiff = diff;
            }
        }

        return minimumDiff;
    }

    private static void runTestCase(String testCase, Scanner scanner, Scanner output) {

        StringWriter bufferedWriter = new StringWriter();

        // ----------------
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        // ----------------

        String resultStr = bufferedWriter.toString();
        String outputStr = output.useDelimiter("\\A").next().strip();

        if (!outputStr.equals(resultStr)) {
            System.out.println(String.format("FAIL: %s\nEXPECTED: %s\nACTUAL:   %s\n---",
                    testCase, outputStr, resultStr));
            Toolkit.getDefaultToolkit().beep();
        } else {
            System.out.println(String.format("SUCCESS: %s\nEXPECTED: %s\nACTUAL:   %s\n---",
                    testCase, outputStr, resultStr));
        }

    }


    public static void main(String[] args) throws IOException {

        String testCases = System.getenv("TESTCASES") + "/minimum-absolute-difference-in-an-array-testcases.zip";

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
