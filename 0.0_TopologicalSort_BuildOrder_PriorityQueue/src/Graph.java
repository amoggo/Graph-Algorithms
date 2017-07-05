import java.util.*;

public class Graph{
	
	Map<String, Node> mem;
	
	Graph(){
		mem = new HashMap<>();
	}
	
	public void addEdge(String source, String dest){
		if(source == null || source.length() == 0 || dest == null || dest.length() == 0)
			throw new IllegalArgumentException("Invalid input for source or destination of edge");
		
		if(! mem.containsKey(source)){
			mem.put(source, new Node(source));
		}
		if(! mem.containsKey(dest)){
			mem.put(dest, new Node(dest));
		}
		Node temp = mem.get(source);
		temp.addNeighbour( mem.get(dest));
		mem.put(source, temp);
		
		return;
	}
	
	public void removeEdge(String source, String dest){
		if(source == null || source.length() == 0 || dest == null || dest.length() == 0)
			throw new IllegalArgumentException("Invalid input for source or destination of edge");
		
		Node temp = mem.get(source);
		temp.removeNeighbour(mem.get(dest));
		mem.put(source, temp);
		return;
	}
	
	public void removeOutgoingEdges(String source){
		if(source == null || source.length() == 0)
			throw new IllegalArgumentException("Invalid input for source");
		
		Node temp = mem.get(source);
		temp.removeNeighbours();
		mem.put(source, temp);
		return;
	}
	
	public void removeEdge(String source, Iterator<Node> destListIt){
		if(source == null || source.length() == 0)
			throw new IllegalArgumentException("Invalid input for source of edge");
		
		while (destListIt.hasNext()){
			Node destNode = destListIt.next();
			Node sourceNode = mem.get(source);
			sourceNode.removeNeighbour(destNode);
		}
		
		return;
	}
	
	public Node getNode(String label){
		return mem.get(label);
	}
	
}
