package binaryTree;

import java.util.Random;

public class LineTree {
	/*
	 * �߶���
	 * 	(��ƽ���������������ʱ���ҷ�Ҷ�ڵ�ӵ��������ȵ�Ҷ��)
	 *  (Ҷ�ӽڵ��ʾһ��������Ҷ�ڵ��ʾһ�����ݷ�Χ)
	 * 	1��Ҷ�ӽڵ������ݣ���Ҷ�ڵ���ɸѡ������ݣ��������������ֵ���͵ȵȣ�
	 * 	2����������������ʾ��i �ڵ������Ϊ 2 * i + 1 ���Һ���Ϊ 2 * i + 2
	 * */
	int[] date; // ��������
	int[] tree; // �߶���
	void init(int length, int max) {
		/*
		 *  length�����ݳ���
		 *  max����������ֵ
		 */
		Random ran = new Random();
		date = new int[length];
		tree = new int[4 * length];
		for(int i = 0; i < length; i++) {
			date[i] = ran.nextInt(max);
		}
	}
	void create (int index, int start, int end) {
		/*
		 * index���������� / ��ǰ�ڵ㣨tree[index]��
		 * start / end����ǰ�ڵ�����ݷ�Χ��date[start ~ end]��
		 * */
		if (start == end) {
			// �����Ҷ�ӽڵ�
			tree[index] = date[start]; // ֱ�Ӹ�Ҷ�ڵ㸳ֵ
		} else {
			// �������Ҷ�ӽڵ�
			int mid = (start + end) / 2; // �� date ��Ϊ����������
			create(index * 2 + 1, start, mid); // �� start ~ mid ��Χ�����ݹҵ�������
			create(index * 2 + 2, mid + 1, end); // �� mid + 1 ~ end ��Χ�����ݹҵ��Һ�����
			tree[index] = Math.max(tree[index * 2 + 1], tree[index * 2 + 2]); // ѡ���Եظ���Ҷ�ڵ㸳ֵ
		}
	}
	int query(int index, int queryStart, int queryEnd, int dateStart, int dateEnd) {
		/*
		 * ���ܣ����� date �� dateStart ~ dateEnd �����ֵ
		 * index����ǰ�ڵ㣨tree[index]��
		 * queryStart / queryEnd��Ҫ��ѯ�ķ�Χ��date[queryStart ~ queryEnd]��
		 * dateStart / dateEnd����ǰ�ڵ�����ݷ�Χ��date[dateStart ~ dateEnd]��
		 * */
		if (queryStart > dateEnd || queryEnd < dateStart) {
			// ���Ҫ���ҵķ�Χ���ٽڵ㷶Χ��
			return Integer.MIN_VALUE;
		}
		if (queryStart <= dateStart && queryEnd >= dateEnd){
			// ����ڵ㷶Χ��Ҫ���ҷ�Χ���Ӽ�
			return tree[index];
		}
		// ���Ҫ���ҵķ�Χ��ڵ�ķ�Χ����
		int mid = (dateStart + dateEnd) / 2;
		return Math.max(query(2 * index + 1, queryStart, queryEnd, dateStart, mid), query(2 * index + 2, queryStart, queryEnd, mid + 1, dateEnd));
	}
	void update(int index, int start, int end, int target, int value) {
		/*
		 * ���ܣ����� date[target] Ϊ value
		 * index����ǰ�ڵ㣨tree[index]��
		 * start / end����ǰ�ڵ�����ݷ�Χ��date[start ~ end]��
		 * target��Ŀ������������date[target]��
		 * value�����º������
		 * */
		if (start == end) {
			// �����Ҷ�ӽڵ�
			if (start == target) {
				// �����Ҫ���µĽڵ�
				tree[index] = value;
			}
		} else {
			// �������Ҷ�ӽڵ㣬���µݹ�
			int mid = (start + end) / 2;
			if (target <= mid) {
				// ���Ŀ��ڵ���������
				update(2 * index + 1, start, mid, target, value);
			} else {
				// ���Ŀ��ڵ���������
				update(2 * index + 2, mid + 1, end, target, value);
			}
			// ��������������Ϻ󣬸�������ڵ�
			tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
		}
	}
	void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LineTree instance = new LineTree();
		int root = 0, length = 10, max = 10;
		int start = 0, end = 3;
		instance.init(length, max); // ��ʼ�����ݣ���ֵ�������
		instance.create(root, root, length - 1); // �����߶���
		instance.printArr(instance.date); // ���������һ��
		System.out.println(instance.tree[root]); // ������ڵ�ֵ�����������е����ֵ��
		System.out.println(instance.query(root, start, end, root, length - 1)); // ����� start �� end �����ֵ
	}
}
