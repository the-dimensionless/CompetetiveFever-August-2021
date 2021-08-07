package data_structures.graphs.topological_sorting;

import data_structures.graphs.representation.adj_list.Graph;
import data_structures.graphs.representation.adj_list.Node;

import java.util.ArrayList;

public class UsingAdjList {
    public static void main(String[] args) {
        ArrayList<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new Node("A", 0));
        nodeList.add(new Node("B", 1));
        nodeList.add(new Node("C", 2));
        nodeList.add(new Node("D", 3));
        nodeList.add(new Node("E", 4));
        nodeList.add(new Node("F", 5));
        nodeList.add(new Node("G", 6));
        nodeList.add(new Node("H", 7));
        Graph g = new Graph(nodeList);
        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(2, 4);
        g.addDirectedEdge(4, 7);
        g.addDirectedEdge(4, 5);
        g.addDirectedEdge(5, 6);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(3, 5);

        System.out.println("Topological Sorting using Adj List : ");
        g.topologicalSort();

    }
}
