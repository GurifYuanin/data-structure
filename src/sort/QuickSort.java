package sort;

/* *
 * 快速排序
 * 	将数组分为两部分，左边部分的值小于 tmp，右边部分的值大于 tmp
 * 	然后分治递归
 * */

// 事件复杂度 = O(nlog2n)
public class QuickSort {
	public static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int tmpStart = start, tmpEnd = end, tmp = arr[start];
			while (start < end) {
				while (start < end && arr[end] >= tmp) end--;
				arr[start] = arr[end];
				while (start < end && arr[start] <= tmp) start++;
				arr[end] = arr[start];
			}
			arr[start] = tmp;
			sort(arr, tmpStart, start - 1);
			sort(arr, start + 1, tmpEnd);
		}
	}

}
