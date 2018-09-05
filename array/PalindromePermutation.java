// Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phrase that is the same forwards and backwards. A permutation
// is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
// EXAMPLE
// Input: Tact Coa
// Output: True (permutations: "taco cat". "atco cta". etc.)

public boolean palindromePermutation(String str) {
	if (str == null || str.length <= 1) return true;
	int[] counter = new int[128];
	str = str.toLowerCase();
	int len = str.length();
	for (int i = 0; i < len; i++) {
		int asc = (int)str.charAt(i);
		counter[asc]++;
	}
	int oddCount = 0;
	for (int i = 0; i < 128; i++) {
		if (counter[i] % 2 != 0) oddCount++;
		if (oddCount > 1) return false;
	}
	return true;
}