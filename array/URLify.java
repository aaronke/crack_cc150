// URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
// has sufficient space at the end to hold the additional characters, and that you are given the "true"
// length of the string. (Note: If implementing in Java, please use a character array so that you can
// perform this operation in place.)
// EXAMPLE
// Input: "Mr John Smith "J 13
// Output: "Mr%20J ohn%20Smith"
public String urlify(String str,int len) {
	char[] chars = new char[len];
	int sLen = str.length();
	int index = 0;
	boolean bSpace = false;
	for (int i = 0; i < sLen; i++) {
		c = str.charAt(i);
		if (c != ' ') {
			chars[index++] = c;
			bSpace = false;
		} else {
			if (!bSpace) {
				bSpace = true;
				appendHelper(chars, index, "%20");
			}
		}
	}
}

public void appendHelper(char[] chars, int index, String s) {
	if (s == null || s.length == 0) return;
	int len = s.length();
	for (int i = 0; i < len && index < len; i++) {
		chars[index++] = s.charAt(i);
	}
}