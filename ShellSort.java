public class ShellSort<T extends Comparable<T>> /* Added "<T extends Comparable<T>>" */{
	/* An utility function to print array of size n */
	static <T> /*added "<T>"*/void printArray(T /*changed type of arr to T*/arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/* function to sort arr using shellSort */
	int sort(T/*changed type of arr to T*/ arr[]) {
		int n = arr.length;

		// Start with a big gap, then reduce the gap
		for (int gap = n / 2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1) {
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				//changed type of temp variable to T
				T temp = arr[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				//used compareTo function instead of all relational operators because we are working with objects
				for (j = i; j >= gap && arr[j - gap].compareTo(temp) > 0; j -= gap)
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				arr[j] = temp;
			}
		}
		return 0;
	}

	public static void main(String args[]) {
		//Changed type of arr from int to Integer
		Integer arr[] = { 12, 34, 54, 2, 3, 9 };
		System.out.println("Array before sorting");
		printArray(arr);
		ShellSort<Integer> ob = new ShellSort<>();
		ob.sort(arr);
		System.out.println("Array after sorting");
		printArray(arr);
	}
}
