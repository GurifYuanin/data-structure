package binaryTree;
import java.util.Arrays;
import java.util.Scanner;
public class Create {
	static Scanner sca = new Scanner(System.in);
	// 先序创建二叉树
	static Node preCreate() {
		// 以“-1”作为null节点先序创建
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
	
	// 先序 + 中序遍历创建任意二叉树
	static Node preInoCreate(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		// 把先序遍历的第一个作为数据创建节点
		int data = preorder[0];
		Node root = new Node(data);
		// 找出中序遍历的下标
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (data == inorder[i]) {
				index = i;
				break;
			}
		}
		// 对先序、中序遍历进行切割
		int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
		int[] rightPre = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		int[] leftIno = Arrays.copyOfRange(inorder, 0, index);
		int[] rightIno = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		root.left = preInoCreate(leftPre, leftIno);
		root.right = preInoCreate(rightPre, rightIno);
		return root;
	}
}
