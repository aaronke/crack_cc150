// Validate BST: Implement a function to check if a binary tree is a binary search tree


// Asume there is no duplicates in the binary tree
public boolean checkValidateBST(TreeNode root) {
	if (root == null) { 
		return true;
	}
	ArrayList<Integer> list = new ArrayList<>();
	inOrder(root, list);
	for (int i = 1; i < list.size(); i++) {
		if (list.get(i) <= list.get(i - 1)) {
			return false;
		}
	}
	return true;
}

private void inOrder(TreeNode root, ArrayList<Integer> list) {
	if (root) {
		return;
	}
	inOrder(root.left, list);
	list.add(root.val);
	inOrder(root.right, list);
}

// Min, Max solution

public boolean checkValidateBST2(TreeNode root) {
	return checkValidateHelper(root, null, null);
}

private boolean checkValidateHelper(TreeNode root, Integer min, Integer max) {
	if(root == null) return true;
	if((min != null && root.val <= min) || (max != null && root.val >= max))
		return false;
	if (!checkValidateHelper(root.left, min, root.val) || checkValidateHelper(root.right, root.val, max)) {
		return false;
	}
	return true;
}
