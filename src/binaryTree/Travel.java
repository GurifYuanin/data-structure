package binaryTree;

import java.util.LinkedList;

public class Travel {
	// 先序遍历 => DFS
	static void preTravel(Node root) {
		if (root != null) {
			System.out.print(root.data);
			preTravel(root.left);
			preTravel(root.right);
		}
	}
	
	// 后序遍历
	static void postTravel(Node root) {
		if (root != null) {
			postTravel(root.left);
			postTravel(root.right);
			System.out.print(root.data);
		}
	}
	
	// 广度优先搜索
	static void BFS(Node root) {	
		if (root != null) {
			Node tmp = null;
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(root);
			while (!list.isEmpty()) {
				tmp = list.remove();
				if (tmp.left != null) {
					list.add(tmp.left);
				}
				if (tmp.right != null) {
					list.add(tmp.right);
				}
				System.out.print(tmp.data);
			}
		}
	}

}
