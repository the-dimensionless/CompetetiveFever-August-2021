package data_structures.graphs.representation.adj_list;

import java.util.ArrayList;

public class Node {
    String name;
    int index;

    ArrayList<Node> neighbours = new ArrayList<Node>();

    public Node(String name, int index) {
        this.name  = name;
        this.index = index;
    }


}
