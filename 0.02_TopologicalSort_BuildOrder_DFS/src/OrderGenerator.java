
public class OrderGenerator {
	Graph g;
	
	OrderGenerator(){
		g = new Graph();
	}
	
	public void addDependencies(String proj1, String proj2){
		g.addEdge(proj1, proj2);
	}
	
	public void generateOrder(){
		String result = g.topologicalSort();
		System.out.println(result);
		return;
	}
	
}
