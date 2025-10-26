/******************************************************************************
 *  Simple Undirected Graph using symbol table
 *  ------------------------------------------
 *  Each vertex is a String key mapped to a set of its neighbors.
 *  - No parallel edges
 *  - Self-loops allowed
 *
 *  MacOS~> javac Graph.java 
 *	MacOS~> java Graph < tinyGraph.txt 
 * 	A: B C G H 
 *	B: A C H 
 *	C: A B G 
 *	G: A C 
 *	H: A B 
 ******************************************************************************/

import princetonLibs.*;

public class Graph {

    // Symbol table: vertex → neighbors
    private ST<String, SET<String>> st;
    private int E; // edge count

    // Create an empty graph
    public Graph() {
        st = new ST<String, SET<String>>();
    }

    // Build graph from file with given delimiter
    public Graph(String filename, String delimiter) {
        st = new ST<String, SET<String>>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String[] names = in.readLine().split(delimiter);
            for (int i = 1; i < names.length; i++) addEdge(names[0], names[i]);
        }
    }

    // Return number of vertices
    public int V() {
        return st.size();
    }

    // Return number of edges
    public int E() {
        return E;
    }

    // Check if vertex exists
    public boolean hasVertex(String v) {
        return st.contains(v);
    }

    // Add a vertex if not present
    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new SET<String>());
    }

    // Validate vertex existence
    private void validateVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " not found");
    }

    // Add an edge between v and w
    public void addEdge(String v, String w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        st.get(w).add(v);
    }

    // Check if edge v-w exists
    public boolean hasEdge(String v, String w) {
        validateVertex(v);
        validateVertex(w);
        return st.get(v).contains(w);
    }

    // Return all vertices
    public Iterable<String> vertices() {
        return st.keys();
    }

    // Return all neighbors of vertex v
    public Iterable<String> adjacentTo(String v) {
        validateVertex(v);
        return st.get(v);
    }

    // Return degree of vertex v
    public int degree(String v) {
        validateVertex(v);
        return st.get(v).size();
    }

    // String representation
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String v : st) {
            s.append(v + ": ");
            for (String w : st.get(v)) s.append(w + " ");
            s.append('\n');
        }
        return s.toString();
    }

    // Test client
    public static void main(String[] args) {
        Graph g = new Graph();
        while (!StdIn.isEmpty()) {
            String v = StdIn.readString();
            String w = StdIn.readString();
            g.addEdge(v, w);
        }
        StdOut.println(g);
    }
}
