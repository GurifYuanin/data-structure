package binaryTree;
import java.util.Random;
public class Index {
	public static void main(String[] args) {
		Random ran = new Random();
		int nodeNum = 10;
		int[] data = new int[nodeNum];
		int max = 100;
		// ���ɶ�����ֵ
		for (int i = 0; i < nodeNum; i++) {
			data[i] = ran.nextInt(max);
		}
		Node root;
		
	}
}
class Node {
	int data; // �ڵ�����
	int factor; // ƽ������
	Node left; // ����
	Node right; // �Һ���
	Node(int data) {
		this.data = data;
	}
}
