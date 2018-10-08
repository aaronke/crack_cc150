// Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
// to create a binary search tree with minimal height.

public TreeNode minimalTree(int[] list) {
	if(list == null || list.length == 0) return null;
	return minimalTreeHelper(list, 0, list.length - 1);
}

private TreeNode minimalTreeHelper(int[] list, int startIndex, int endIndex) {
	if(startIndex >= endIndex || endIndex >= list.length || startIndex < 0) return null;
	int midIndex = Math.ceil((startIndex + endIndex)/2);
	TreeNode root = new TreeNode(list[midIndex]);
	root.left = minimalTreeHelper(list, startIndex, midIndex - 1);
	root.right = minimalTreeHelper(list, midIndex + 1, endIndex);
	return root;
}