package data_structures.graphs.representation.adj_list;

import java.util.ArrayList;

public class AdjacencyList {
    public static void main(String[] args) {
        ArrayList<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new Node("A", 0));
        nodeList.add(new Node("B", 1));
        nodeList.add(new Node("C", 2));
        nodeList.add(new Node("D", 3));
        nodeList.add(new Node("E", 4));

        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
        System.out.println("<<<<Graph>>>>\n" + g.toString());
    }
}
