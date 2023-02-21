import java.util.*;

public class SortComparison {
    
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arr.add(rand.nextInt(100));
        }

        // merge sort
        List<Integer> arr1 = new ArrayList<>(arr);
        long start = System.nanoTime();
        mergeSort(arr1, 0, arr1.size() - 1);
        long end = System.nanoTime();
        System.out.println("Merge sort time: " + (end - start) + " nanoseconds");

        // bubble sort
        List<Integer> arr2 = new ArrayList<>(arr);
        start = System.nanoTime();
        bubbleSort(arr2);
        end = System.nanoTime();
        System.out.println("Bubble sort time: " + (end - start) + " nanoseconds");
    }

    public static <T extends Comparable<T>> void mergeSort(List<T> arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> arr, int l, int m, int r) {
        List<T> temp = new ArrayList<>();
        int i = l;
        int j = m + 1;
        while (i <= m && j <= r) {
            if (arr.get(i).compareTo(arr.get(j)) < 0) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;
            }
        }
        while (i <= m) {
            temp.add(arr.get(i));
            i++;
        }
        while (j <= r) {
            temp.add(arr.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            arr.set(l + k, temp.get(k));
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) {
                    T temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }
}