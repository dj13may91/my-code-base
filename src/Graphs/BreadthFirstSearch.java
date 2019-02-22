package Graphs;

import java.util.LinkedList;

public class BreadthFirstSearch {

    private int vertexCount;
    private LinkedList<Integer> edges[];

    BreadthFirstSearch(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edges = new LinkedList[this.vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int edge) {
        edges[vertex].add(edge);

        // if graph is not directed
        edges[edge].add(vertex);
    }

    public void BFS(int start) {
        boolean visited[] = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (queue.size() > 0) {
            start = queue.poll();
            System.out.println("Got: " + start);
            edges[start].forEach((edge) -> {
                if (!visited[edge]) {
                    visited[edge] = true;
                    queue.add(edge);
                }
            });
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        System.out.println("BFS when starting from edge: 3");

        bfs.BFS(3);
    }
}

/**
 * Output:
 BFS when starting from edge: 3
 Got: 3
 Got: 2
 Got: 0
 Got: 1
 */
