package ua.kharkiv.yeremenko.exCollections.part4;

public class Part4 {
	private static final int N = 15;
	public static void main(String[] args) {
		Graph graph = new Graph(N);
		for (int i = 1; i <= N; i++){
			graph.addEdge(i, i+2);
		}
		System.out.println("*****Graph.toString()*****");
		System.out.println(graph.toString());
		System.out.println("**********");
		graph.deleteEdge(2, 4);
		graph.deleteEdge(6, 7);
		graph.deleteEdge(10, 12);
		graph.deleteEdge(2, 4);
		graph.deleteEdge(3, 4);
		System.out.println("*****Graph.toString()*****");
		System.out.println(graph.toString());
	}

}
