package binaryTree;

public class BST {
	static Node preCreateBST(Node root, int data) {
		// ���򴴽�����������
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
