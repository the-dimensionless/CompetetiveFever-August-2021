package data_structures.graphs.representation.adj_list;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> nodeList = new ArrayList<Node>();

    public Graph(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        Node first = nodeList.get(i);
        Node second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            Node currentNode = nodeList.get(i);
            s.append(currentNode.name + ": ");
            int lengthOfNeighbours = currentNode.neighbours.size();
            for (int j = 0; j < lengthOfNeighbours; j++) {
                Node currentNeighbour = currentNode.neighbours.get(j);
                if (j == lengthOfNeighbours - 1) {
                    s.append(currentNeighbour.name);
                } else {
                    s.append(currentNeighbour.name + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
