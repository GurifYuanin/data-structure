package sort;

import java.util.Random;

public class Index {
	public static void chaosArray (int[] arr) {
		Random ran = new Random();
		for (int i = 0;i < arr.length; i++) {
			arr[i] = ran.nextInt(100);
		}
	}
	public static void printArray (int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String[] args) {
		int[] arr = new int[100];
		
		chaosArray(arr);
		QuickSort.sort(arr, 0, arr.length - 1);
		printArray(arr);
	}
}
