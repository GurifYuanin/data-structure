package unionFind;

public class UF {
	private int number; // Ԫ����
	private int count; // ������
	private Element[] set;
	UF (Element[] set) {
		this.set = set;
		number = count = set.length;
	}
	// ��ʼ����ʹÿһ��Ԫ�طֱ��ڸ��Լ���
	// id => ���ڵļ��ϱ��
	// data => �洢������
	void init () {
		int length = set.length;
		for (int i = 0; i < length; i++) {
			set[i] = new Element(i);
			set[i].data = i;
		}
	}
	//  ���������±꣬�ж��Ƿ���ͬһ��������
	boolean isConnect (int index1, int index2) {
		return set[index1].id == set[index2].id;
	}
	// �����±꣬�������ڼ��ϱ��
	int getSetIndex (int index) {
		for (int i = set[index].id; i != index; i = set[index].id) {
			index = i;
		}
		return index;
	}
	// ��ü�����
	int getCount () {
		return count;
	}
	// ���������±꣬���������±���ָԪ�����ڵļ��Ϻϲ�����
	// ���鷽ʽ
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
	// ���������±꣬���������±���ָԪ�����ڵļ��Ϻϲ�����
	// ����ʽ
	void quickUnion (int index1, int index2) {
		int id1 = getSetIndex(index1);
		int id2 = getSetIndex(index2);
		if (id1 != id2) {
			set[id1].id = id2;
			count--;
		}
	}
}