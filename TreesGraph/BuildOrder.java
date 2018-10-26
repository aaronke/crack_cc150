// Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
// projects, where the second project is dependent on the first project). All of a project's dependencies
// must be built before the project is. Find a build order that will allow the projects to be built. If there
// is no valid build order, return an error.
// EXAMPLE
// Input:
// projects: a, b, c, d, e, f
// dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
// Output: f, e, a, b, d, c

public class BuildOrder {

	public Projects[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderPorjects(graph.getNodes());
	}

	private Project[] orderPorjects(ArrayList<Project> projects) {
		Project[] result = new Project[projects.size()];
		int toBeProcessed = 0;
		int endOfList = addNonDependencies(result, projects, 0);

		while (toBeProcessed < result.length) {
			Project current = result[toBeProcessed];
			// There is a dependency cycle, unable to build the order
			if (current == null) return null;

			for (Project project in current.getChildren()) {
				project.decrementDependencies();
			}
			endOfList = addNonDependencies(result, projects, endOfList);
			toBeProcessed++;
		}

	} 

	private int addNonDependencies(Project[] result, ArrayList<Project> projects, int index) {
		if (index >= result.length || index < 0) {
			Throw new IllegalArgumentException("input parameter index is out of range");
		}
		for (Project project : projects) {
			if (project.getDependenciesNumber == 0) {
				result[index++] = project;
			}
		}
		return index;
	}

	private Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : Projects) {
			graph.gerOrCreateNode(project);
		}
		for (String[] pair : dependencies) {
			String first = pair[0];
			String second = pair[1];
			graph.addEdge(first, second);
		}
		return graph;
	}
}