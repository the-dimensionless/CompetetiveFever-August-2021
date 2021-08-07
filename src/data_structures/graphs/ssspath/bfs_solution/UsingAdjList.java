package data_structures.graphs.ssspath.bfs_solution;

import data_structures.graphs.representation.adj_list.Graph;
import data_structures.graphs.representation.adj_list.Node;

import java.util.ArrayList;

public class UsingAdjList {
    public static void main(String[] args) {
        ArrayList<Node> nodelist = new ArrayList<Node>();
        nodelist.add(new Node("A", 0));
        nodelist.add(new Node("B", 1));
        nodelist.add(new Node("C", 2));
        nodelist.add(new Node("D", 3));
        nodelist.add(new Node("E", 4));
        nodelist.add(new Node("F", 5));
        nodelist.add(new Node("G", 6));
        nodelist.add(new Node("H", 7));
        Graph g = new Graph(nodelist);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(1, 6);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(2, 4);
        g.addUndirectedEdge(3, 5);
        g.addUndirectedEdge(4, 5);
        g.addUndirectedEdge(5, 6);


        System.out.println("Single source shortest path using BFS for node A");
        g.ssspBFS(nodelist.get(0)); // Node A

    }
}
