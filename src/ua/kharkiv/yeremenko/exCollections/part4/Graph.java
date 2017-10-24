package ua.kharkiv.yeremenko.exCollections.part4;

import java.util.Set;
import java.util.TreeSet;

public class Graph {
    private final int N;
    private static Set<Edge> edgeSet = new TreeSet<>();

    Graph(int n){
        N = n;
    }

    Graph(){
        N=10;
    }

    public int getN() {
        return N;
    }

    public void addEdge(int start, int end){
        if (start > getN() || end > getN()) {
            System.out.println("Wrong input");
            return;
        }
        else {
            Edge newEdge = new Edge(start, end);
            if (!edgeSet.contains(newEdge)) {
                edgeSet.add(newEdge);
                System.out.println("Edge (" + start + ", " + end + ") add");
            } else {
                System.out.println("Edge (" + start + ", " + end + ") already exist");
            }
        }
    }

    public void deleteEdge(int start, int end){
        if (start > getN() || end > getN()) {
            System.out.println("Wrong input");
            return;
        }
        else {
            Edge newEdge = new Edge(start, end);
            if (edgeSet.contains(newEdge)) {
                edgeSet.remove(newEdge);
                System.out.println("Edge (" + start + ", " + end + ") removed");
            } else {
                System.out.println("Edge (" + start + ", " + end + ") isn't exist");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Edge edge:edgeSet) {
            sb.append(edge.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
