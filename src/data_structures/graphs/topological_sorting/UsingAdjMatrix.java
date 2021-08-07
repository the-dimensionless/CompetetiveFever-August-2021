package data_structures.graphs.topological_sorting;

import data_structures.graphs.representation.adj_matrix.Graph;
import data_structures.graphs.representation.adj_matrix.Node;

import java.util.ArrayList;

public class UsingAdjMatrix {
    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(new Node("A", 0));
        list.add(new Node("B", 1));
        list.add(new Node("C", 2));
        list.add(new Node("D", 3));
        list.add(new Node("E", 4));
        list.add(new Node("F", 5));
        list.add(new Node("G", 6));
        list.add(new Node("H", 7));

        Graph g = new Graph(list);

        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(2,4);
        g.addDirectedEdge(4, 7);
        g.addDirectedEdge(4, 5);
        g.addDirectedEdge(5, 6);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(3, 5);

        System.out.println("Topological Sorting using AdjMatrix: ");
        g.topologicalSort();
    }
}
