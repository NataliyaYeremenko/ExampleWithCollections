package ua.kharkiv.yeremenko.exCollections.part4;

public class Edge implements Comparable {
    private int startVertex;
    private int endVertex;

    public Edge(int startVertex, int endVertex) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof Edge))
            return false;
        Edge entry = (Edge) obj;
        return ((startVertex == entry.startVertex) && (endVertex == entry.endVertex));
        }

    public int hashCode(){
        int hash = 37;
        hash = hash*17 + startVertex;
        hash = hash*17 + endVertex;
        return hash;
    }

    @Override
    public int compareTo(Object obj) {
        Edge entry = (Edge) obj;
        int result = startVertex - entry.startVertex;
        if (result != 0) return (result/Math.abs(result));
        result = endVertex - entry.endVertex;
        return result;
    }

    @Override
    public String toString() {
        String edge = "(" + startVertex + ", " + endVertex + ")";
        return edge;
    }
}
