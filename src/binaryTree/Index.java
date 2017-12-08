package binaryTree;
import java.util.Random;
public class Index {
	public static void main(String[] args) {
		Random ran = new Random();
		int nodeNum = 10;
		int[] data = new int[nodeNum];
		int max = 100;
		// 生成二叉树值
		for (int i = 0; i < nodeNum; i++) {
			data[i] = ran.nextInt(max);
		}
		Node root;
		
	}
}
class Node {
	int data; // 节点数据
	int factor; // 平衡因子
	Node left; // 左孩子
	Node right; // 右孩子
	Node(int data) {
		this.data = data;
	}
}
