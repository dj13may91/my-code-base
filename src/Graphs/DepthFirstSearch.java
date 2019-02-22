package Graphs;

import java.util.LinkedList;

public class DepthFirstSearch {

    private int vertexCount;
    private LinkedList<Integer> edges[];

    DepthFirstSearch(int vertexCount) {
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

    public void DfsUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.println(start);
        System.out.println("start " + start + " edge list is : " + edges[start]);
        for (boolean b : visited) {
            System.out.print(b + ", ");
        }
        System.out.println();
        int head = 0;
        while (edges[start].size() > head) {
            if (!visited[edges[start].get(head)]) {
                start = edges[start].get(head);
                System.out.println("setting start to : " + start + ", Calling dfs for " + start);
                DfsUtil(start, visited);
            }
            head++;
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(7);
        depthFirstSearch.addEdge(0, 1);
        depthFirstSearch.addEdge(0, 2);
        depthFirstSearch.addEdge(1, 3);
        depthFirstSearch.addEdge(1, 4);
        depthFirstSearch.addEdge(2, 4);
        depthFirstSearch.addEdge(3, 4);
        depthFirstSearch.addEdge(3, 5);
        depthFirstSearch.addEdge(4, 6);

        depthFirstSearch.DfsUtil(0, new boolean[depthFirstSearch.vertexCount]);
        System.out.println();
    }
}
