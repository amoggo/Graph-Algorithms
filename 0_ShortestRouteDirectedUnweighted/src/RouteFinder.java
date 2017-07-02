import java.util.*;
/*
 * > BFS
 * > Directed Graph
 * > UnWeighted Graph
 */

public class RouteFinder implements Graph{
	private class Node{
		List<Integer> neighbours;
		Node(){
			neighbours = new ArrayList<>();
		}
	}
	
	private Node[] graph;
	private int vertexNum;
	
	RouteFinder(int vertexNum){
		if(vertexNum <= 0)
			throw new IllegalArgumentException("Invalid Number of Vertices");
		this.vertexNum = vertexNum;
		graph = new Node[vertexNum+1]; // 0th index in array is going to remain unused.
		
		for(int i=1; i<= vertexNum; i++){
			graph[i] = new Node();
		}
	}
	
	public void addEdge(int source, int dest){
		if(!isValidVertex(source) || !isValidVertex(dest))
			throw new IllegalArgumentException("Source or Dest vertex entered is Invalid");
		// Allows for multiple edges from same source and destination (is Not a simple graph)

		graph[source].neighbours.add(dest); 
		return;
	}
	
	public boolean isValidVertex(int vertex){
		if(vertex > 0 && vertex <= this.vertexNum)
			return true;
		return false;
	}
	
	public String findRoute(int source, int dest){
		if(!isValidVertex(source) || !isValidVertex(dest))
			throw new IllegalArgumentException("Source or Dest vertex entered is Invalid");
		
		StringBuilder[] tracker = new StringBuilder[vertexNum+1];
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[vertexNum+1];
		
		queue.addLast(source);
		tracker[source] = new StringBuilder();
		tracker[source].append(source);
		
		while(!queue.isEmpty()){
			int current = queue.poll();
			visited[current] = true; 
			List<Integer> curList = graph[current].neighbours;
			
			for(Integer i : curList){
				if(visited[i])
					continue;
				
				if(i == dest){
					return tracker[current].append("->").append(i).toString();
				}
				tracker[i] = new StringBuilder();
				tracker[i].append(tracker[current]).append("->").append(i);
				visited[i] = true;
				queue.add(i);
			}
		}
		System.out.println("Route Does Not Exist !!");
		return "\b";
	}
	
}
