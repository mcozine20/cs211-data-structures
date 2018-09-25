public class LLAddOnly {

    int size;
    Edge first;
    Edge last;

    public void add(int x) {
	Edge toAdd = new Edge(x);
	if(first == null) {
	    first = toAdd;
	    last = toAdd;
	}
	else {
	    toAdd.next = first;
	    first = toAdd;
	}
	size++;
    }

    public LLAddOnly() {
	size = 0;
    }

}