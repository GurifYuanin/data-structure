package binaryTree;
public class AVL {
	// ��дƽ������
	static int fillFactor(Node root) {
		int factor;
		if (root == null) {
			factor = -1; // �涨null�ڵ��ƽ������Ϊ-1
		} else {
			factor = fillFactor(root.left) - fillFactor(root.right);
			root.factor = factor;
		}
		return factor;
	}
	
	// LL�͵���ƽ���������rootΪ��С��ƽ����������ƽ������������������ĸ��������ص�����ĸ��ڵ�
	static Node LL(Node root) {
		// ����ָ��
		Node result = root.left;
		root.left = result.right;
		result.right = root;
		// ����ƽ������
		root.factor -= 2;
		result.factor -= 1;
		return result;
	}
	
	// ���ݸ߶��ж��Ƿ�ƽ��
	static boolean isBalance(Node root) {
		return Math.abs(Operate.getHeight(root.left) - Operate.getHeight(root.right)) < 2;
	}
}
