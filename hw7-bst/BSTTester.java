public class BSTTester {

    public static void main(String[] args) {
	BinarySearchTree toTest = new BinarySearchTree();

	toTest.remove("0");

	// ALL THE ADDS
	toTest.add("0");
       	toTest.add("4");
       	toTest.add("-1");
	toTest.add("9");
	toTest.add("2");
	toTest.add("0");
	toTest.add("-4");
	toTest.add("4");
	toTest.add("6");
	

	// ALL THE LOOKUPS
	toTest.lookup("1");
	toTest.lookup("0");




	// ALL THE REMOVES
		toTest.remove("0");
      	 	toTest.remove("4");
	      	toTest.remove("9");

	
		System.out.print("The root is: ");
		toTest.root.toPrint();

	toTest.lookup("0");


	// ALL THE PRINTS
	toTest.inOrderTraverse();
    }

}