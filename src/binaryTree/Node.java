package binaryTree;

class Node {
	int data; // �ڵ�����
	int factor; // ƽ������(�������߶� - �������߶�)
	int depth; // �ڵ����
	Node left = null; // ����
	Node right = null; // �Һ���
	Node(int data) {
		this.data = data;
	}
}
