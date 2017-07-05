import java.util.*;
public class Node implements Cloneable{
	/*
	@Override
	public Object clone(){
		try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	} */
	
	String label;
	Set<Node> neighbours;
	int incommingEdges;
	
	Node(String label){
		this.label = label;
		incommingEdges = 0;
		neighbours = new HashSet<>();
	}
	
	public void addNeighbour(Node n){
		this.neighbours.add(n);
		n.incIncomEdges();
		return;
	}
	
	public void removeNeighbour(Node n){
		n.decIncomEdges();
		this.neighbours.remove(n);
		return;
	}
	
	public void removeNeighbours(){
		Iterator<Node> it = neighbours.iterator();
		while(it.hasNext()){
			Node n = it.next();
			n.decIncomEdges();
			//this.neighbours.remove(n); // Concurrent modification exception
			it.remove();
		}
		/* // Concurrent modification exception
		for(Node n : neighbours){
			n.decIncomEdges();
			this.neighbours.remove(n);
		} */
		return;
	}
	
	public void incIncomEdges(){
		this.incommingEdges++;
		return;
	}
	
	public void decIncomEdges(){
		this.incommingEdges--;
		return;
	}
	
	public int numNeighbours(){
		return this.neighbours.size();
	}
	
	public Set<Node> getNeighbours(){
		return this.neighbours;
	}
	
	public String toString(){
		return label;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this)
			return true;
		if(! (o instanceof Node ))
			return false;
		Node n = (Node) o;
		return n.label.equals(this.label);
	}
	
	@Override
	public int hashCode(){
		int prime = 7;
		int result = 31;
		return result*prime + this.label.hashCode();
	}
	
}
