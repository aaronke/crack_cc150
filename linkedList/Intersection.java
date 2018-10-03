// Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
// node. Note that the intersection is defined based on reference, not value. That is, if the kth
// node of the first linked list is the exact same node (by reference) as the jth node of the second
// linked list, then they are intersecting.

public LinkedListNode intersection(LinkedListNode node1, LinkedListNode node2) {
	if (node1 == null || node2 == null) return null;
	HashSet<LinkedListNode> set = HashSet<>();
	while (node2 != null) {
		set.add(node2);
		node2 = node2.next;
	}
	while (node1 != null) {
		if (set.contains(node1)) return node1;
		node1 = node1.next;
	}
	return null;
}