import java.util.*;

// This is the graph to represent graph
class Graph {
    // # of vertices
    private int V; 
    // Adjacency List
    private List<List<Edge>> adj; 

    // Constructor
    Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }
    // This is an inner class to represent the edge
    class Edge {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // This is a function to add an edge to the graph
    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        adj.get(src).add(edge);
        // For undirected graph, add reverse edge as well
        edge = new Edge(src, weight);
        adj.get(dest).add(edge);
    }

    // Function to find minimum spanning tree using Prim's Algorithm
    void primMST() {
        // To keep track of vertices included in MST
        boolean[] inMST = new boolean[V];
        // To store the parent of each vertex in MST
        int[] parent = new int[V];
        // To store the key value of each vertex
        int[] key = new int[V];

        // Initialize key values to infinity and inMST values to false
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(inMST, false);

        // Start with vertex 0
        // Make the key 0 so that this vertex is picked first
        key[0] = 0;
        // Root of MST
        parent[0] = -1;
        
        // Loop through all vertices
        for(int count = 0; count < V - 1; count++) {
            // Find the vertex with minimum key value
            int u = minKey(key, inMST);

            // Add the picked vertex to MST
            inMST[u] = true;

            // Update key and parent values of adjacent vertices of the picked vertex
            for (Edge edge : adj.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;
                if (!inMST[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
            }
        }

        // Print the deges of MST
        System.out.println("Edges of Minimum Spanning Tree:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    // Function to find the vertex with the minimum key value which is not yet included in MST
    int minKey(int[] key, boolean[] inMST) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int v = 0; v < V; v++) {
            if(!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
// Main class
public class PrimsAlgorithm {
    public static void main(String[] args) {
        // Create a graph
        int V = 5;
        Graph g = new Graph(V);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        // Find the minimum spanning tree using Prim's algorithm
        g.primMST();
    }
}
