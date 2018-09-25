public class BinarySearchTree {


    public Node root;


    public void add(String key) {

	Node toAdd = new Node(key);

	if (this.root == null) {
	    this.root = toAdd;
	    return;
	}

	Node current = root;
	boolean loop = true;

	while (loop) {
	    if (current.key.compareTo(key) == 0) {
		return;
	    } 
	    else if (current.key.compareTo(key) < 0) {
		if (current.right == null) {
		    current.right = toAdd;
		    toAdd.parent = current;
		    return;
		}
		else {
		    current = current.right;
		}
	    }
	    else if (current.key.compareTo(key) > 0) {
		if (current.left == null) {
		    current.left = toAdd;
		    toAdd.parent = current;
		    return;
		}
		else {
		    current = current.left;
		}
	    }
	}

    }

    public String remove(String key) {

	if (this.root == null) {
	    return null;
	}

	Node current = root;
	boolean loop = true;

	while (loop) {
	    if (current.key.compareTo(key) == 0) {
		repairTree(current);
		return key;
	    }
	    else if (current.key.compareTo(key) < 0) {
		if (current.right == null) {
		    return null;
		}
		else {
		    current = current.right;
		}
	    }
	    else if (current.key.compareTo(key) > 0) {
		if (current.left == null) {
		    return null;
		}
		else {
		    current = current.right;
		}
	    }
	}

	return null;

    }

    public boolean lookup(String key) {

	Node current = root;
	boolean loop = true;

	while (loop) {
	    if (current.key.compareTo(key) == 0) {
		return true;
	    } 
	    else if (current.key.compareTo(key) < 0) {
		if (current.right == null) {
		    return false;
		}
		else {
		    current = current.right;
		}
	    }
	    else if (current.key.compareTo(key) > 0) {
		if (current.left == null) {
		    return false;
		}
		else {
		    current = current.left;
		}
	    }
	}

	return false; 
	
    }

    public void inOrderTraverse() {

	if (this.root.left != null) {
	    BinarySearchTree left1 = new BinarySearchTree(this.root.left);
	    left1.inOrderTraverse();
	}
	this.root.toPrint();
	if (this.root.right != null) {
	    BinarySearchTree right1 = new BinarySearchTree(this.root.right);
	    right1.inOrderTraverse();
	}

    }

    private void repairTree(Node current) {

	Node inUse = current.right;

	if (current != root) {
	    if (current == current.parent.right) {
		current.parent.right = inUse;
	    }
	    else if (current == current.parent.left) {
		current.parent.left = inUse;
	    }

	    if (inUse == null) {
		current.parent.right = current.left;
		current.left.parent = current.parent;
		return;
	    }
	}

	else {
	    if (inUse == null) {
		root = current.left;
		current.left.parent = null;
		return;
	    }
	    else {
		root = inUse;
	    }
	}

	inUse.parent = current.parent;

	Node temp = inUse;

	while (temp.left != null) {
	    temp = temp.left;
	}

	temp.left = current.left;
	current.left.parent = temp;

    }

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node root) {

	this.root = root;

    }

}