## Graphs

Finite set of Vertices (nodes) and a set of Edges that
connect a pair of nodes.
G = (V, E)

In memory of,
1. Vertices
2. Edge
3. Unweighted Graph
4. Weighted Graph
5. Undirected Graph
6. Directed Graph
7. Cyclic graph (at least one loop)
8. Acyclic graph (no loop)
9. Positive weighted graph (directed/undirected)
10. Negative weighted graphs (directed/undirected)

### Tree: A special case of directed acyclic graphs


## Representation

1. Adjacency Matrix: 2D Array / Tabular form
2. Adjacency List: LinkedList with each node

* If graph is complete or almost complete -> use Adj Matrix 
* If number of edges are few then -> use Adj List
  
## Traversal
Note: Preventive Checks needed to prevent infinite looping.

1. BFS (Breadth First Search)
   Start at any node and explore all the neighbours at CURRENT LEVEL
   before moving to the next level neighbours.
   * Use Queue DS
   * Enqueue any starting vertex
   * while queue is not empty:
      * p = dequeue()
      * if p is unvisited:
         * mark it visited
         * enqueue all adjacent unvisited vertices of p
    
    * Time Complexity: O(V) + O(E) = O(V+E)
    * Space Complexity: O(V+E)
    
2. DFS (Depth First Search)
   Start at any node and explore as far as possible
   along each edge before backtracking.
   * Push any starting vertex on a Stack
   * while stack is not empty:
    * p = pop()
    * if p is not visited:
        * mark as visited
        * push all adjacent Vertices of p
   * Time Complexity: O(V+E)
   * Space Complexity: O(V + E)
   
------
### Topological Sorting
Sort given actions in such a way that if there is a
dependency of one action on another, then the dependent
action always comes later than its parent action.
