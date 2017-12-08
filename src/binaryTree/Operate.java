package binaryTree;

public class Operate {
	// 计算高度
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
	
	// 填写深度
	static void fillDepth(Node root, int depth) {
		if (root != null) {
			root.depth = depth;
			fillDepth(root.left, depth + 1);
			fillDepth(root.right, depth + 1);
		}
	}
	
	// 复制二叉树
	static Node copy(Node root) {
		Node result = null;
		if (root != null) {
			result = new Node(root.data);
			result.left = copy(root.left);
			result.right = copy(root.right);
		}
		return result;
	}
	
	// 编辑叶子节点
	static void editLeaf(Node root) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				// 对叶子节点进行操作
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
