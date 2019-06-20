import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] numbers = {3,5,7,12,99,9,22,53,1,13,79};
		System.out.println(binarySearch(numbers, 13));
		
		int[] numbers2 = {1,2,3,4,5,6,7,8,9,22,23,26,30};
		System.out.println(recursiveBinarySearch(numbers2,26, numbers2[0], numbers2.length-1));

	}
	
	/**
	 * 
	 * @param arr Array on int
	 * @param target target number
	 * @return {int} index of target value
	 */
	private static Integer binarySearch(int[] arr, int target) {
		Arrays.sort(arr);
		int first = 0;
		int last = arr.length -1;
		while(first <= last) {
			int midpoint = (first + last) /2;
			if(arr[midpoint] == target) {
				return midpoint;
			} else if (arr[midpoint] < target) {
				first = midpoint +1;
			} else {
				last = midpoint -1;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param input arrary number
	 * @param target target number
	 * @param start starting point of arrary
	 * @param end end point of arrary
	 * @return {int} target
	 */
	private static int recursiveBinarySearch(int[] input, int target, int start, int end) {
        if (start > end) {
            return -1;
        } else {
            int mid = start + (end - start) / 2;

            if (target < input[mid]) {
                return recursiveBinarySearch(input, target, start, mid);
            } else if (target > input[mid]) {
                return recursiveBinarySearch(input, target, mid+1, end);
            } else {
                return mid;
            }
        }
    }

}
