package binaryTree;

public class BST {
	static Node create(Node root, int data) {
		// 先序创建二叉排序树
		if (root == null) {
			root = new Node(data);
		} else {
			if (data < root.data) {
				root.left = create(root.left, data);
			} else {
				root.right  = create(root.right, data);
			}
		}
		return root;
	}
	
}
