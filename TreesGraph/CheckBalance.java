// Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
// this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
// node never differ by more than one.

public boolean checkBalance(TreeNode root) {
	return getTreeHeight(root) != Integer.MIN_VALUE;
}

private int getTreeHeight(TreeNode root) {
	if (root == null) {
		return 0;
	}
	int leftHeight = getTreeHeight(root.left);
	if (leftHeight == Integer.MIN_VALUE) {
		return Integer.MIN_VALUE;
	}
	int rightHeight = getTreeHeight(root.right);
	if (rightHeight == Integer.MIN_VALUE) {
		return Integer.MIN_VALUE;
	}
	return Math.max(leftHeight, rightHeight) + 1;
}