package binaryTree;

class Node {
	int data; // 节点数据
	int factor; // 平衡因子(左子树高度 - 右子树高度)
	int depth; // 节点深度
	Node left = null; // 左孩子
	Node right = null; // 右孩子
	Node(int data) {
		this.data = data;
	}
}
