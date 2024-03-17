import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class RadixSort {

    public static void main(String[] args){
        String[] array = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman",
                "hydra", "surtr"};
        radix(array);

        for(String s : array)
        {
            System.out.print(s + ", ");
        }

    }

    public static void radix(String[] arr) {
        // Find the maximum length of strings in the array
        int maxLength = 0;
        for (String str : arr) {
            maxLength = Math.max(maxLength, str.length());
        }

        // Perform counting sort for each character from right to left
        for (int i = maxLength - 1; i >= 0; i--) {
            countingSort(arr, i);
        }
    }

    // Counting sort for a specific character position
    private static void countingSort(String[] arr, int pos) {
        HashMap<Character, ArrayList<String>> map = new HashMap<>();

        // Group strings based on the character at the specified position
        for (String str : arr) {
            char ch = pos < str.length() ? str.charAt(pos) : 'a'; // Assuming missing characters are treated as 'a'
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(str);
        }

        // Reconstruct the array based on the groups
        int index = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (map.containsKey(ch)) {
                for (String str : map.get(ch)) {
                    arr[index++] = str;
                }
            }
        }
    }
}
