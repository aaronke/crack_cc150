
// building a graph
public class Graph {
	private ArrayList<Project> nodes = new ArrayList<>();
	private HashMap<String, Project> map = new HashMap<>();

	public Project getOrGenerateNode(String name) {
		if (!map.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}

	public void addEdge(String a, String b) {
		Project nodeA = map.get(a);
		Project nodeB = map.get(b);
		nodeA.addNeighbor(nodeB);
	} 

	public ArrayList<Project> getNodes() {
		return ndoes;
	}

}