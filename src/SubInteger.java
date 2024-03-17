import java.util.HashMap;

public class SubInteger {

    public static void main(String[] args)
    {
        int[] S1 = {32, 3};
        int[] T1 = {1, 2, 3, 52, 32, 54};
        System.out.println(isSubset(S1, T1));

        int[] S2 = {89, 32, 54, 32, 3};
        int[] T2 = {54, 32, 99};
        System.out.println(isSubset(S2, T2));

        int[] S3 = {0, 67};
        int[] T3 = {100, 5, 66, 2, 32, 90};
        System.out.println(isSubset(S3, T3));

        int[] S4 = {};
        int[] T4 = {54, 32, 99};
        System.out.println(isSubset(S4, T4));

    }

    //S is considered a subset of T if every element in S in an element in T (Not necessarily in the same order).
    public static String isSubset(int[] S, int[] T)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : T)
        {
            /*
            Retrieves value assoicated with num key from map.
            Puts updated count of occurences of num element into map.
            If num key exists in map, the value is incremented.
             */
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : S)
        {
            //checks if every element in S exists in T
            if(!map.containsKey(num) || map.get(num) == 0)
            {
                return "No";
            }
            map.put(num, map.get(num) - 1);
        }

        return "Yes";
    }


}
