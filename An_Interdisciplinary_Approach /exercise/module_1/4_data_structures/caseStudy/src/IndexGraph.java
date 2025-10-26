/******************************************************************************
 *  Simple program to build and query a graph
 *  -----------------------------------------
 *  Reads a file, builds an undirected graph,
 *  then prints all neighbors of a given vertex from user input.
 *
 *  Usage:
 *      java IndexGraph <filename> <delimiter>
 *
 *  Example:
 *      java IndexGraph tinyGraph.txt " "
 *
 *  MacOS Example:
 *      MacOS~> javac IndexGraph.java
 *      MacOS~> java IndexGraph tinyGraph.txt " "
 *
 *  Output:
 *      B
 *        A
 *        C
 *        H
 *      C
 *        A
 *        B
 *        G
 *      A
 *        B
 *        C
 *        G
 *        H
 ******************************************************************************/

import princetonLibs.StdIn;
import princetonLibs.StdOut;

public class IndexGraph {

    public static void main(String[] args) {

        // Load graph from file
        String filename = args[0];
        String delimiter = args[1];
        Graph G = new Graph(filename, delimiter);

        // Read a vertex name and show its neighbors
        while (!StdIn.isEmpty()) {
            String v = StdIn.readLine();
            if (G.hasVertex(v)) {
                for (String w : G.adjacentTo(v)) {
                    StdOut.println("  " + w);
                }
            } else {
                StdOut.println(v + " not found in graph.");
            }
        }
    }
}
