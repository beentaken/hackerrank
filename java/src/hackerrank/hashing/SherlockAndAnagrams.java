package hackerrank.hashing;

import java.awt.Toolkit;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        List<String> subs = allSubstrings(s);

        Map<String, Integer> d = new HashMap<>();
        for (String sub : subs) {
            String sorted = sortString(sub);
            if (!d.containsKey(sorted)) {
                d.put(sorted, 1);
            } else {
                d.put(sorted, d.get(sorted) + 1);
            }
        }

        int count = 0;
        for (Integer val : d.values()) {
            if (val > 1) {
                count = count + (((val - 1) * val) / 2);
            }
        }

        return count;
    }

    private static List<String> allSubstrings(String s) {
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                subs.add(s.substring(i, j));
            }
        }
        return subs;
    }

    // Method to sort a string alphabetically
    public static String sortString(String inputString) {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }


    private static void runTestCase(String testCase, Scanner scanner, Scanner output) {

        StringWriter bufferedWriter = new StringWriter();

        // ----------------
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.write("\n");
        }

        // ----------------

        String resultStr = bufferedWriter.toString().strip();
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

        String testCases = System.getenv("TESTCASES") + "/sherlock-and-anagrams-testcases.zip";

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
