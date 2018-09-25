public class Node implements Comparable<Node>{

    int index;
    int dist;
    Node parent;
    boolean inPQ = false;

    public int compareTo(Node other) {
	if (other.dist < this.dist) {
	    return 1;
	}
	else if (other.dist > this.dist) {
	    return -1;
	}
	else {
	    return 0;
	}
    }

    public Node(int i) {
	index = i;
    }

}