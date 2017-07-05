
public class TestOrderGenerator {
	public static void main(String[] args){
		OrderGenerator seq1 = new OrderGenerator();
		seq1.addDependencies("f", "b");
		seq1.addDependencies("f", "c");
		seq1.addDependencies("f", "a");
		seq1.addDependencies("c", "a");
		seq1.addDependencies("b", "a");
		seq1.addDependencies("b", "h");
		seq1.addDependencies("a", "e");
		seq1.addDependencies("b", "e");
		seq1.addDependencies("d", "g");
		
		seq1.generateOrder();
		
		OrderGenerator seq2 = new OrderGenerator();
		seq2.addDependencies("f", "b");
		seq2.addDependencies("f", "c");
		seq2.addDependencies("f", "a");
		seq2.addDependencies("c", "a");
		seq2.addDependencies("b", "a");
		seq2.addDependencies("b", "h");
		seq2.addDependencies("a", "e");
		seq2.addDependencies("h", "f"); // Cycle
		seq2.addDependencies("b", "e");
		seq2.addDependencies("d", "g");
		
		seq2.generateOrder();
	}
}
