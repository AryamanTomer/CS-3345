// Graph Theory Tutorial

/* Graph Theory is a branch of math that concerns the
study of relationships between different objects.

A graph is a collection of various vertexes also known as nodes,
these nodes are connected with each other via the edges.

We will go over:

-Characteristics

-Eulerian Graphs

-Planar Graphs

-Special Graphs

-Trees

-Paths in graph theory

 */


 // What is a Graph Data Structure

/* A graph is a non-linear data structure consisting of vertices and edges.

 These vertices are sometimes referred to as nodes and the edges are lines or arcs that connect
 any two nodes in the graph.

More formally a Graph is composed of a set of vertices (V) and a set of edges (E).

This graph is denoted by G(V, E)


// Representations of Graph

2 most common ways to represent a graph:
    1. Adjacency Matrix
    2. Adjacency List


Adjacency Matrix

An adjacency matrix is a way of representing a graph as a 
matrix of boolean (0's and 1's)

Let's assume there are n vertices in the graph.

So we will create a 2D matrix adjMat[n][n] having the dimensions n x n.

If there is an edge from vertex i to j, mark adjMat[i][j] as 1.
If there is no edge from vertex i to j, mark adjMat[i][j] as 0.



Representation of Undirected Graph to Adjacency Matrix:

Initially the entire Matrix is initialized to 0.

If there is an edge from the source to the destination, we insert 1 to both cases
(adjMat[destination] and adjMat[destination]) because we can go either way.

Adjacency Matrix
    0    1    2
0        1    1
1   1         1
2   1    1

for the undirected graph 1 - 2
                         \   /
                           0

The Representation of Directed Graph to the Adjacency Matrix:

The below figure shows a directed graph.

Initially, the entire Matrix is initialized to 0.

If there is an edge from source to destination, we insert 1 for that particular adjMat[destination]

Adjacency Matrix
    0   1   2
0
1   1       1
2   1

for the directed graph 1 -> 2
                        \>0</

*/

// Adjacency List

/* An array of lists is used to store the edges between two vertices.

The size of array is equal to the number of vertices.

Each index in this array represents a specific vertex in the graph.

The entry at the index i of the array contains a linked list containing the vertices that are 
adjancent to vertex i.

We should create a array list of size n as adjList[n]

 */