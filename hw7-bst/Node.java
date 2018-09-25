public class Node {

    public String key;
    public Node parent;
    public Node right;
    public Node left;

    public Node(String key) {
	this.key = key;
    }

    public void toPrint() {
	System.out.println(this.key);
    }

}