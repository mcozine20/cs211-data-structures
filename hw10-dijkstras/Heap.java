public class Heap {

    Node[] my_heap;
    int count = 0;

    public boolean isEmpty() {
	return (count == 0);
    }

    public void add(Node value) {
	if(count == my_heap.length - 1) resize();

	count++;
	my_heap[count] = value;
	siftUp(count);
    }

    public int size() {
	return count;
    }

    private void resize() {
	Node[] temp = new Node[count * 2 + 1];

	for(int i = 1; i <= count; i++) {
	    temp[i] = my_heap[i];
	}
	my_heap = temp;
    }

    public void siftUp(int pos) {
	if(pos != 1 && my_heap[pos].compareTo(my_heap[pos/2]) < 0) {
	    swap(pos, pos/2);
	    siftUp(pos/2);
	}
    }

    public Node remove() {
	if(count == 0) return null;

	Node temp = my_heap[1];
	my_heap[1] = my_heap[count];
	count--;
	siftDown(1);
	return temp;
    }

    public void siftDown(int pos) {
	if(2 * pos > count) return;

	if(2 * pos == count) {
	    if(my_heap[2 * pos].compareTo(my_heap[pos]) < 0) {
		swap(pos, 2 * pos);
	    }
	}
	else {
	    int smaller;
	    if(my_heap[2 * pos].compareTo(my_heap[2 * pos + 1]) <= 0) smaller = 2 * pos;
	    else smaller = 2 * pos + 1;
	    
	    if(my_heap[pos].compareTo(my_heap[smaller]) > 0) {
		swap(pos, smaller);
		siftDown(smaller);
	    }
	}
    }

    public void swap(int i, int j) {
	Node temp = my_heap[i];
	my_heap[i] = my_heap[j];
	my_heap[j] = temp;
    }

    public void print() {
	for(int i = 1; i <= count; i++) {
	    System.out.println(my_heap[i]);
	}
    }

    public void decreaseKey(Node value, int newKey) {
	if (newKey < value.dist) {
	    value.dist = newKey;
	    int pos = 0;

	    for (int i = 1; i <= my_heap.length; i++) {
		if (my_heap[i] == value) {
		    pos = i;
		    break;
		}
	    }

	    siftUp(pos);
	}
    }

    public Heap() {
	my_heap = new Node[2];
    }

} 
