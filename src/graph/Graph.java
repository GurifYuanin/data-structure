package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Graph {
	final int UNCONNECT = Integer.MAX_VALUE; // ����ͨ����
	int size;
	int[][] path = null; // �ڵ����
	int[] weight = null; // �ڵ�Ȩ�أ���ʼΪ 0
	int[] collect = null; // ��ĳһ�������������������������Ȩ��֮��
	int[] pre = null; // ��ĳһ��������������������·��ǰ��
	int[] dis = null; // ��ĳһ�������������������̾���
	boolean[] isVisited = null; // index �ڵ��Ƿ��Ѿ�����
	
	// ��ʼ��
	Graph(int size) {
		this.size = size;
		path = new int[size][size];
		weight = new int[size];
		collect = new int[size];
		pre = new int[size];
		dis = new int[size];
		isVisited = new boolean[size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(path[i], UNCONNECT); // ��ʼ������е㶼����ͨ
			pre[i] = i; // ǰ�����Լ�����ʾû��ǰ��
		}
		Arrays.fill(weight, 0); // ��ʼȨ��Ϊ 0
		Arrays.fill(collect, 0); // Ȩ�غ�ҲΪ 0
		Arrays.fill(dis, UNCONNECT); // ����Ϊ����ͨ
		Arrays.fill(isVisited, false); // ���нڵ㶼û�б�����
	}
	// �����������ͼ��Ȩ������
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
	// ��ӡ·����
	void printPath() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// �����������
	void DFS(int index) {
		System.out.println(index); // �Ե�ǰ�����Ľڵ���в���
		isVisited[index] = true; // ��־��ǰ�ڵ�Ϊ�Ѿ�������
		for (int i = 0; i < size; i++) {
			if (!isVisited[i] && path[index][i] >= 0) {
				DFS(i);
			}
		}
	}
	
	// �� index �ڵ㿪ʼ�����������
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
	
	// ��Ȩ�ĵϽ�˹�����㷨�������ָ���㵽���������·��
	 void dijkstra(int index) {
		 // ��ʼ��
		 Arrays.fill(isVisited, false); // ��ʱ isVisited ������־ָ�����Ƿ��Ѿ��ҵ����·��
		 Arrays.fill(dis, UNCONNECT);
		 Arrays.fill(pre, index);
		 Arrays.fill(collect, 0);
		 dis[index] = 0; // �����Լ��ľ���Ϊ0
		 collect[index] = weight[index]; // �����ռ����������Ȩ��
		 for (int i = 0, min = UNCONNECT; i < size; i++, min = UNCONNECT) {
			 // �ҳ��ӿ�ʼ����������δȷ�ϵ���̾���ĵ�
			 for (int j = 0; j < size; j++) {
				 if (!isVisited[j] && min > dis[j]) {
					 min = dis[j];
					 index = j;
				 }
			 }
			 isVisited[index] = true; // ��ǵ�ǰ��Ϊ��ȷ�ϵ����·��
			 for (int j = 0; j < size; j++) {
				 if (!isVisited[j] && path[index][j] < UNCONNECT) { // ����Ѿ�ȷ�����·�����߲���ͨ��������
					 if (dis[j] > dis[index] + path[index][j] || (dis[j] == dis[index] + path[index][j] && collect[j] < collect[index] + weight[j])) {
						 // ������ֱ�ӵ� j ��·�� > ������ֱ�ӵ� index + index �� j ��·��
						 // ������ȵ�����£�������ֱ�ӵ� j �ռ�����Ȩ�� > ������ֱ�ӵ� index + j ��Ȩ��
						 collect[j] = collect[index] + weight[j];
						 dis[j] = dis[index] + path[index][j];
						 pre[j] = index;
					 }
				 }
			 }
		 }
		 System.out.println("dijkstra��");
		 for (int i : dis) {
			 System.out.print(i + " ");
		 }
	 }
	 // spfa �㷨�����Խ������Ȩ��·����ڵ�
	 void spfa(int index) {
		 // ��ʼ��
		 Arrays.fill(isVisited, false); // isVisited ��ʾ�Ƿ��Ѿ����
		 Arrays.fill(dis, UNCONNECT);
		 Arrays.fill(pre, index);
		 Arrays.fill(collect, 0);
		 LinkedList<Integer> list = new LinkedList<Integer>();
		 list.add(index);
		 isVisited[index] = true;
		 // Ѱ�����·��
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
		 Graph g = new Graph(10); // ͼ�ĳߴ�
		 g.init(10); // ·�����ֵ
		 g.printPath(); // ��ӡ·��
		 g.dijkstra(0); // ͨ���Ͻ�˹������ 0 �ڵ㵽����������·��
	 }
}
