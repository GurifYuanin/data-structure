package stringSearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularPattern {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("bcd"); // 编译正则表达式
		Matcher result = pattern.matcher("abcdefg"); // 进行匹配得到匹配结果
		System.out.println("是否查找得到：" + result.find());
		System.out.println("startIndex：" + result.start());
		System.out.println("endIndex：" + (result.end() - 1));
	}
}
