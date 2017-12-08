package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	int size = 0;
	int[][] path = null; // 节点距离，-1表示不连通
	int[] weight = null; // 节点权重，初始为0
	boolean[] isVisited = null;
	Graph(int size) {
		this.size = size;
		path = new int[size][size];
		weight = new int[size];
		isVisited = new boolean[size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(path[i], -1);
		}
		Arrays.fill(weight, 0);
		Arrays.fill(isVisited, false);
	}
	
	// 深度优先搜索
	void DFS(int index) {
		System.out.println(weight[index]);
		isVisited[index] = true;
		for (int i = 0; i < size; i++) {
			if (!isVisited[i] && path[index][i] >= 0) {
				DFS(i);
			}
		}
	}
	
	// 广度优先搜索
	void BFS(int index){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(index);
		while (!list.isEmpty()) {
			index = list.remove();
			for (int i = 0; i < size; i++) {
				if (!isVisited[i] && path[index][i] > 0) {
					list.add(i);
				}
			}
			System.out.println(weight[index]);
		}
	}
}
