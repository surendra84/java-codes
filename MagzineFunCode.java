import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magMap = getHashMap(magazine);
        Map<String, Integer> noteMap = getHashMap(note);
        String msg = "Yes";
        for(String str: note) {
            if(magMap.containsKey(str)) {
                if(magMap.get(str)<noteMap.get(str)) {
                    msg = "No";
                    break;
                }
            } else {
                msg = "No";
                break;
            }
        }
        System.out.println(msg);
    }

    private static Map<String, Integer> getHashMap(String[] arr) {
        Map<String, Integer> map = new HashMap();
        for(String str: arr) {
            if(map.containsKey(str)) {
                int c = map.get(str) + 1;
                map.put(str, c);
            } else {
                map.put(str,1);
            }
        }
        return map;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
