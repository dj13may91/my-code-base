package Graphs;

import java.util.LinkedList;

public class DijkstraShortestPath {

    private int vertexCount;
    private LinkedList<Integer> edges[];

    DijkstraShortestPath(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edges = new LinkedList[this.vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int edge) {
        edges[vertex].add(edge);

//        if graph is not directed
//        edges[edge].add(vertex);
    }

    public static void main(String[] args) {
        // todo
    }
}
