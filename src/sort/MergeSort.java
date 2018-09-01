package sort;

/**
 * �鲢���򣺽����������ϲ�Ϊһ�������
 * 	1����������Ϊ�����֣�ÿ���ֶ�����Ϊ����
 * 	2���ϲ���������Ϊһ������
 * */

// �¼����Ӷ� = O(nlog2n)

public class MergeSort {
	static int revNumber = 0; // ����������������£���Ҫ���ٽ������ٴΣ�����Ԫ�ؽ�����
	
	static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	static void merge(int[] arr, int start, int mid, int end) {
		int[] tmp = new int[arr.length]; // ��ʱ����
		// i Ϊ��һ��������±�
		// j Ϊ�ڶ���������±�
		// k Ϊ��ʱ������±�
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			tmp[k++] = arr[i] <= arr[j] ?
					   arr[i++] :
					   arr[j++] ;
			if (arr[i] > arr[j]) {
				revNumber += (mid - i + 1); // ͳ��������	
			}
		}
		while (i <= mid) { tmp[k++] = arr[i++]; }
		while(j <= end) { tmp[k++] = arr[j++]; }
		
		// ������õ���ʱ���鿽����Դ����
		for (i = 0; i < k; i++) {
			arr[start + i] = tmp[i];
		}
	}
}
