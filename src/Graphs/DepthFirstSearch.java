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
        System.out.println("\ncurrent visit: " + start);
        System.out.print("start: " + start + ", edge list is : " + edges[start] + "\nvisited array: ");
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

/**
 Output :
 current visit: 0
 start: 0, edge list is : [1, 2]
 visited array: true, false, false, false, false, false, false,
 setting start to : 1, Calling dfs for 1

 current visit: 1
 start: 1, edge list is : [0, 3, 4]
 visited array: true, true, false, false, false, false, false,
 setting start to : 3, Calling dfs for 3

 current visit: 3
 start: 3, edge list is : [1, 4, 5]
 visited array: true, true, false, true, false, false, false,
 setting start to : 4, Calling dfs for 4

 current visit: 4
 start: 4, edge list is : [1, 2, 3, 6]
 visited array: true, true, false, true, true, false, false,
 setting start to : 2, Calling dfs for 2

 current visit: 2
 start: 2, edge list is : [0, 4]
 visited array: true, true, true, true, true, false, false,
 setting start to : 6, Calling dfs for 6

 current visit: 6
 start: 6, edge list is : [4]
 visited array: true, true, true, true, true, false, true,
 setting start to : 5, Calling dfs for 5

 current visit: 5
 start: 5, edge list is : [3]
 visited array: true, true, true, true, true, true, true,
 */