package sort;

/**
 * 归并排序：将两个有序表合并为一个有序表
 * 	1、将数组拆分为两部分，每部分都整理为有序
 * 	2、合并这两部分为一个数组
 * */

// 事件复杂度 = O(nlog2n)

public class MergeSort {
	static int revNumber = 0; // 存在逆序数的情况下，需要至少交换多少次（相邻元素交换）
	
	static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	static void merge(int[] arr, int start, int mid, int end) {
		int[] tmp = new int[arr.length]; // 临时数组
		// i 为第一个数组的下标
		// j 为第二个数组的下标
		// k 为临时数组的下标
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			tmp[k++] = arr[i] <= arr[j] ?
					   arr[i++] :
					   arr[j++] ;
			if (arr[i] > arr[j]) {
				revNumber += (mid - i + 1); // 统计逆序数	
			}
		}
		while (i <= mid) { tmp[k++] = arr[i++]; }
		while(j <= end) { tmp[k++] = arr[j++]; }
		
		// 将整理好的临时数组拷贝给源数组
		for (i = 0; i < k; i++) {
			arr[start + i] = tmp[i];
		}
	}
}
