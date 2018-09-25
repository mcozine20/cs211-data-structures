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