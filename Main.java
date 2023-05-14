public class Main<T extends Comparable<T>> {

	public static void main(String[] args) {
		// created 4 arrays for testing each of the 4 sorting methods
		Integer[] arr1 = { 13, 44, 27, 4, 0, 9, 18, 7, -4, 25 };
		Integer[] arr2 = { 13, 4, -27, 4, 0, 999, 18, 7, -4, 25 };
		Integer[] arr3 = { 13, 100, 27, 4, 0, -96, 18, 7, -4, 89 };
		Integer[] arr4 = { 3, 1, 2, -3, 90, -8, -7, 7, 40, 55 };

		// Checks if merge sort worked on arr1
		System.out.println("MERGE SORT TEST ON ARR1");
		System.out.println("-----------------------------------------");
		System.out.println("Array before sorting");
		printArray(arr1);
		MergeSort<Integer> mergeTest = new MergeSort<>();
		mergeTest.mergeSort(arr1);
		System.out.println("Sorted array is");
		printArray(arr1);
		testArray(arr1);

		// Checks if heap sort worked on arr2
		System.out.println("HEAP SORT TEST ON ARR2");
		System.out.println("-----------------------------------------");
		System.out.println("Array before sorting");
		printArray(arr2);
		HeapSort<Integer> heapTest = new HeapSort<>();
		heapTest.sort(arr2);
		System.out.println("Sorted array is");
		printArray(arr2);
		testArray(arr2);

		// Checks if quick sort worked on arr3
		System.out.println("QUICK SORT TEST ON ARR3");
		System.out.println("-----------------------------------------");
		System.out.println("Array before sorting");
		printArray(arr3);
		QuickSort<Integer> quickTest = new QuickSort<>();
		quickTest.quickSort(arr3);
		System.out.println("Sorted array is");
		printArray(arr3);
		testArray(arr3);

		// Checks if shell sort worked on arr4
		System.out.println("SHELL SORT TEST ON ARR4");
		System.out.println("-----------------------------------------");
		System.out.println("Array before sorting");
		printArray(arr4);
		ShellSort<Integer> shellTest = new ShellSort<>();
		shellTest.sort(arr4);
		System.out.println("Sorted array is");
		printArray(arr4);
		testArray(arr4);
		

	}

	public static <T> void printArray(T arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static <T> void testArray(T arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (((Comparable<T>) arr[i]).compareTo(arr[i + 1]) > 0) {
				System.out.println("This array is NOT properly sorted");
				System.out.println();
				return;
			}
		}

		System.out.println("This array is properly sorted");
		System.out.println();

	}

}