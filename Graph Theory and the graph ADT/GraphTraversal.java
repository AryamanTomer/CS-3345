import java.util.*;

class GraphTraversal {
    // # of vertices
    private int V; 
    // Adjacency List
    private LinkedList<Integer> adj[]; 

    // Constructor to initialize the graph with V vertices
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph between the vertices v and w
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Depth First Search Traversal
    void DFS(int v) {
         // Array to track visited vertices
        boolean visited[] = new boolean[V];
        // Calling the recursive DFS method
        DFSUtil(v, visited); 
    }

    // Recursive function for DFS traversal

    void DFSUtil(int v, boolean visited[]) {
        // Mark the current vertex as visited
        visited[v] = true; 
        // Print the current vertex
        System.out.print(v + " "); 

        // Recursion for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()) {
            int n = i.next();
            // If the adjacent vertex is not visited, recursively call DFSUtil
            if(!visited[n]) 
                DFSUtil(n, visited);
        }
    }

    // Breadth First Search traversal
    void BFS(int s) {
        // This is an array to track visited vertices
        boolean visited[] = new boolean[V]; 
        // Queue for BFS traversal
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the source vertex as visited
        visited[s] = true;
        // Enqueue the source vertex
        queue.add(s);

        // Loop until the queue is empty
        while(queue.size() != 0) {
             // Dequeue a vertex and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                // If adjacent vertex is not visited, mark it visited and enqueue it 
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        //Create a graph with 4 vertices
        Graph g = new Graph(4);

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal:");
        // Perform DFS traversal starting from vertex 2
        g.DFS(2);

        System.out.println("\nBreadth First Traversal:");
        // Perform BFS traversal starting from vertex 2
        g.BFS(2);
    }
}