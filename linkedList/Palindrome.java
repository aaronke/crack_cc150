// Palindrome: Implement a function to check if a linked list is a palindrome.

public boolean isPalindrome(LinkedListNode node) {
	if (node == null) return true;
	LinkedListNode head = node;
	while (head != null) {
		if (head.val != node.val) return false;
		head = head.next;
		node = node.next;
	}
	return true;
}

private LinkedListNode reverseList(LinkedListNode node) {
	if (node == null || node.next == null) return;
	LinkedListNode pre = null, cur = node, head = cur;
	while (node != null) {
		cur.next = pre;
		pre = cur;
		cur = cur.next; 
	}
	return head;
}