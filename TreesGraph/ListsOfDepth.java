// List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
// at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).

public ArrayList<LinkedNode> listOfDepths(TreeNode root) {
	if(root == null) return null;
	Queue<Node> queue = new LinkedList<>();
	ArrayList<LinkedNode> result = new ArrayList<>();
	queue.enqueue(root);
	int levelSize = 1;
	while (!queue.isEmpty()) {
		LinkedNode dummyNode = new LinkedNode(0);
		int nextSize = 0;
		for (int i = 0; i < levelSize; i++) {
			TreeNode node = queue.dequeue();
			dummyNode.next = new LinkedNode(node.val);
			if (node.left) {
				queue.enqueue(node.left);
				nextSize++;
			}
			if (node.right) {
				queue.enqueue(node.right);
				nextSize++;
			}
		}
		if (dummyNode.next != null)result.add(dummyNode.next);
		levelSize = nextSize;
	}
	return result;
}