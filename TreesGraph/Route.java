// Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
// route between two nodes.

// BFS
public boolean routeBetweenNodesBFS(Node node1, Node node2) {
	if(node1 == null || node2 == null) return false;
	Queue<Node> queue = new LinkedList<>();
	queue.add(node1);
	while (!queue.isEmpty()) {
		Node curNode = queue.dequeue();
		if (curNode == node2) {
			return true;
		}
		curNode.visit = true;
		for (Node node in curNode.adjacent) {
			if (!node.visit) {
				queue.enqueue(node);
			}
		}
	}
	return false;
}

// DFS
public boolean routeBetweenNodesDFS(Node node1, Node node2) {
	return searchDFS(node1, node2);
}

private boolean searchDFS(Node node1, Node node2) {
	if (node1 == null || node2 == null) {
		return false;
	}
	if (node1 == node2) {
		return true;
	}
	node1.visit = true;
	for (Node node in node1.adjacent) {
		if (!node.visit && searchDFS(node, node2)) {
			return true;
		}
	}
	return false;
}