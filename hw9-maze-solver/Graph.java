public class Graph {

    int numNodes;
    Node[] nodes;

    public void addEdge(int i, int j) {
	if (!nodes[i].edgeExists(j)) {

	    // Protect from ArrayIndexOutOfBounds
	    if (i >= numNodes || j >= numNodes) {
		return;
	    }

	    // Make a new linked list of edges if none exists yet
	    if (nodes[i].edges == null) {
		nodes[i].edges = new LLAddOnly();
	    }
	    if (nodes[j].edges == null) {
		nodes[j].edges = new LLAddOnly();
	    }

	    // Add an edge to each node's linked list of edges
	    nodes[i].edges.add(j);
	    nodes[j].edges.add(i);
	}
    }

    public Graph(int num) {
	numNodes = num;
	nodes = new Node[numNodes];
	for(int i = 0; i < numNodes; i++) {
	    nodes[i] = new Node(i);
	}
    }

}