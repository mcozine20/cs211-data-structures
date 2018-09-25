import java.io.*;
import java.lang.Math;

public class MazeSolver {

    public void run(String filename) throws IOException {

	// read the input file to extract relevant information about the maze
	String[] readFile = parse(filename);
	int mazeSize = Integer.parseInt(readFile[0]);
	int numNodes = mazeSize*mazeSize;
	String mazeData = readFile[1];

	// construct a maze based on the information read from the file
	Graph mazeGraph = buildGraph(mazeData, numNodes);

	// solve the maze
	Node[] solution = solve(mazeGraph);

	// print out the final maze with the solution path
	printMaze(mazeGraph.nodes, mazeData, mazeSize);

    }

    // prints out the maze in the format used for HW8
    // includes the final path from entrance to exit, if one has been recorded,
    // and which cells have been visited, if this has been recorded
    public void printMaze(Node[] mazeCells, String mazeData, int mazeSize) {
	
	int ind = 0;
	int inputCtr = 0;

	System.out.print("+");
	for(int i = 0; i < mazeSize; i++) {
	    System.out.print("--+");
	}
	System.out.println();

	for(int i = 0; i < mazeSize; i++) {
	    if(i == 0) System.out.print(" ");
	    else System.out.print("|");

	    for(int j = 0; j < mazeSize; j++) {
		System.out.print(mazeCells[ind] + "" + mazeCells[ind] +  mazeData.charAt(inputCtr));
		inputCtr++;
		ind++;
	    }
	    System.out.println();

	    System.out.print("+");
	    for(int j = 0; j < mazeSize; j++) {
		System.out.print(mazeData.charAt(inputCtr) + "" +  mazeData.charAt(inputCtr) + "+");
		inputCtr++;
	    }
	    System.out.println();
	}
	
    }

    // reads in a maze from an appropriately formatted file (this matches the
    // format of the mazes you generated in HW8)
    // returns an array of Strings, where position 0 stores the size of the maze
    // grid (i.e., the length/width of the grid) and position 1 stores minimal 
    // information about which walls exist
    public String[] parse(String filename) throws IOException {
	FileReader fr = new FileReader(filename);

	// determine size of maze
	int size = 0;
	int nextChar = fr.read();
	while(nextChar >= 48 && nextChar <= 57) {
	    size = 10*size + nextChar - 48;
	    nextChar = fr.read();
	}

	String[] result = new String[2];
	result[0] = size + "";
	result[1] = "";


	// skip over up walls on first row
	for(int j = 0; j < size; j++) {
	    fr.read();
	    fr.read();
	    fr.read();
	}
	fr.read();
	fr.read();

	for(int i = 0; i < size; i++) {
	    // skip over left wall on each row
	    fr.read();
	    
	    for(int j = 0; j < size; j++) {
		// skip over two spaces for the cell
		fr.read();
		fr.read();

		// read wall character
		nextChar = fr.read();
		result[1] = result[1] + (char)nextChar;

	    }
	    // clear newline character at the end of the row
	    fr.read();
	    
	    // read down walls on next row of input file
	    for(int j = 0; j < size; j++)  {
		// skip over corner
		fr.read();
		
		//skip over next space, then handle wall
		fr.read();
		nextChar = fr.read();
		result[1] = result[1] + (char)nextChar;
	    }

	    // clear last wall and newline character at the end of the row
	    fr.read();
	    fr.read();
	    
	}

	return result;
    }
    
    public Graph buildGraph(String maze, int numNodes) {

	Graph mazeGraph = new Graph(numNodes);
	int size = (int)Math.sqrt(numNodes);

	int mazeInd = 0;
	for(int i = 0; i < size; i++) {
	    // create edges for right walls in row i
	    for(int j = 0; j < size; j++) {
		char nextChar = maze.charAt(mazeInd);
		mazeInd++;
		if(nextChar == ' ') {
		    // add an edge corresponding to a right wall, using the 
		    // indexing convention for nodes
		    mazeGraph.addEdge(size*i + j, size*i + j + 1);
		}
	    }

	    // create edges for down walls below row i
	    for(int j = 0; j < size; j++)  {
		char nextChar = maze.charAt(mazeInd);
		mazeInd++;
		if(nextChar == ' ') {
		    // add an edge corresponding to a down wall, using the 
		    // indexing convention for nodes
		    mazeGraph.addEdge(size*i + j, size*(i+1) + j);
		}
	    }    
	}

	return mazeGraph;
    }

    // Takes a maze and solves it, returning an array of all the nodes in the
    // solution path
    public Node[] solve(Graph toSolve) {

	toSolve.nodes[0].inSolution = true;

	int pathSize =  DFSPathFinder(toSolve.nodes[0], toSolve);

	Node[] toReturn = new Node[pathSize];
	
	int ind = 0;
	for(int i =0; i<toSolve.nodes.length; i++) {
	    if (toSolve.nodes[i].inSolution == true) {
		toReturn[ind] = toSolve.nodes[i];
		ind++;
	    }
	}

	return toReturn;

    }

    // This recursive depth-first search goes through a maze and marks all nodes
    // that are in the maze's solution path. It returns the size of the solution
    // path. This is helpful in both the recursion and in creating the array 
    // of nodes in the solution path
    private int DFSPathFinder (Node root, Graph toSolve) {

	// Mark the current node as visited
	root.visited = true;

	// The base case: we have reached the end of the maze
	if (root.index == toSolve.nodes.length - 1) {
	    root.inSolution = true;
	    return 1;
	}

	// Recursively search the maze to find the solution, incrementing the
	// length of the solution path accordingly
	Edge toAdd = root.edges.first;
	int childPath = 0;
	for(int i = 0; i < root.edges.size; i++) {
	    if (!toSolve.nodes[toAdd.index].visited) {
		childPath = DFSPathFinder(toSolve.nodes[toAdd.index], toSolve);
		if (childPath > 0) {
		    toSolve.nodes[toAdd.index].inSolution = true;
		    return childPath + 1;
		}

	    }
	    toAdd = toAdd.next;
	}
	return childPath;	
    }
       
    public static void main(String [] args) {
	if(args.length < 1) {
	    System.out.println("USAGE: java MazeSolver <filename>");
	}
	else{
	    try{
		new MazeSolver().run(args[0]);
	    }
	    catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }

}