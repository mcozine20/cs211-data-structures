public class PQHeap {

    Node[] data;
    int numElts;

    public void add(Node toAdd){
	if (numElts == data.length - 1){
	    resize();
	}

	numElts++;
	data[numElts] = toAdd;

	siftUp(numElts);
    }

    public Node remove(){
	Node toReturn = data[1];

	data[1] = data[numElts];
	data[numElts] = null;
	numElts--;

	siftDown(1);

	return toReturn;
    }

    public int size(){
	return numElts;
    }
    
    public boolean isEmpty(){
	return numElts == 0;
    }

    //sifts the value at a given starting position up the heap until it is 
    //correctly placed
    private void siftUp(int pos){
	while(pos > 1 && data[pos].count < data[pos/2].count) {
	    swap(pos, pos/2);
	    pos = pos/2;
	}
    }

    //sifts the value at a given starting position down the heap until it is 
    //correctly placed
    private void siftDown(int pos){
	if(numElts > 1) {
	    while(pos <= numElts/2 && data[pos].count > data[findSmallest((2 * pos), (2 * pos + 1))].count){
		int toSwap = findSmallest((2 * pos), (2 * pos + 1));
		swap(pos, toSwap);
		pos = toSwap;
	    }
	}
    }

    //swaps the values held in data[a] and data[b]
    private void swap(int a, int b){
	Node temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }

    //finds and returns the position that holds the larger value between a and b
    private int findSmallest(int a, int b){
	if(data[b] == null || b > numElts || data[a].count <= data[b].count){
	    return a;
	}
	else{
	    return b;
	}
    }

    //prints the PQHeap, prints a blank line if the PQHeap is empty
    public void print(){
	for(int i = 1; i <= numElts; i++) {
	    System.out.print(data[i] + " ");
	}
	System.out.println();
    }

    private void resize() {
	Node[] temp = new Node[numElts * 2 + 1];

	for(int i = 1; i <= numElts; i++) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    public PQHeap() {
	data = new Node[2];
	numElts = 0;
    }

} 
