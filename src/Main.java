import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean hasQuit = false;

        while (!hasQuit) {
            System.out.println("""
                Hello, welcome to the Algorithm Tester!
                =======================================
                
                Enter the number associated with the algorithm you want to perform:
                ( 1 ) Search Algorithms
                ( 2 ) Sorting Algorithms
                
                """);
            int algoOption = sc.nextInt();

            switch (algoOption) {
                case 1 -> {
                    System.out.println("""
                            Here are the available Search Algorithms.
                            Enter the number associated with the algorithm you want to perform:
                            ( 1 ) Linear Search
                            ( 2 ) Binary Search
                            """);
                    int searchOption = sc.nextInt();
                    switch (searchOption) {
                        case 1 -> {
                            System.out.println("\nEnter 10 numbers separated with ONLY a space");
                            int[] nums = new int[10];
                            int i;
                            // Loop to store input values in nums array
                            for (i = 0; i < nums.length; i++) {
                                nums[i] = sc.nextInt();
                            }
                            System.out.println("\nEnter the number you want to search for");
                            int searchValue = sc.nextInt();
                            int answer = Search.linearSearch(nums, searchValue);
                            if (answer == -1) {
                                System.out.println("\nElement is not present in list");
                            } else {
                                System.out.println("\nElement is present at index: " + answer);
                            }
                        }
                        case 2 -> {
                            System.out.println("Binary Search\nEnter 10 numbers separated with ONLY a space");
                            int[] numbers = new int[10];
                            int j;
                            int last = numbers.length - 1;

                            // Loop to store input values in nums array
                            for (j = 0; j < numbers.length; j++) {
                                numbers[j] = sc.nextInt();
                            }
                            System.out.println("\nEnter the number you want to search for");
                            int searchKey = sc.nextInt();
                            int result = Search.binarySearch(numbers, 0, last, searchKey);
                            if (result == -1)
                                System.out.println("Element is not found!");
                            else
                                System.out.println("Element is found at index: " + result);
                        }
                        default -> System.out.println("You did not enter a valid input.");
                    }
                }
                case 2 -> {
                    System.out.println("""
                            Here are the available Sorting Algorithms.
                            Enter the number associated with the algorithm you want to perform:
                                                
                            ( 1 ) Heap Sort
                            ( 2 ) Merge Sort
                            ( 3 ) Selection Sort
                            ( 4 ) Quick Sort
                            ( 5 ) Bubble Sort
                            ( 6 ) Insertion Sort
                            ( 7 ) Radix Sort 
                            """);
                    int sortOption = sc.nextInt();
                    switch (sortOption) {
                        case 1 -> {
                            System.out.println("Heap Sort Test\n");
                            System.out.println("\nEnter 10 numbers separated with ONLY a space");
                            int[] data = new int[10];
                            int i;
                            for (i = 0; i < data.length; i++) {
                                data[i] = sc.nextInt();
                            }

                            Sort.heapSort(data, data.length);
                            System.out.println("Sorted Array in Ascending Order: ");
                            Sort.printArr(data, data.length);
                        }
                        case 2 -> {
                            System.out.println("Merge Sort Test\n");
                            System.out.println("\nEnter 10 numbers separated with ONLY a space");
                            int[] data = new int[10];
                            int i;
                            for (i = 0; i < data.length; i++) {
                                data[i] = sc.nextInt();
                            }

                            Sort.mergeSort(data, 0, data.length - 1);
                            System.out.println("Sorted Array in Ascending Order: ");
                            Sort.printMergeArray(data, data.length);
                        }
                        case 3 -> {
                            System.out.println("Selection Sort Test\n");
                            System.out.println("\nEnter 10 numbers separated with ONLY a space");
                            int[] data = new int[10];
                            int i;
                            for (i = 0; i < data.length; i++) {
                                data[i] = sc.nextInt();
                            }

                            Sort.selectionSort(data);
                            System.out.println("Sorted Array in Ascending Order: ");
                            Sort.printSelectionArray(data);
                        }
                        case 4 -> {
                            System.out.println("Quick Sort Test\n");
                            System.out.println("\nEnter 10 numbers separated with ONLY a space");
                            int[] data = new int[10];
                            int i;
                            for (i = 0; i < data.length; i++) {
                                data[i] = sc.nextInt();
                            }

                            Sort.quickSort(data, 0, data.length - 1);

                            System.out.println("Sorted Array in Ascending Order ");
                            Sort.printArray(data, data.length);

                        }
                        case 5 -> {
                            System.out.println("Bubble Sort\nEnter 10 numbers separated with ONLY a space");
                            int[] nums = new int[10];
                            int i;
                            // Loop to store input values in nums array
                            for (i = 0; i < nums.length; i++) {
                                nums[i] = sc.nextInt();
                            }

                            Sort.bubbleSort(nums, nums.length);
                            System.out.println("The elements after sorting: ");
                            for(i = 0; i < nums.length; ++i){
                                System.out.print(nums[i] + " ");
                            }
                        }
                        case 6 -> {
                            System.out.println("Insertion Sort Test\n");
                            System.out.println("\nEnter 10 numbers separated with ONLY a space");
                            int[] nums = new int[10];
                            int i;
                            // Loop to store input values in nums array
                            for (i = 0; i < nums.length; i++) {
                                nums[i] = sc.nextInt();
                            }
                            Sort.insertionSort(nums);
                            System.out.println("The elements after sorting: ");
                            System.out.println(Arrays.toString(nums));
                        }
                        case 7 -> {
                            System.out.println("Radix Sort Test\n");
                            System.out.println("\nEnter 10 numbers separated with ONLY a space");
                            int[] data = new int[10];
                            int i;
                            for (i = 0; i < data.length; i++) {
                                data[i] = sc.nextInt();
                            }
                            Sort.radixSort(data, data.length);
                            Sort.printRadixArray(data, data.length);

                        }
                    }
                }
                default -> System.out.println("Enter a valid input");
            }


            System.out.println("\n\nPress any key to continue or press q to quit");
            String quit = sc.next();

            if (Objects.equals(quit, "q")) {
                hasQuit = true;
            }
        }


        System.out.println("Thanks for using this application!");

    }

}