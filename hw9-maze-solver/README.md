# HW9 Maze Solver
Given a maze in a specific format (specifically a .txt file like those provided here), solve the maze using recursive Depth-First Search. 

## What I was given by Professor Gardner
* Node.java: represents a square in the maze grid. Each contains an index, two booleans (visited and inSolution), a method called toString() that converts a Node to a String, and a constructor that sets the index of the node.
* Graph.java: some very basic starter code to implement a graph. At first all it contained was an array of Nodes and a constructor that initializes each Node. 
* MazeSolver.java: some starter code to help solve mazes. Specifically, the code does the following:
	1. Calls the parse() method to read the contents of a file and extract information about the size of the maze and the walls in the maze.
	2. Calls the buildGraph() method to generate a graph based on the maze information extracted by parse(). This method calls the addEdge() method in Graph.
	3. Calls the printMaze() method to print the maze.

## What I had to do
* Write the addEdge method in Graph.java, which I chose to do by creating an adjacency list.
* Update Graph.java and Node.java to complete the implementation of the changed addEdge method
* In MazeSolver.java write a method called solve() that takes a Graph as input and returns an ordered array of the Nodes included in the path from the maze entrance to the exit

## How I did it
* Created an Edge.java file to represent edges in the adjacency list (Edge.java lines 1-10)
* Filled in the addEdge method in Graph.java (Graph.java lines 7-25)
* Added a linked list in each Node to keep track of its edges (Node.java line 6)
* Added a edgeExists method to Node.java that takes a given index and checks if a node with that index exists in the linked list of edges of the given node (Node.java lines 24-41)
* Created a LLAddOnly.java file so each Node could keep track of its edges with an add-only linked list
* Filled in the solve method in MazeSolver.java (MazeSolver.java lines 163-179)
* Made a DFSPathFinder method in MazeSolver.java that implements recursive depth-first search to go through a maze and mark all of the nodes that are in that maze’s solution path (MazeSolver.java 186-229)

## Built With
* Java

## Contributors
* Professor Kristy Gardner
* McLean Cozine
