import java.util.*;

public class Graph {
	Map<String, Node> mem;
	
	Graph(){
		mem = new HashMap<>();
	}
	
	public void addEdge(String source, String dest){
		if(source == null || source.length() == 0 || dest == null || dest.length() == 0)
			throw new IllegalArgumentException("Invalid Source or Destination inputs");
		
		if(! mem.containsKey(source)){
			mem.put(source, new Node(source));
		}
		if(! mem.containsKey(dest)){
			mem.put(dest, new Node(dest));
		}
		
		Node n = mem.get(source);
		n.addOutNeigh(mem.get(dest));
		mem.put(source, n);
		
		return;
	}
	
	public String topologicalSort(){
		Deque<String> stack = new ArrayDeque<>();
		
		for(Map.Entry<String, Node> e: mem.entrySet()){
			String result = topoDfs(e.getValue(), stack);
			if(result != null)
				return result;
		}
		return stack.toString();
	}
	
	private String topoDfs(Node node, Deque<String> stack){
		String result = null;
		
		if(node.getState() == NodeState.VISITED)
			return result;
		if(node.getState() == NodeState.VISITING)
			return "Cannot create a Project Order. Cycle Detected.";
		
		node.setState(NodeState.VISITING);
		Set<Node> outNeighbours = node.getOutNeighbours();
		for(Node n: outNeighbours){
			result = topoDfs(n, stack);
			if(result != null)
				return result;
		}
		
		stack.push(node.getLabel());
		node.setState(NodeState.VISITED);
		return result;
	}
}






























