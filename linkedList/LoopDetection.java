// Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
// beginning of the loop.
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
// as to make a loop in the linked list.
// EXAMPLE
// Input: A -> B -> C - > D -> E -> C [the same C as earlier)
// Output: C


public LinkedListNode loopDetection(LinkedListNode node) {
	if (node == null || node.next == null) return null;
	LinkedListNode fast = node, slow = node;
	while (fast != null && slow != null) {
		fast = fast.next.next;
		slow = slow.next;
		if (fast == slow)break;
	}
	if (fast == null || slow == null) return null;
	slow = node;
	while (slow != fast) {
		slow = slow.next;
		fast = fast.next;
	}
	return fast;
}