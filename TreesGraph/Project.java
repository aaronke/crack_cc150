// Create Project class for BuildOrder

public class Project {

	private ArrayList<Project> children = new ArrayList<>();
	private HashMap<String, Project> map = new HashMap<>();
	private String name;
	private int denpendenciesNumber = 0;

	public Projct(String name) {
		this.name = name;
	}

	public void addNeighbor(Project node) {

		if(!map.containsKey(node.getName())) {
			children.add(node);
			map.put(node.getName(), node);
		}
	}

	public void getName() {
		return name;
	}

	public void incrementDependencies() {
		denpendenciesNumber++;
	}

	public void decrementDependencies() {
		denpendenciesNumber--;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}

	public int getDependenciesNumber() {
		return getDependenciesNumber;
	}
}