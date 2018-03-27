package leetcode;

/**
 * 557. Reverse Words in a String III Given a string, you need to reverse the
 * order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 * 
 * Example 1: Input: "Let's take LeetCode contest" Output:
 * "s'teL ekat edoCteeL tsetnoc"
 * 
 * Note: In the string, each word is separated by single space and there will
 * not be any extra space in the string.
 * 
 * @author liaominghui
 * 
 */
public class ReverseWords {
	public static String reverseWords(String s) {
		char[] c = s.toCharArray();
		char[] reversedArray = new char[c.length];
		int j = 0;
		for (int i = 0; i < c.length; i++) {
			int k = i;
			if (c[i] == ' ') {
				while (k - 1 >= 0 && c[k - 1] != ' ') {
					reversedArray[j] = c[k - 1];
					k--;
					j++;
				}
				reversedArray[j] = ' ';
				j++;

			}
			if (i == c.length - 1) {
				while (k >= 0 && c[k] != ' ') {
					reversedArray[j] = c[k];
					k--;
					j++;
				}
			}
		}
		String reversedWords = String.valueOf(reversedArray);
		return reversedWords;
	}

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

}
