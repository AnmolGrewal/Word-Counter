import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Lab05 {

    static Map<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter File path: ");
        String filename = scan.nextLine();

        File file = new File(filename);
        if (file.exists()) {
            countKeywords(file);
            map.forEach((k, v) -> System.out.println(k + "\t" + v));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
        map.clear();
        // File 2

        System.out.println("Enter 2nd file path ");
        String filename2 = scan.nextLine();

        File file2 = new File(filename2);
        if (file2.exists()) {
            countKeywords(file2);
            map.forEach((k, v) -> System.out.println(k + "\t" + v));
        } else {
            System.out.println("File " + filename2 + " does not exist");
        }
        scan.close();
    }

    public static void countKeywords(File file) throws Exception {
        String text;
        // Array of all Java keywords + true, false and null
        String[] keywordString = { "Trump", "Donald", "Hillary", "Clinton", "Bill", "CNN", "Fox" };
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            text = scan.next();
            String[] words = text.split("[\\s+\\p{P}]");
            for (int i = 0; i < words.length; i++) {
                String key = words[i].toLowerCase();
                if (keywordSet.contains(text)) {
                    if (key.length() > 0) {
                        if (!map.containsKey(key)) {
                            map.put(key, 1);
                        } else {
                            int value = map.get(key);
                            value++;
                            map.put(key, value);
                        }
                    }
                }
            }
        }
        scan.close();
    }

}
