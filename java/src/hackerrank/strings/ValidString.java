package hackerrank.strings;

import java.awt.Toolkit;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ValidString {


    // Complete the isValid function below.
    static String isValid(String s) {

        int[] arr = new int[26];
        for (int i = 0; i < 26; ++i) arr[i] = 0;
        for (int i = 0; i < s.length(); ++i) ++arr[s.charAt(i) - 'a'];

        int count = 0;
        Set<Integer> is = new HashSet<>();

        for (int i = 0; i < 26; ++i) {
            if (arr[i] == 0) continue;
            if (count == 0 && is.add(arr[i])) ++count;
            else if (count == 1 && is.add(arr[i])) {
                int curr = is.iterator().next().intValue();
                if (arr[i] - curr > 1)
                    return "NO";
                ++count;
                is.remove(arr[i]);
            } else if (count == 2 && is.add(arr[i]))
                return "NO";
        }
        return "YES";

    }


    private static void runTestCase(String testCase, Scanner scanner, Scanner output) {

        StringWriter bufferedWriter = new StringWriter();

        // ----------------
        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);

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

        String testCases = System.getenv("TESTCASES") + "/sherlock-and-valid-string-testcases.zip";

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
