package hackerrank.hashing;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        long count = 0;
        Map<Long, Long> p2 = new HashMap<>();
        Map<Long, Long> p3 = new HashMap<>();

        for (Long v : arr) {

            count += p3.getOrDefault(v, 0L);

            if (p2.containsKey(v)) {
                p3.put(v * r, p3.getOrDefault(v * r, 0L) + p2.get(v));
            }

            p2.put(v * r, p2.getOrDefault(v * r, 0L) + 1);
        }

        return count;
    }

    private static void runTestCase(String testCase, BufferedReader bufferedReader, Scanner output)
            throws IOException {

        StringWriter bufferedWriter = new StringWriter();

        // ----------------

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
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

        String testCases = System.getenv("TESTCASES") + "/count-triplets-1-testcases.zip";

        Pattern pattern = Pattern.compile("input/input(\\d+).txt");

        ZipFile zipFile = new ZipFile(testCases);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            Matcher matcher = pattern.matcher(entry.getName());
            while (matcher.find()) {
                String testCase = matcher.group(1);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));

                ZipEntry output = zipFile.getEntry(String.format("output/output%s.txt",
                        testCase));
                Scanner outputScanner = new Scanner(zipFile.getInputStream(output));

                runTestCase(testCase, bufferedReader, outputScanner);

                bufferedReader.close();
                outputScanner.close();
            }

        }

    }

}
