// Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
// binary search tree. You may assume that each node has a link to its parent.

public TreeNode inOrderSuccessor(TreeNode node) {
	if (node == null) {
		return null;
	}
	// Find the most left on the right subTree
	if (node.right != null) {
		return mostLeftNode(node);
	}

	// Find the parent until 
	TreeNode cur = node;
	TreeNode par = cur.parent;
	while (par != null && par.left != cur) {
		cur = par;
		par = par.parent;
	}
	return par;
}

private TreeNode mostLeftNode(TreeNode node) {
	if (node == null) {
		return null;
	}

	while (node.left != null) {
		node = node.left;
	}
	return node;
}