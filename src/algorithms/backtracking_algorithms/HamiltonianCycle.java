package algorithms.backtracking_algorithms;

public class HamiltonianCycle {
    private int vertices;
    private int[] hamiltonianPath;
    private int[][] adjMatrix;

    public HamiltonianCycle(int vertices, int adjMatrix[][]) {
        this.vertices = vertices;
        this.adjMatrix = adjMatrix;
        this.hamiltonianPath = new int[vertices];

        this.hamiltonianPath[0] = 0;

        if (!findFeasibleSolution(1)) {
            System.out.println("No feasible solution . . .");
        } else {
            showHamiltonianPath();
        }
    }

    private void showHamiltonianPath() {
        System.out.println("Hamiltonian cycle ===> ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(hamiltonianPath[i] + " ");
        }
        System.out.print(hamiltonianPath[0]);
    }

    private boolean findFeasibleSolution(int position) {
        if (position == vertices) {
            if (adjMatrix[hamiltonianPath[position-1]] [hamiltonianPath[0]] == 1) {
                return true;
            } else {
                return  false;
            }
        }
        for (int i = 0; i < vertices; ++i) {
            if (isFeasible(i, position)) {
                hamiltonianPath[position] = i;
                if (findFeasibleSolution(position + 1)) {
                    return true;
                }

                // backtrack

            }

        }
        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualPosition) {
        // first criterion: whether two nodes are connected
        if (adjMatrix[hamiltonianPath[actualPosition - 1]][vertexIndex] == 0) {
            return false;
        }
        // second criterion: whether we have visited it or not
        for (int i = 0; i <actualPosition ; i++) {
            if (hamiltonianPath[i] == vertexIndex) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int [][] matrix = {
                {0,1,1,1,0,0},
                {1,0,1,0,1,0},
                {1,1,1,1,0,1},
                {1,0,1,0,0,1},
                {0,1,0,0,0,1},
                {0,1,1,1,1,1}
        };

    HamiltonianCycle ob = new HamiltonianCycle(6, matrix);
    }
}
