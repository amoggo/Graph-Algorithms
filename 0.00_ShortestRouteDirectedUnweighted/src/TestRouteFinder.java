
public class TestRouteFinder {
	public static void main(String[] args){
		
		System.out.println("Graph-1");
		RouteFinder graph1 = new RouteFinder(4);
		graph1.addEdge(1, 3);
		graph1.addEdge(3, 2);
		graph1.addEdge(1, 1);
		graph1.addEdge(1, 2);
		graph1.addEdge(2, 4);
		graph1.addEdge(4, 4);
		
		System.out.println(graph1.findRoute(2, 3));
		System.out.println(graph1.findRoute(3, 2));
		System.out.println(graph1.findRoute(3, 4));
		System.out.println(graph1.findRoute(1, 2));
		
		System.out.println();
		System.out.println("Graph-2");
		RouteFinder graph2 = new RouteFinder(9);
		graph2.addEdge(1, 2);
		graph2.addEdge(2, 8);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 4);
		graph2.addEdge(3, 6);
		graph2.addEdge(4, 5);
		graph2.addEdge(5, 6);
		graph2.addEdge(6, 4);
		graph2.addEdge(6, 7);
		graph2.addEdge(7, 8);
		graph2.addEdge(7, 9);
		graph2.addEdge(8, 1);
		graph2.addEdge(9, 3);
		graph2.addEdge(9, 8);
		
		System.out.println(graph2.findRoute(1, 9));
		System.out.println(graph2.findRoute(1, 8));

	}
}
