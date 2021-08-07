package data_structures.graphs.representation.adj_matrix;

import data_structures.graphs.representation.adj_matrix.Graph;
import data_structures.graphs.representation.adj_matrix.Node;

import java.util.ArrayList;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(new Node("A", 0));
        list.add(new Node("B", 1));
        list.add(new Node("C", 2));
        list.add(new Node("D", 3));
        list.add(new Node("E", 4));

        Graph g = new Graph(list);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(2,3);
        g.addUndirectedEdge(3,4);
        System.out.println("<<<Graph>>>\n" + g.toString());
    }
}
