public class Sort {
        public static void bubbleSort(int [] sort_arr, int len){

                for (int i=0;i<len-1;++i){

                        for(int j=0;j<len-i-1; ++j){

                                if(sort_arr[j+1]<sort_arr[j]){

                                        int swap = sort_arr[j];
                                        sort_arr[j] = sort_arr[j+1];
                                        sort_arr[j+1] = swap;

                                }
                        }
                }
        }
        public static void insertionSort(int[] arr) {
                for (var i =1; i<arr.length; i++) {
                        var current = arr[i];
                        var j = i - 1;
                        while (j >= 0 && arr[j] > current) {
                                arr[j + 1] = arr[j];
                                j--;
                        }
                        arr[j + 1] = current;
                }
        }

        static void swap(int[] arr, int i, int j)
        {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
        }

        public static int partition(int[] array, int low, int high) {
                int pivot = array[high]; // choose rightmost as pivot
                int i = (low-1);
                //move through all elements and compare with pivot
                for (int j = low; j <= high - 1; j++) {
                        if (array[j] < pivot) {
                                i++; //if element is smaller than pivot, swap with larger element

                                swap(array, i, j);
                        }
                }

                swap(array, i + 1, high);
                return (i + 1);
        }


        static void quickSort(int[] array, int low, int high) {
                if (low < high) {
                        // pi is partitioning index, arr[p]
                        // is now at right place
                        int pi = partition(array, low, high);

                        // Separately sort elements before
                        // partition and after partition
                        quickSort(array, low, pi - 1);
                        quickSort(array, pi + 1, high);
                }
        }

        static void printArray(int[] arr, int size)
        {
                for(int i = 0; i < size; i++)
                        System.out.print(arr[i] + " ");

                System.out.println();
        }

        static void heapify(int[] a, int n, int i)
        {
                int largest = i; // Initialize largest as root
                int left = 2 * i + 1; // left child
                int right = 2 * i + 2; // right child
                // If left child is larger than root
                if (left < n && a[left] > a[largest])
                        largest = left;
                // If right child is larger than root
                if (right < n && a[right] > a[largest])
                        largest = right;
                // If root is not largest
                if (largest != i) {
                        // swap a[i] with a[largest]
                        int temp = a[i];
                        a[i] = a[largest];
                        a[largest] = temp;

                        heapify(a, n, largest);
                }
        }
        /*Function to implement the heap sort*/
        static void heapSort(int[] a, int n)
        {
                for (int i = n / 2 - 1; i >= 0; i--)
                        heapify(a, n, i);

                // One by one extract an element from heap
                for (int i = n - 1; i >= 0; i--) {
                        /* Move current root element to end*/
                        // swap a[0] with a[i]
                        int temp = a[0];
                        a[0] = a[i];
                        a[i] = temp;

                        heapify(a, i, 0);
                }
        }
        /* function to print the array elements */
        static void printArr(int[] a, int n)
        {
                for (int i = 0; i < n; ++i)
                        System.out.print(a[i] + " ");
        }


        static void merge(int[] a, int beg, int mid, int end)
        {
                int i, j, k;
                int n1 = mid - beg + 1;
                int n2 = end - mid;

                /* temporary Arrays */
                int[] LeftArray = new int[n1];
                int[] RightArray = new int[n2];

                /* copy data to temp arrays */
                for (i = 0; i < n1; i++)
                        LeftArray[i] = a[beg + i];
                for (j = 0; j < n2; j++)
                        RightArray[j] = a[mid + 1 + j];

                i = 0; /* initial index of first sub-array */
                j = 0; /* initial index of second sub-array */
                k = beg;  /* initial index of merged sub-array */

                while (i < n1 && j < n2)
                {
                        if(LeftArray[i] <= RightArray[j])
                        {
                                a[k] = LeftArray[i];
                                i++;
                        }
                        else
                        {
                                a[k] = RightArray[j];
                                j++;
                        }
                        k++;
                }
                while (i<n1)
                {
                        a[k] = LeftArray[i];
                        i++;
                        k++;
                }

                while (j<n2)
                {
                        a[k] = RightArray[j];
                        j++;
                        k++;
                }
        }

        public static void mergeSort(int[] a, int beg, int end)
        {
                if (beg < end)
                {
                        int mid = (beg + end) / 2;
                        mergeSort(a, beg, mid);
                        mergeSort(a, mid + 1, end);
                        merge(a, beg, mid, end);
                }
        }

        public static void printMergeArray(int a[], int n)
        {
                int i;
                for (i = 0; i < n; i++)
                        System.out.print(a[i] + " ");
        }


        public static void selectionSort(int[] arr)
        {
                int n = arr.length;

                // One by one move boundary of unsorted subarray
                for (int i = 0; i < n-1; i++)
                {
                        // Find the minimum element in unsorted array
                        int min_idx = i;
                        for (int j = i+1; j < n; j++)
                                if (arr[j] < arr[min_idx])
                                        min_idx = j;

                        // Swap the found minimum element with the first
                        // element
                        int temp = arr[min_idx];
                        arr[min_idx] = arr[i];
                        arr[i] = temp;
                }
        }

        // Prints the array
        public static void printSelectionArray(int[] arr)
        {
                int n = arr.length;
                int i=0;
                while (i<n) {
                        System.out.print(arr[i]+" ");
                        ++i;
                }
                System.out.println();
        }

        public static int getMax(int a[], int n) {
                int max = a[0];
                for(int i = 1; i<n; i++) {
                        if(a[i] > max)
                                max = a[i];
                }
                return max; //maximum element from the array
        }

        public static void countingSort(int a[], int n, int place) // function to implement counting sort
        {
                int[] output = new int[n+1];
                int[] count = new int[10];

                // Calculate count of elements
                for (int i = 0; i < n; i++)
                        count[(a[i] / place) % 10]++;

                // Calculate cumulative frequency
                for (int i = 1; i < 10; i++)
                        count[i] += count[i - 1];

                // Place the elements in sorted order
                for (int i = n - 1; i >= 0; i--) {
                        output[count[(a[i] / place) % 10] - 1] = a[i];
                        count[(a[i] / place) % 10]--;
                }

                for (int i = 0; i < n; i++)
                        a[i] = output[i];
        }

        // function to implement radix sort
        public static void radixSort(int a[], int n) {

                // get maximum element from array
                int max = getMax(a, n);

                // Apply counting sort to sort elements based on place value
                for (int place = 1; max / place > 0; place *= 10)
                        countingSort(a, n, place);
        }

        // function to print array elements
        public static void printRadixArray(int[] a, int n) {
                for (int i = 0; i < n; ++i)
                        System.out.print(a[i] + " ");
        }


}

