public class UnionFind {

    public void makeset(Cell a) {

	if (a.head == null) {
	    LLAddOnly set = new LLAddOnly();
	    set.add(a);
	}

    }

    public LLAddOnly find(Cell a) {

	return a.head;

    }

    public void union(Cell a, Cell b) {

	LLAddOnly setA = find(a);
	LLAddOnly setB = find(b);

	setB.last.head = setA;
	Cell current = setB.first;
	while(current.next != null) {
	    current.head = setA;
	    current = current.next;
	}

	setA.last.next = setB.first;
	setA.last = setB.last;

    }

}