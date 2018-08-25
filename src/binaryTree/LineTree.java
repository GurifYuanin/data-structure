package binaryTree;

import java.util.Random;

public class LineTree {
	/*
	 * 线段树
	 * 	(是平衡二叉树，创建树时左右非叶节点拥有数量相等的叶子)
	 *  (叶子节点表示一个数，非叶节点表示一个数据范围)
	 * 	1、叶子节点存放数据，非叶节点存放筛选后的数据（左右子树的最大值、和等等）
	 * 	2、可以用数组来表示，i 节点的左孩子为 2 * i + 1 ，右孩子为 2 * i + 2
	 * */
	int[] date; // 数据数组
	int[] tree; // 线段树
	void init(int length, int max) {
		/*
		 *  length：数据长度
		 *  max：随机数最大值
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
		 * index：树的索引 / 当前节点（tree[index]）
		 * start / end：当前节点的数据范围（date[start ~ end]）
		 * */
		if (start == end) {
			// 如果是叶子节点
			tree[index] = date[start]; // 直接给叶节点赋值
		} else {
			// 如果不是叶子节点
			int mid = (start + end) / 2; // 将 date 分为左右两部分
			create(index * 2 + 1, start, mid); // 将 start ~ mid 范围的数据挂到左孩子上
			create(index * 2 + 2, mid + 1, end); // 将 mid + 1 ~ end 范围的数据挂到右孩子上
			tree[index] = Math.max(tree[index * 2 + 1], tree[index * 2 + 2]); // 选择性地给非叶节点赋值
		}
	}
	int query(int index, int queryStart, int queryEnd, int dateStart, int dateEnd) {
		/*
		 * 功能：查找 date 从 dateStart ~ dateEnd 的最大值
		 * index：当前节点（tree[index]）
		 * queryStart / queryEnd：要查询的范围（date[queryStart ~ queryEnd]）
		 * dateStart / dateEnd：当前节点的数据范围（date[dateStart ~ dateEnd]）
		 * */
		if (queryStart > dateEnd || queryEnd < dateStart) {
			// 如果要查找的范围不再节点范围内
			return Integer.MIN_VALUE;
		}
		if (queryStart <= dateStart && queryEnd >= dateEnd){
			// 如果节点范围是要查找范围的子集
			return tree[index];
		}
		// 如果要查找的范围与节点的范围交叉
		int mid = (dateStart + dateEnd) / 2;
		return Math.max(query(2 * index + 1, queryStart, queryEnd, dateStart, mid), query(2 * index + 2, queryStart, queryEnd, mid + 1, dateEnd));
	}
	void update(int index, int start, int end, int target, int value) {
		/*
		 * 功能：更新 date[target] 为 value
		 * index：当前节点（tree[index]）
		 * start / end：当前节点的数据范围（date[start ~ end]）
		 * target：目标数据索引（date[target]）
		 * value：更新后的数据
		 * */
		if (start == end) {
			// 如果是叶子节点
			if (start == target) {
				// 如果是要更新的节点
				tree[index] = value;
			}
		} else {
			// 如果不是叶子节点，向下递归
			int mid = (start + end) / 2;
			if (target <= mid) {
				// 如果目标节点在左子树
				update(2 * index + 1, start, mid, target, value);
			} else {
				// 如果目标节点在右子树
				update(2 * index + 2, mid + 1, end, target, value);
			}
			// 左右子树更新完毕后，更新自身节点
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
		instance.init(length, max); // 初始化数据（赋值随机数）
		instance.create(root, root, length - 1); // 创建线段树
		instance.printArr(instance.date); // 把数据输出一遍
		System.out.println(instance.tree[root]); // 输出根节点值（所有数据中的最大值）
		System.out.println(instance.query(root, start, end, root, length - 1)); // 输出从 start 到 end 的最大值
	}
}
