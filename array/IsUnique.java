// Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
// cannot use additional data structures?

public boolean isUnique(String str) {
	if (str == null || str.length <= 1) return true;
	int len = str.length();
	int[] counter = new int[128];
	for (int i = 0; i < len; i++) {
		char c = str.charAt(i);
		int asc = (int)c
		if (counter[asc] > 0) return false;
		else counter[asc] = 1;
	}
	return true;
}
