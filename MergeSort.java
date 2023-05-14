
public class MergeSort<T extends Comparable<T>> /* Added "<T extends Comparable<T>>" */ {

	// Driver method
	public static void main(String args[]) {
		//Changed type of arr from int to Integer
		Integer arr[] = { 12, 34, 54, 2, 3 };
		System.out.println("Array before sorting");
		printArray(arr);
		MergeSort<Integer> ob = new MergeSort<>();
		ob.mergeSort(arr);
		System.out.println("Array after sorting");
		printArray(arr);
	}

	static /*added "<T>"*/<T> void printArray(T /*changed type of arr to T*/arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Places the elements of the given array into sorted order
	// using the merge sort algorithm.
	// post: array is in sorted (nondecreasing) order
	public void mergeSort(T[]/*changed type of arr to T*/ array) {
		if (array.length > 1) {
			// split array into two halves
			//changed type of left and right array from int to T
			T[] left = leftHalf(array);
			T[] right = rightHalf(array);
			// recursively sort the two halves
			mergeSort(left);
			mergeSort(right);
			// merge the sorted halves into a sorted whole
			merge(array, left, right);
		}
	}

	// Returns the first half of the given array.
	public /*added "<T>"*/T[] leftHalf(T[]/*changed type of arr to T*/ array) {
		int size1 = array.length / 2;
		//changed type of left array to T and cast a new comparable object with T[]
		T[] left = (T[]) new Comparable[size1];
		for (int i = 0; i < size1; i++) {
			left[i] = array[i];
		}
		return left;
	}

	// Returns the second half of the given array.
	public /*Changed*/T[] rightHalf(T[] /*changed type of arr to T*/array) {
		int size1 = array.length / 2;
		int size2 = array.length - size1;
		//changed type of right array to T and cast a new comparable object with T[]
		T[] right = (T[]) new Comparable[size2];
		for (int i = 0; i < size2; i++) {
			right[i] = array[i + size1];
		}
		return right;
	}

	// Merges the given left and right arrays into the given
	// result array. Second, working version.
	// pre : result is empty; left/right are sorted
	// post: result contains result of merging sorted lists;
	public void merge(T[] result, T[] left, T[] right)/*changed type of all three arrays in the parameter to T*/ {
		int i1 = 0; // index into left array
		int i2 = 0; // index into right array
		for (int i = 0; i < result.length; i++) {
			if (i2 >= right.length || (i1 < left.length && left[i1].compareTo(right[i2]) <= 0)) {
				result[i] = left[i1]; // take from left
				i1++;
			} else {
				result[i] = right[i2]; // take from right
				i2++;
			}
		}
	}
}
