public class ECProblem {
        public static void main(String[] args) {

            int[] array = {1, 2, 3, 7, 5};

            int k1 = 12;
            int k2 = 5;
            int k3 = 7;
            int k4 = 11;

            int[] result1 = sumTarget(array, k1);
            for(int i : result1)
            {
                System.out.print(i + " ");
            }
            System.out.println();

            int[] result2 = sumTarget(array, k2);
            for(int i : result2)
            {
                System.out.print(i + " ");
            }
            System.out.println();

            int[] result3 = sumTarget(array, k3);
            for(int i : result3)
            {
                System.out.print(i + " ");
            }
            System.out.println();


            int[] result4 = sumTarget(array, k4);
            for(int i : result4)
            {
                System.out.print(i + " ");
            }


        }

        public static int[] sumTarget(int[] array, int k) {
            int[] newArray = {-1, -1};
            int sum = 0;
            int start = 0;

            for (int i = 0; i < array.length; i++) {
                sum += array[i]; //updates sum of current subarray

                while (sum > k && start <= i) {
                    sum -= array[start]; //removes element at start index from current subarray, adjust sum to smaller value
                    start++;
                }

                if (sum == k) {
                    newArray[0] = start;
                    newArray[1] = i;
                    return newArray;
                }
            }
            return newArray;
        }
}
