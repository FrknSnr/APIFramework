package fusebeInterview;

public class Test {

    public static void main(String[] args) {

        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2);
        }
        int countOfZero = 0;
        int countOfOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countOfZero++;
            } else {
                countOfOne++;
            }
        }
        int index = 0;
        while (countOfZero > 0) {
            arr[index++] = 0;
            countOfZero--;
        }
        while (countOfOne > 0) {
            arr[index++] = 1;
            countOfOne--;
        }
        for (int i : arr) {
            System.out.printf(i + " ");
        }


//        java.util.Arrays.sort(arr);
//        for (int i : arr) {
//            System.out.printf(i + " ");
//        }
//        List<Integer> list = Arrays.asList(arr);
//        java.util.Collections.sort(list);
//
//        Integer[] sortedArr = new Integer[list.size()];
//        list.toArray(sortedArr);
//        // Print
//        for (int i = 0; i < sortedArr.length; i++) {
//            System.out.printf(sortedArr[i] + " ");
//        }

        // Another Way
        int[] arrSer = new int[10];
        for (int i = 0; i < arrSer.length; i++) {
            arrSer[i] = (int) (Math.random() * 2);
        }
        arrSer = sort(arrSer);
        for (int i :
                arrSer) {
            System.out.printf(i+" ");
        }

    }

    public static int[] sort(int[] arr) {
        int[] sorted = new int[arr.length];
        int end = sorted.length - 1;
        int begin = 0;

        for (int n : arr) {
            if (n == 1) {
                sorted[end--] = n;
            } else {
                sorted[begin++] = n;
            }

        }
        return sorted;

    }

}
