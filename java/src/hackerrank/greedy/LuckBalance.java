package hackerrank.greedy;

import java.awt.Toolkit;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LuckBalance {


//    Arrays.sort(contests, new Comparator<int[]>() {
//        public int compare(int[] c1, int[] c2) {
//            if (c1[1] == c2[1]) {
//                return c1[0] - c2[0];
//            }
//            if (c1[1] > c2[1]) {
//                return -1;
//            } else {
//                return 1;
//            }
//        }
//    });

    static int luckBalance(int k, int[][] contests) {

        List<Integer> important = new ArrayList<>();

        int maxLuck = 0;
        for (int[] contest : contests) {
            if (contest[1] == 1) {
                important.add(contest[0]);
            } else {
                maxLuck += contest[0];
            }
        }
        important.sort(Collections.reverseOrder());


        for (int l : important) {
            if (k > 0) {
                maxLuck += l;
            } else {
                maxLuck -= l;
            }
            k--;
        }

        return maxLuck;
    }


    private static void runTestCase(String testCase, Scanner scanner, Scanner output) {

        StringWriter bufferedWriter = new StringWriter();

        // ----------------

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
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

        String testCases = System.getenv("TESTCASES") + "/luck-balance-testcases.zip";

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
