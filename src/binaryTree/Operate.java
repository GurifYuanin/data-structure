package binaryTree;

public class Operate {
	// ����߶�
	static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	// ��д���
	static void fillDepth(Node root, int depth) {
		if (root != null) {
			root.depth = depth;
			fillDepth(root.left, depth + 1);
			fillDepth(root.right, depth + 1);
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
	
	// �༭Ҷ�ӽڵ�
	static void editLeaf(Node root) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				// ��Ҷ�ӽڵ���в���
			} else {
				if (root.left != null) {
					editLeaf(root.left);
				}
				if (root.right != null) {
					editLeaf(root.right);
				}
			}
		}
	}
}
