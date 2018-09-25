import java.util.LinkedList;

public class Node {

    int index;
    LLAddOnly edges;

    // to help you keep track of things as you're solving the maze
    boolean visited = false;
    boolean inSolution = false;

    static final String PATH = "X";
    static final String VISIT = ".";
    static final String NOT_VISIT = " ";

    public String toString() {
	if(visited) {
	    if(inSolution) return PATH;
	    else return VISIT;
	}
	else return NOT_VISIT;
    }

    public boolean edgeExists(int ind) {
	if (edges == null) {
	    return false;
	}
	else {
	    Edge current = edges.first;
	    if (current.index == ind) {
		return true;
	    }
	    while (current.next != null) {
		if (current.next.index == ind) {
		    return true;
		}
		current = current.next;
	    }
	    return false;
	}
    }

    public Node(int i) {
	index = i;
    }

}