package binaryTree;
public class AVL {
	// 填写平衡因子
	static int fillFactor(Node root) {
		int factor;
		if (root == null) {
			factor = -1; // 规定null节点的平衡因子为-1
		} else {
			factor = fillFactor(root.left) - fillFactor(root.right);
			root.factor = factor;
		}
		return factor;
	}
	
	// LL型调整平衡二叉树，root为最小不平衡子树（不平衡子树中最深的子树的根），返回调整后的根节点
	static Node LL(Node root) {
		// 调整指针
		Node result = root.left;
		root.left = result.right;
		result.right = root;
		// 调整平衡因子
		root.factor -= 2;
		result.factor -= 1;
		return result;
	}
	
	// 根据高度判断是否平衡
	static boolean isBalance(Node root) {
		return Math.abs(Operate.getHeight(root.left) - Operate.getHeight(root.right)) < 2;
	}
}
