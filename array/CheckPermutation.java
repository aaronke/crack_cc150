// Check Permutation: Given two strings, write a method to 
// decide if one is a permutation of the other.

public boolean checkPermutation(String a, String b) {
	if (a == null || b == null) return false;
	int[] counter = new int[128];
	int aLen = a.length();
	int bLen = b.length();
	for (int i = 0; i < aLen; i++) {
		int asc = (int)a.charAt(i);
		counter[asc]++;
	}
	for (int i = 0; i < bLen; i++) {
		int asc = (int)b.charAt(i);
		if (counter[asc] <= 0) return false;
		else counter[asc]--;
	}
	for (int i = 0; i < counter.length; i++) {
		if (counter[i] != 0) return false;
	}
	return true;
}