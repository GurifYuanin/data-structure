package binaryTree;
import java.util.Arrays;
import java.util.Scanner;
public class Create {
	static Scanner sca = new Scanner(System.in);
	// ���򴴽�������
	static Node preCreate() {
		// �ԡ�-1����Ϊnull�ڵ����򴴽�
		int data = sca.nextInt();
		Node root;
		if (data == -1) {
			root = null;
		} else {
			root = new Node(data);
			root.left = preCreate();
			root.right = preCreate();
		}
		return root;
	}
	
	// ���� + ��������������������
	static Node preInoCreate(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		// ����������ĵ�һ����Ϊ���ݴ����ڵ�
		int data = preorder[0];
		Node root = new Node(data);
		// �ҳ�����������±�
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (data == inorder[i]) {
				index = i;
				break;
			}
		}
		// ������������������и�
		int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
		int[] rightPre = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		int[] leftIno = Arrays.copyOfRange(inorder, 0, index);
		int[] rightIno = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		root.left = preInoCreate(leftPre, leftIno);
		root.right = preInoCreate(rightPre, rightIno);
		return root;
	}
}
