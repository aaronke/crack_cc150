// Remove Dups: Write code to remove duplicates from an unsorted linked list.
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?

public void removeDuplicates(LinkedListNode root) {
	HashSet<Integer> map = new HashSet<>();
	LinkedListNode pre = root, cur = root;
	while (cur) {
		if (map.contains(cur.val)) {
			pre.next = cur.next;
		} else {
			map.add(cur);
			pre = cur;
		}
		cur = cur.next;
	}
}

// Follow up

public void removeDuplicates2(LinkedListNode root) {
	if (root == null || root.next == null) return;
	LinkedListNode cur = root, iNode = cur.next, pre = root;
	while (cur && cur.next) {
		while (iNode) {
			if (cur.val == iNode.val) {
				pre.next = cur.next;
			} else {
				pre = iNode;
			}
			iNode = iNode.next;
		}
		cur = cur.next;
		pre = cur;
		iNode = cur.next;
	}
}