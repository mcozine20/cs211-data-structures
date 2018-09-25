import java.util.Vector;

public class Stack<E> {

    private Vector<E> list;
    private int top;

    public int size() {
	return list.size();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

    public void push(E toAdd) {
	list.add(toAdd);
	top++;
    }

    public E pop() {
	top--;
	return list.remove(top);
    }

    public E peek() {
	return list.elementAt(top-1);
    }

     public void print() {
	System.out.print("[");
	for(int i = list.size() - 1; i >= 0; i--) {
	    System.out.print(list.elementAt(i) + " ");
	}
	System.out.println("]");
    }

    public Stack() {
	list = new Vector<E>();
    }

}