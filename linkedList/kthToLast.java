// Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.

public LinkedListNode KthToLast(LinkedListNode root, int k) {
	if (root == null) throw InvalidParameterException("invalid root node")
	LinkedListNode cur = root, fast = root;
	for (int i = 0; i < k; i++) {
		if (fast == null) throw InvalidParameterException("linked list length is smaller than" + k);
		fast = fast.next;
	}
	while (fast) {
		cur = cur.next;
		fast = fast.next;
	}
	return cur;
}