package sort;


/* *
 * 插入排序：
 * 假设存在有序数组：（EMPTY 表示空位置）
 * {EMPTY, 2, 4, 6, 8, 10}
 * 现在要插入一个数字 5，按照插入排序的思路，其做法为：
 * 	1、挪动元素位置 {2, 4, EMPTY, 6, 8, 10}
 * 	2、将 5 插入到 EMPTY 的位置上
 * */

/* *
 * 事件复杂度 = O(n²)
 * */
public class InsertSort {
	// 升序
	public static void sort (int[] arr) {
		int tmp, j;
		for (int i = 0; i < arr.length; i++) {
			tmp = arr[i];
			j = i - 1;
			while (j > 0 && tmp < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = tmp;
		}
		tmp = arr[0];
		for (j = 1; j < arr.length && tmp > arr[j]; j++) {
			arr[j - 1] = arr[j];
		}
		arr[j - 1] = tmp;
	}
}
