import java.io.*;

public class HuffmanCode {

    public void run() throws IOException {
	int[] frequencies = getFrequencies("uglyduckling_andersen.txt");

	Node tree = makeTree(frequencies);
	String [] codes = new String[127];
	createCodes(codes, tree);

	String message = readMessage("codedmessage3.txt");
	String result = decode(message, tree);
	System.out.println(result);

	/* 
	   Testing code to print out the Huffman tree:
	for(int i = 0; i < codes.length; i++) {
	    System.out.println(codes[i]);
	    }
	*/

	/* 
	   Testing code to find the length of the files:
	File f = new File("amodestproposal_swift.txt");
	System.out.println("The input file's length in bits is: " + 8*f.length());
	String message = readMessage("amodestproposal_swift.txt");
	String result = encode(message, codes);
	System.out.println("The encoded file's length in bits is: " + result.length());
	*/
       
    }

    // input: the name of a text file
    // output: a length-127 array containing the number of times each 
    // character appears in the input file
    public int[] getFrequencies(String fileName) throws IOException {
	int[] frequencies = new int[127];
	FileReader fr = new FileReader(fileName);

	int nextChar = fr.read();
	while(nextChar != -1) {
	    frequencies[(int)nextChar]++;
	    nextChar = fr.read();
	}

	return frequencies;
    }


    // input: an array of character frequencies
    // output: a pointer to the root of a Huffman tree built using the 
    // specified frequencies
    public Node makeTree(int[] frequencies) {
	PQHeap temp = new PQHeap();

	for(int i = 0; i < frequencies.length; i++) {
	    Node toAdd = new Node((char)i, frequencies[i]);
	    temp.add(toAdd);
	}

	while(temp.size() > 1) {
	    Node a = temp.remove();
	    Node b = temp.remove();
	    Node parent = new Node((char)-1, a.count + b.count);
	    parent.left = a;
	    parent.right = b;
	    temp.add(parent);
	}

	Node root = temp.remove();
	root.code = "";

	return root;

    }


    // input: codes: an empty array to be filled in with the binary encodings
    //               for each character
    //        tree: the Huffman tree from which to read the encodings
    // at the end of the method, codes should contain the binary encoding of
    // each character
    public void createCodes(String[] codes, Node tree) {
	if(tree.left != null) {
	    tree.left.code = tree.code + "0";
	    createCodes(codes, tree.left);
	}

	if(tree.right != null) {
	    tree.right.code = tree.code + "1";
	    createCodes(codes, tree.right);
	}	

	if(tree.symbol != (char)-1) {
	    codes[(int)tree.symbol] = tree.code;
	}
    }

 
    // input: message: a text string that is to be encoded
    //        code: an array of the binary encoding to use for each character
    // output: a binary string containing the encoded version of the message
    public String encode(String message, String[] code) {
	String encodedMessage = "";

	for(int i = 0; i < message.length(); i++) {
	    encodedMessage = encodedMessage + code[(int)message.charAt(i)];
	}

	return encodedMessage;
    }


    // input: message: a binary string that is to be decoded
    //        tree: the Huffman tree to use to decode the message
    // output: a String containing the text decoding of the message
    public String decode(String message, Node tree) {
	String decodedMessage = "";
	Node current = tree;

	for (int i = 0; i < message.length(); i++) {
	    if (message.charAt(i) == '0') {
		current = current.left;
	    }
	    if (message.charAt(i) == '1') {
		current = current.right;
	    }

	    if (current.symbol != (char)-1) {
		decodedMessage = decodedMessage + current.symbol;
		current = tree;
	    }
	}

	return decodedMessage;
    }


    // input: the name of the file to be read
    // output: a String containing the contents of the file
    public String readMessage(String fileName) throws IOException {
	FileReader fr = new FileReader(fileName);
	String message = "";
	int nextChar = fr.read();
	while(nextChar != -1) {
	    message = message + (char)nextChar;
	    nextChar = fr.read();
	}
	return message;
    }


    public static void main(String [] args) {
	try {
	    new HuffmanCode().run();
	}
	catch(IOException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
    }

}