import java.lang.Math;

public class Dijkstra {

    public void run(int n) {
	int[][] graph = new int[n][n];
	fillRandomGraph(graph);

	Node[] myNodes = new Node[graph.length];
	for(int i = 0; i < graph.length; i++) {
	    myNodes[i] = new Node(i);
	}

	print(graph);
	System.out.println();

	dijkstra(graph, myNodes);

	/*
	  Testing code
	for (int i = 0; i < myNodes.length; i++) {
	    if (myNodes[i].parent != null) {
		System.out.println("Node: " + myNodes[i].index + " Parent: " + myNodes[i].parent.index + " Distance from 0: " + myNodes[i].dist);
	    }
	    else {
		System.out.println("Node: " + myNodes[i].index + " Parent: null" + " Distance from 0: " + myNodes[i].dist);
	    }
	}
	*/

	for (int j = 0; j < n; j++) {
	    System.out.print("Path to " + j + ": ");
	    printPath(myNodes[j]);
	}

    }

    public void print(int[][] graph) {
	for(int i = 0; i < graph.length; i++) {
	    for(int j = 0; j < graph.length; j++) {
		System.out.print(graph[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public void fillRandomGraph(int[][] graph) {
	for(int i = 0; i < graph.length; i++) {
	    for(int j = i+1; j < graph.length; j++) {
		double rand = Math.random();
		if(rand < 0.8) {
		    graph[i][j] = (int)(Math.random() * 10);
		    graph[j][i] = graph[i][j];
		}
		else{
		    graph[i][j] = 0;
		    graph[j][i] = 0;
		}
	    }
	}

    }

    public void dijkstra(int[][] graph, Node[] nodes) {
	Heap myHeap = new Heap();

	// initialize each node's parent as well as its distance from node 0
	for (int i = 0; i < nodes.length; i++) {
	    nodes[i].dist = Integer.MAX_VALUE;
	    nodes[i].parent = null;
	}
	nodes[0].dist = 0;

	// Put all of the nodes in a heap-implemented priority queue with
	// priority given to nodes with the shortest distance
	for (int i = 0; i < nodes.length; i++) {
	    myHeap.add(nodes[i]);
	    nodes[i].inPQ = true;
	}
	
	// Here is where we implement Dijkstra's algorithm
	while (!myHeap.isEmpty()) {
	    // Remove the node with the shortest distance
	    Node current = myHeap.remove();
	    current.inPQ = false;
	    // If the node you removed has not been visited, skip it, since it
	    // cannot be on a path from 0
	    if (current.dist == Integer.MAX_VALUE) {
		continue;
	    }
	    // Run through the adjacency matrix, looking for current's neighbors
	    for (int i = 0; i < graph.length; i++) {
		if (graph[current.index][i] != 0) {
		    Node neighbor = nodes[i];
		    // Once you find a neighbor, check that it is still in the 
		    // priority queue
		    if (neighbor.inPQ = true) {
			// If the neighbor is in the priority queue, check 
			// to see if its  distance should be updated. If it
			// should be, do so
			int newDist = current.dist + graph[current.index][i];
			if (newDist < neighbor.dist) {
			    myHeap.decreaseKey(neighbor, newDist);
			    neighbor.parent = current;
			}
		    }
		}
	    }
	}
    }

    // I use a stack here to easily print the nodes in the order that they would
    // be traversed
    public void printPath(Node node) {
	if (node.index == 0) {
	    System.out.println("This is the first node");
	    return;
	}
	if (node.parent == null) {
	    System.out.println("There is no path to this node from 0");
	    return;
	}

	Node current = node;
	Stack<Node> myStack = new Stack<Node>();

	while (current.parent != null) {
	    myStack.push(current);
	    current = current.parent;
	}
	myStack.push(current);

	while (!myStack.isEmpty()) {
	    Node toPrint = myStack.pop();
	    System.out.print(toPrint.index + " ");
	}
	System.out.println();
    }

    public static void main(String [] args) {
	if(args.length > 0) new Dijkstra().run(Integer.parseInt(args[0]));
	else new Dijkstra().run(10);
    }

}