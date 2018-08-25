package stringSearch;

public class KMP {
	int find(char[] string, char[] pattern) {
		int[] next = getNext(string);
		int sLength = string.length, pLength = pattern.length;
		int i = 0, j = 0;
		while (i < sLength && j < pLength) {
			if (j == -1 || string[i] == pattern[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == pLength) {
			return i - j;
		} else {
			return -1;
		}
	}
	int[] getNext(char[] pattern) {
		int length = pattern.length;
		int[] result = new int[length];
		int prefix = -1, suffix = 0;
		result[0] = -1;
		while (suffix < length - 1) {
			if (prefix == -1 || pattern[prefix] == pattern[suffix]) {
				prefix++;
				suffix++;
				result[suffix] = prefix;
			} else {
				prefix = result[prefix];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String source = "abcjsdjada";
		String pattern = "js";
		KMP kmp = new KMP();
		int index = kmp.find(source.toCharArray(), pattern.toCharArray());
		System.out.println(source);
		System.out.println(pattern);
		System.out.println(index);
	}
}
