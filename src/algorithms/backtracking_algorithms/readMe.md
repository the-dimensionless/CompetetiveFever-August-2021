* A form of recursion
* general algorithm for finding all solutions to some 
    computational problems
* these are called constraint satisfaction problems
* Used in solving combinatorial optimization problems (like TSP)
* faster than brute force enumeration of all complete candidates
* N queens or Sudoku
* Also called depth first search for trees
* Skips multiple bad states in a single step

### Search Tree / Game Tree


1. N Queens
2. Hamiltonian Cycle Problem: A hamiltonian path that is a cycle.
A HPath in a directed/undirected graph is a path that visits each vertex
   exactly once.There may be several HPaths in a given graph.
   It is an NP-complete problem.
   Dirac Principle: A simple graph G(V,E) i hamiltonian if every vertex
   has degree (no of edges) >= V/2
   Finding HPath is NP-complete but we can decide whether such path exists in linear time 
   complexity with topological ordering
