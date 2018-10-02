// Sum Lists: You have two numbers represented by a linked list, where each node contains a single
// digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
// function that adds the two numbers and returns the sum as a linked list.
// EXAMPLE
// Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .Thatis,617 + 295.
// Output: 2 -) 1 -) 9. That is, 912.
// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem.
// EXAMPLE
// Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).Thatis,617 + 295.
// Output: 9 -) 1 -) 2. That is, 912.

public int sumLists(LinkedListNode node1, LinkedListNode node2) {
	if (node1 == null && node2 == null) return 0;
	int sum = 0; // will it overflow?
	int multiple = 1;
	while (node1 != null || node2 != null) {
		int digit_sum = 0;
		if (node1 != null) {
			digit_sum += node1.val;
			node1 = node1.next;
		}
		if (node2 != null) {
			digit_sum += node2.val;
			node2 = node2.next;
		}
		sum += multiple * digit_sum;
		multiple *= 10;
	}
	return sum;
}

// Follow up
public int sumLists2(LinkedListNode node1, LinkedListNode node2) {
	reverseList(node1);
	reverseList(node2);
	return sumLists(node1, node2);
}

private void reverseList(LinkedListNode node) {
	if (node == null || node.next == null) return;
	LinkedListNode pre = null;
	while (node != null) {
		node.next = pre;
		pre = node;
		node = node.next; 
	}
}


