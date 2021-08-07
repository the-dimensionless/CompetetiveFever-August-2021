package data_structures.graphs.representation.adj_matrix;

public class Node {
    public String name;
    public int index;
    public boolean isVisited = false;
    public Node parent;

    public Node(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", isVisited=" + isVisited +
                '}';
    }
}
