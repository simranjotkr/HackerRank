import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.lang.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        int length = s.length();
        String newTime = "";
        String format = s.substring(length-2, length);
        if("PM".equalsIgnoreCase(format)) {
            int hh = Integer.parseInt(s.substring(0, 2));
            String mm = s.substring(3, 5);
            String ss = s.substring(6, 8);
            if(hh < 12) 
                newTime = (hh+12) + ":" + mm + ":" + ss;
            else if (hh == 12)
                newTime = hh + ":" + mm + ":" + ss;
        } else if("AM".equalsIgnoreCase(format)) {
            String hh = s.substring(0, 2);
            String mm = s.substring(3, 5);
            String ss = s.substring(6, 8);
            if("12".equalsIgnoreCase(hh)) {
                 newTime = "00" + ":" + mm + ":" + ss;
            } else {
                newTime = hh + ":" + mm + ":" + ss;
            }
        }
        return newTime;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
