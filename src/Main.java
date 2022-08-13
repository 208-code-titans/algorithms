import java.util.*;
import java.lang.*;

public class Main {
    // Linear Search
    public static int linearSearch(int[] arr, int x) {
        int arrLength = arr.length;

        // Loop through array to find a match for x
        for (int i = 0; i < arrLength; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (using recursion)
    public static int binarySearch(int[] arr, int first, int last, int key){
        if (last>=first){
            int mid = first + (last - first)/2;
            if (arr[mid] == key){
                return mid;
            }
            if (arr[mid] > key){
                return binarySearch(arr, first, mid-1, key); //search in left subarray
            }else{
                return binarySearch(arr, mid+1, last, key); //search in right subarray
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Hello, welcome to the Algorithm Tester!
                =======================================
                
                What type of algorithm would you like to implement
                ( 1 ) Search Algorithms
                ( 2 ) Sorting Algorithms
                
                """);
        int algoOption = sc.nextInt();

        if (algoOption == 1){
            System.out.println("""
                    Here are the available Search Algorithms.
                    ( 1 ) Linear Search
                    ( 2 ) Binary Search
                    """);
            int searchOption = sc.nextInt();

            if (searchOption == 1) {
                System.out.println("\nEnter 10 numbers separated with ONLY a space");

                int[] nums = new int[10];
                int i;

                // Loop to store input values in nums array
                for (i = 0; i < nums.length; i++) {
                    nums[i] = sc.nextInt();
                }

                System.out.println("\nEnter the number you want to search for");

                int searchValue = sc.nextInt();

                int answer = linearSearch(nums, searchValue);

                if ( answer == -1) {
                    System.out.println("\nElement is not present in list");
                }
                else {
                    System.out.println("\nElement is present at index: " + answer);
                }
            }
            else if (searchOption == 2) {
                System.out.println("\nEnter 10 numbers separated with ONLY a space");

                int[] nums = new int[10];
                int i;
                int last = nums.length - 1;

                // Loop to store input values in nums array
                for (i = 0; i < nums.length; i++) {
                    nums[i] = sc.nextInt();
                }

                System.out.println("\nEnter the number you want to search for");

                int searchValue = sc.nextInt();

                int answer = binarySearch(nums, 0, last, searchValue);

                if (answer == -1)
                    System.out.println("Element is not found!");
                else
                    System.out.println("Element is found at index: "+ answer);
            }
        }
        else if (algoOption == 2) {
            System.out.println("""
                    Here are the available Sorting Algorithms
                    
                    ( 1 ) Heap Sort
                    ( 2 ) Merge Sort
                    ( 3 ) Radix Sort
                    ( 4 ) Quick Sort
                    """);
        }
        else {
            System.out.println("Enter a valid input");
        }
    }
}

// Merge Sort handled by Kwabena Adu - Tekyi

        /* Java program for Merge Sort */
class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }
}