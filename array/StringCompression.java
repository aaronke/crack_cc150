// String Compression: Implement a method to perform basic string compression using the counts
// of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
// "compressed" string would not become smaller than the original string, your method should return
// the original string. You can assume the string has only uppercase and lowercase letters (a - z).

public String stringCompression(String str) {
	if (str == null || str.length() < 3) return str;
	int[] counter = new int[52];
	int len = str.length();
	for (int i = 0; i < len; i++) {
		char c = str.charAt(i);
		if (c - 'A' > 26) counter[c - 'a' + 26]++;
		else counter[c - 'A']++;
	}
	StringBuilder resBuilder = new StringBuilder();
	for (int i = 0; i < 26; i++) {
		char c = (char)(i + 'A');
		resBuilder.append(c);
		resBuilder.append(counter[i]);
	}
	for (int i = 26; i < 52; i++) {
		char c = (char)(i - 26 + 'a');
		resBuilder.append(c);
		resBuilder.append(counter[i]);
	}
	return resBuilder.toString();
}