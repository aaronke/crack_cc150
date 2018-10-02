// One Away: There are three types of edits that can be performed on strings: insert a character,
// remove a character, or replace a character. Given two strings, write a function to check if they are
// one edit (or zero edits) away.

public boolean oneWay(String a, String b) {
	if (a == null || b == null) return false;
	int aLen = a.length();
	int bLen = b.length();
	if (Math.abs(aLen - bLen) > 1) return false;
	return oneWayHelper(a.toCharArray(), 0, b.toCharArray(), 0, 0)
}

private boolean oneWayHelper(char[] aChars, char[] bChars, int aS, int bS, int count) {
	if (count > 1) return false;
	int aLen = aChars.length();
	int bLen = aChars.length();
	if (Math.abs((aLen - aS)- (bLen - bS)) > 1) return false;
	while (aS < aLen && bS < bLen) {
		if (aChars[aS] == bChars[bS]){
			aS++;
			bS++;
		} else {
			return oneWayHelper(aChars, bChars, aS++, bS++, count++)
					|| oneWayHelper(aChars, bChars, aS++, bS, count++)
					|| oneWayHelper(aChars, bChars, aS, bS++, count++);
		}
	}
	if (aS == aLen && bS == bLen) return true;
	return false;
}