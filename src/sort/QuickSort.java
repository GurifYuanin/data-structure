package sort;

/* *
 * ��������
 * 	�������Ϊ�����֣���߲��ֵ�ֵС�� tmp���ұ߲��ֵ�ֵ���� tmp
 * 	Ȼ����εݹ�
 * */

// �¼����Ӷ� = O(nlog2n)
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
