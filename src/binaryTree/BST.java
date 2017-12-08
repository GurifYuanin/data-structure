package binaryTree;

public class BST {
	static Node preCreateBST(Node root, int data) {
		// 先序创建二叉排序树
		if (root == null) {
			root = new Node(data);
		} else {
			if (data < root.data) {
				root.left = preCreateBST(root.left, data);
			} else {
				root.right  = preCreateBST(root.right, data);
			}
		}
		return root;
	}
}
