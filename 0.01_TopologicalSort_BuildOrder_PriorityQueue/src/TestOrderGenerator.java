
public class TestOrderGenerator {
	public static void main(String[] args){
		OrderGenerator seq1 = new OrderGenerator();
		seq1.addDependencies("f", "b");
		seq1.addDependencies("f", "c");
		seq1.addDependencies("f", "a");
		seq1.addDependencies("c", "a");
		seq1.addDependencies("b", "a");
		seq1.addDependencies("a", "e");
		seq1.addDependencies("b", "e");
		seq1.addDependencies("d", "g");
		
		seq1.generateOrder();
		
	}
	
}
