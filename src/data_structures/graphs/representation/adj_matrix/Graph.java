package data_structures.graphs.representation.adj_matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    ArrayList<Node> nodeList = new ArrayList<Node>();
    int [][] adjacencyMatrix;

    public Graph(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    @Override
    public String toString() {
       StringBuilder s = new StringBuilder();
       s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j: adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // utility to get neighbours
    public ArrayList<Node> getNeighbours(Node node) {
        ArrayList<Node> neighbours = new ArrayList<Node>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    // bfs internal
    void bfsVisit(Node node) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name+ " -> ");
            ArrayList<Node> neighbours = getNeighbours(currentNode);
            for (Node neighbour: neighbours) {
                if (!neighbour.isVisited) {
                    neighbour.isVisited = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public void bfs() {
        for (Node node: nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    // dfs internal
    void dfs(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " => ");

            for (Node neighbour: getNeighbours(currentNode)
                 ) {
                if (!neighbour.isVisited) {
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void dfs() {
        for (Node node: nodeList
             ) {
            if (!node.isVisited) {
                dfs(node);
            }
        }
    }

    // Topological sorting
    public void addDirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    void topologicalVisit(Node node, Stack<Node> stack) {
        ArrayList<Node> neigbours = getNeighbours(node);
        for (Node neighbour: neigbours
             ) {
            if(!neighbour.isVisited) {
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

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }

    // SSSP solution using BFS
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
            System.out.print("Printing path for node: "+ currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();

            ArrayList<Node> neighbours = getNeighbours(currentNode);
            for (Node neighbour: neighbours
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
