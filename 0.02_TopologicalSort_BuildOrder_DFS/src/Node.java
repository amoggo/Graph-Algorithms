import java.util.*;
public class Node {
	private String label;
	private Set<Node> outNeighbours;
	private NodeState state;
	
	Node(String label){
		this.label = label;
		outNeighbours = new HashSet<Node>();
		state = NodeState.UNVISITED;
	}
	
	public void addOutNeigh(Node n){
		outNeighbours.add(n);
	}
	
	public void delOutNeigh(Node n){
		outNeighbours.remove(n);
	}
	
	public Set<Node> getOutNeighbours(){
		return this.outNeighbours;
	}
	
	public void setState(NodeState state){
		this.state = state;
	}
	
	public NodeState getState(){
		return this.state;
	}
	
	public String getLabel(){
		return label;
	}
	
	public String toString(){
		return label;
	}
}
