package stringSearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularPattern {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("bcd"); // ����������ʽ
		Matcher result = pattern.matcher("abcdefg"); // ����ƥ��õ�ƥ����
		System.out.println("�Ƿ���ҵõ���" + result.find());
		System.out.println("startIndex��" + result.start());
		System.out.println("endIndex��" + (result.end() - 1));
	}
}
