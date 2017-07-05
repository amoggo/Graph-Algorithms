import java.util.*;

public class OrderGenerator {
	Graph g;
	OrderGenerator(){
		g = new Graph();
	}
	
	public void addDependencies(String proj1, String proj2){
		g.addEdge(proj1, proj2);
	}
	
	public void generateOrder(){
		StringBuilder order = new StringBuilder();
		Queue<Node> pq = new PriorityQueue<>(g.mem.size(), new Comparator<Node>(){
			
			 public int compare(Node a, Node b){
				return a.incommingEdges - b.incommingEdges;
			}
			
		});
		
		Set<Map.Entry<String, Node>> set = g.mem.entrySet();
		for( Map.Entry<String, Node> i : set){
			pq.add(i.getValue());
		}
		System.out.println(pq);
		
		while(! pq.isEmpty()){
			Node curr = pq.poll();
			if(curr.incommingEdges != 0){
				System.out.println("Order not possible");
				return;
			}
			
			order.append(curr.label).append(" ");
			Set<Node> nodeSet = curr.getNeighbours();
			g.removeOutgoingEdges(curr.label);
			for(Node n: nodeSet){
				pq.remove(n);
				pq.add(n);
			}
		}
		System.out.println(order.toString());
		return;
	}
}
