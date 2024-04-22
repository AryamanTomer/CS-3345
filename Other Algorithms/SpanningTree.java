// Spanning Trees

/* A spanning tree of a connected, undirected graph is a subgraph that is a tree
and contains all the vertices of the original graph.
Spanning trees are useful in network design as it ensures connectivity while avoiding the redundant links.
*/


import java.util.*;


// Class to represent the graph
class Graph {
    // Number of Vertices
    private int V;
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // This is a function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // This is an undirected graph
    }

    // A recursive function to do DFS starting from vertex v
    void DFSUtil(int v, boolean visited[]){
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to the vertex
        for(Integer n: adj[v]) {
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // This is a function to do DFS traversal
    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    // This is a function to generate a spanning tree using DFS
    void generateSpanningTree(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
}

// Main Class
public class SpanningTree {
    public static void main(String[] args) {
        // Create a graph
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        System.out.println("Spanning tree using DFS:");
        g.generateSpanningTree(0);
    }
}

/*
    This graph class represents an undirected graph using an adjacency list
    The addEdge method adds an edge between 2 vertices
    The DFSUtil method performs a depth-first search traversal starting from a given vertex and marks visited vertices.
    The DFS method is a wrapper for DFSUtil to perform DFS traversal on the entire graph.
    The generateSpanningTree method is used to generate a spanning tree using a DFS traversal.
    In the main method, a sample graph is created, edges are added, and then a spanning tree is generated starting from vertex 0.

 */
