package data_structures.graphs.representation.adj_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

    // BFS internal use
    void bfsVisit(Node node) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " => ");
            for (Node neighbour:
                 currentNode.neighbours) {
                if (!neighbour.isVisited) {
                    neighbour.isVisited = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    void bfs() {
        for (Node node:
             nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    // DFS internal

    void dfsVisit(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (Node neighbour: currentNode.neighbours
                 ) {
                if (!neighbour.isVisited) {
                    neighbour.isVisited = true;
                    stack.push(neighbour);
                }
            }
        }
    }

    void dfs() {
        for (Node node: nodeList
             ) {
            if (!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    // Topological Sort
    public void addDirectedEdge(int i, int j) {
        Node first = nodeList.get(i);
        Node second = nodeList.get(j);
        first.neighbours.add(second);
    }

    void topologicalVisit(Node node, Stack<Node> stack) {
        for (Node neighbour: node.neighbours
             ) {
            if (!neighbour.isVisited) {
                topologicalVisit(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort() {
        Stack<Node> stack = new Stack<Node>();
        for (Node node: nodeList
             ) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }

    /**
     * SSSP using BFS
     */
    public static void pathPrint(Node node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void ssspBFS(Node node) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print("Printing path for node " + currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();
            for (Node neighbour: currentNode.neighbours
                 ) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
            }
        }
    }
}
