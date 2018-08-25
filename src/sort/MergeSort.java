package sort;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {
	static int[] tmp;
	static int revNumber = 0;
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int length = sca.nextInt();
		int max = sca.nextInt();
		int[] arr = init(length, max);
		tmp = new int[length];
		printArr(arr);
		sort(arr, 0, length - 1);
		printArr(arr);
		System.out.println("逆序数：" + revNumber);
		sca.close();
	}
	static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	static void merge(int[] arr, int start, int mid, int end) {
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				tmp[k] = arr[i];
				i++;
			} else {
				tmp[k] = arr[j];
				// 统计逆序数
				revNumber += (mid - i + 1);
				j++;
			}
			k++;
		}
		while (i <= mid) {
			tmp[k++] = arr[i++];
		}
		while(j <= end) {
			tmp[k++] = arr[j++];
		}
		for (i = 0; i < k; i++) {
			arr[start + i] = tmp[i];
		}
	}
	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	static int[] init(int length, int max) {
		int[] result = new int[length];
		Random ran = new Random();
		for (int i = 0; i < length; i++) {
			result[i] = ran.nextInt(max);
		}
		return result;
	}
}
