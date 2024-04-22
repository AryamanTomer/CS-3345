import java.util.*;

class Vertex {
    int id;

    public Vertex(int id) {
        this.id = id;
    }
}

// Class representing an Edge in a graph

class Edge {
    Vertex source;
    Vertex destination;

    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }
}

// Linked List Node
class Node {
    Vertex vertex;
    Node next;

    public Node(Vertex vertex) {
        this.vertex = vertex;
        this.next = null;
    }
}

// LinkedList for adjacency list
class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Insert a vertex at the end of the list
    public void insert(Vertex vertex) {
        Node newNode = new Node(vertex);
        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Display the list
    public void display() {
        Node current = head;
        while(current != null) {
            System.out.print(current.vertex.id + " ");
            current = current.next;
        }
    }
}

// Class representing a graph

class Graph {
    List<Vertex> vertices;
    List<Edge> edges;
    boolean isDirected;
    Map<Vertex, LinkedList> adjacencyList;

    public Graph(boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.isDirected = isDirected;
        this.adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(Vertex v) {
        vertices.add(v);
        adjacencyList.put(v, new LinkedList());
    }

    // Add an edge to graph
    public void addEdge(Vertex source, Vertex destination) {
        Edge edge = new Edge(source, destination);
        edges.add(edge);
        adjacencyList.get(source).insert(destination);
        if(!isDirected) {
            Edge reverseEdge = new Edge(destination, source);
            edges.add(reverseEdge);
            adjacencyList.get(destination).insert(source);
        }
    }

    // Breadth-First Search traversal
    public void BFS(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.id + " ");
            LinkedList adjacency = adjacencyList.get(current);
            Node currentAdj = adjacency.head;
            while(currentAdj != null) {
                Vertex neighbor = currentAdj.vertex;
                if(!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
                currentAdj = currentAdj.next;
            }
        }
    }

    // Depth-First Search traversal
    public void DFS(Vertex start) {
        Set<Vertex> visited = new HashSet<>();
        DFSUtil(start, visited);
    }

    private void DFSUtil(Vertex current, Set<Vertex> visited) {
        visited.add(current);
        System.out.print(current.id + " ");

        LinkedList adjacency = adjacencyList.get(current);
        Node currentAdj = adjacency.head;
        while (currentAdj != null) {
            Vertex neighbor = currentAdj.vertex;
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
            currentAdj = currentAdj.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a directed graph
        Graph directedGraph = new Graph(true);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        directedGraph.addVertex(v1);
        directedGraph.addVertex(v2);
        directedGraph.addVertex(v3);
        directedGraph.addVertex(v4);
        directedGraph.addEdge(v1, v2);
        directedGraph.addEdge(v2, v3);
        directedGraph.addEdge(v3, v4);
        System.out.println("Directed Graph BFS:");
        directedGraph.BFS(v1);
        System.out.println();
        System.out.println("Directed Graph DFS:");
        directedGraph.DFS(v1);
        
        // Create an undirected graph
        Graph undirectedGraph = new Graph(false);
        undirectedGraph.addVertex(v1);
        undirectedGraph.addVertex(v2);
        undirectedGraph.addVertex(v3);
        undirectedGraph.addVertex(v4);
        undirectedGraph.addEdge(v1, v2);
        undirectedGraph.addEdge(v2, v3);
        undirectedGraph.addEdge(v3, v4);
        System.out.println("\n\nUndirected Graph BFS:");
        undirectedGraph.BFS(v1);
        System.out.println();
        System.out.println("Undirected Graph DFS:");
        undirectedGraph.DFS(v1);
    }
}