package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Graph {
	final int UNCONNECT = Integer.MAX_VALUE; // 不连通距离
	int size;
	int[][] path = null; // 节点距离
	int[] weight = null; // 节点权重，初始为 0
	int[] collect = null; // 从某一点出发，到其余各点的所经过的权重之和
	int[] pre = null; // 从某一点出发，到其余各点的最短路径前驱
	int[] dis = null; // 从某一点出发，到其余各点的最短距离
	boolean[] isVisited = null; // index 节点是否已经遍历
	
	// 初始化
	Graph(int size) {
		this.size = size;
		path = new int[size][size];
		weight = new int[size];
		collect = new int[size];
		pre = new int[size];
		dis = new int[size];
		isVisited = new boolean[size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(path[i], UNCONNECT); // 初始情况所有点都不连通
			pre[i] = i; // 前驱是自己，表示没有前驱
		}
		Arrays.fill(weight, 0); // 初始权重为 0
		Arrays.fill(collect, 0); // 权重和也为 0
		Arrays.fill(dis, UNCONNECT); // 距离为不连通
		Arrays.fill(isVisited, false); // 所有节点都没有便利过
	}
	// 随机生成无向图、权重数组
	void init(int max) {
		Random ran = new Random();
		for (int i = 0; i < size; i++) {
			path[i][i] = 0;
			weight[i] = ran.nextInt(max);
			for (int j = i + 1; j < size; j++) {
				path[i][j] = path[j][i] = ran.nextInt(max);
			}
		}
	}
	// 打印路径表
	void printPath() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// 深度优先搜索
	void DFS(int index) {
		System.out.println(index); // 对当前遍历的节点进行操作
		isVisited[index] = true; // 标志当前节点为已经遍历过
		for (int i = 0; i < size; i++) {
			if (!isVisited[i] && path[index][i] >= 0) {
				DFS(i);
			}
		}
	}
	
	// 从 index 节点开始广度优先搜索
	void BFS(int index){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(index);
		while (!list.isEmpty()) {
			index = list.remove();
			System.out.println(index);
			isVisited[index] = true;
			for (int i = 0; i < size; i++) {
				if (!isVisited[i] && path[index][i] < UNCONNECT) {
					list.add(i);
				}
			}
		}
	}
	
	// 带权的迪杰斯特拉算法，计算出指定点到其余点的最短路径
	 void dijkstra(int index) {
		 // 初始化
		 Arrays.fill(isVisited, false); // 此时 isVisited 用来标志指定点是否已经找到最短路径
		 Arrays.fill(dis, UNCONNECT);
		 Arrays.fill(pre, index);
		 Arrays.fill(collect, 0);
		 dis[index] = 0; // 自身到自己的距离为0
		 collect[index] = weight[index]; // 至少收集到了自身的权重
		 for (int i = 0, min = UNCONNECT; i < size; i++, min = UNCONNECT) {
			 // 找出从开始点出发到达的未确认的最短距离的点
			 for (int j = 0; j < size; j++) {
				 if (!isVisited[j] && min > dis[j]) {
					 min = dis[j];
					 index = j;
				 }
			 }
			 isVisited[index] = true; // 标记当前点为已确认的最短路径
			 for (int j = 0; j < size; j++) {
				 if (!isVisited[j] && path[index][j] < UNCONNECT) { // 如果已经确定最短路径或者不连通，则跳过
					 if (dis[j] > dis[index] + path[index][j] || (dis[j] == dis[index] + path[index][j] && collect[j] < collect[index] + weight[j])) {
						 // 出发点直接到 j 的路径 > 出发点直接到 index + index 到 j 的路径
						 // 或者相等的情况下，出发点直接到 j 收集到的权重 > 出发点直接到 index + j 的权重
						 collect[j] = collect[index] + weight[j];
						 dis[j] = dis[index] + path[index][j];
						 pre[j] = index;
					 }
				 }
			 }
		 }
		 System.out.println("dijkstra：");
		 for (int i : dis) {
			 System.out.print(i + " ");
		 }
	 }
	 // spfa 算法，可以解决带负权的路径或节点
	 void spfa(int index) {
		 // 初始化
		 Arrays.fill(isVisited, false); // isVisited 表示是否已经入队
		 Arrays.fill(dis, UNCONNECT);
		 Arrays.fill(pre, index);
		 Arrays.fill(collect, 0);
		 LinkedList<Integer> list = new LinkedList<Integer>();
		 list.add(index);
		 isVisited[index] = true;
		 // 寻找最短路径
		 while (!list.isEmpty()) {
			 int tmp = list.remove();
			 isVisited[tmp] = false;
			 for (int i = 0; i < size; i++) {
				 if (path[tmp][i] < UNCONNECT && (dis[i] > dis[tmp] + path[tmp][i] || dis[i] == dis[tmp] + path[tmp][i] && collect[i] < collect[tmp] + weight[i])) {
					 dis[i] = dis[tmp] + path[tmp][i];
					 collect[i] = collect[tmp] + weight[i];
					 pre[i] = tmp;
					 if (!isVisited[i]) {
						 list.add(i);
						 isVisited[i] = true;
					 }
				 }
			 }
		 }
		
	 }
	 public static void main(String[] args) {
		 Graph g = new Graph(10); // 图的尺寸
		 g.init(10); // 路径最大值
		 g.printPath(); // 打印路径
		 g.dijkstra(0); // 通过迪杰斯特拉求 0 节点到其他点的最短路径
	 }
}
