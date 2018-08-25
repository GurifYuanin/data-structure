package unionFind;

public class UF {
	private int number; // 元素数
	private int count; // 集合数
	private Element[] set;
	UF (Element[] set) {
		this.set = set;
		number = count = set.length;
	}
	// 初始化，使每一个元素分别在各自集合
	// id => 所在的集合编号
	// data => 存储的数据
	void init () {
		int length = set.length;
		for (int i = 0; i < length; i++) {
			set[i] = new Element(i);
			set[i].data = i;
		}
	}
	//  给定两个下标，判断是否在同一个集合内
	boolean isConnect (int index1, int index2) {
		return set[index1].id == set[index2].id;
	}
	// 给定下标，返回所在集合编号
	int getSetIndex (int index) {
		for (int i = set[index].id; i != index; i = set[index].id) {
			index = i;
		}
		return index;
	}
	// 获得集合数
	int getCount () {
		return count;
	}
	// 给定两个下标，将这两个下标所指元素所在的集合合并起来
	// 数组方式
	void union (int index1, int index2) {
		if (!isConnect(index1, index2)) {
			int id1 = set[index1].id;
			int id2 = set[index2].id;
			for (int i = 0; i < number; i++) {
				if (set[i].id == id2) {
					set[i].id = id1;
				}
			}
			count--;
		}
	}
	// 给定两个下标，将这两个下标所指元素所在的集合合并起来
	// 树方式
	void quickUnion (int index1, int index2) {
		int id1 = getSetIndex(index1);
		int id2 = getSetIndex(index2);
		if (id1 != id2) {
			set[id1].id = id2;
			count--;
		}
	}
}