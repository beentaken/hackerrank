package hackerrank.strings;

import java.awt.Toolkit;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AlternatingCharacters {


    static int alternatingCharacters(String s) {

        int c = 0;
        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                c++;
            }

        }
        return c;
    }


    private static void runTestCase(String testCase, Scanner scanner, Scanner output) {

        StringWriter bufferedWriter = new StringWriter();

        // ----------------

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

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

        String testCases = System.getenv("TESTCASES") + "/alternating-characters-testcases.zip";

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
