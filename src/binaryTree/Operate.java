package binaryTree;

public class Operate {
	// ����߶�
	static int countHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = countHeight(root.left);
		int rightHeight = countHeight(root.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	// ���ƶ�����
	static Node copy(Node root) {	
		Node result = null;
		if (root != null) {
			result = new Node(root.data);
			result.left = copy(root.left);
			result.right = copy(root.right);
		}
		return result;
	}
}
