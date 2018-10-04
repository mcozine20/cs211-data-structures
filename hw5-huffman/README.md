# HW5 Huffman Coding
Compresses and decompresses text files using the Huffman coding algorithm. It does this by counting how many times each character appears in the given text file, making a Huffman binary tree to store these frequencies, and using this tree to encode and/or decode the text file

## What I was given by Professor Gardner
* Node.java: represents a node in a Huffman tree. Has fields for symbol, count, left and right children, and a constructor
* HuffmanCode.java: scaffolding code with methods I had to fill in. 

## What I had to do
* Fill in five methods in HuffmanCode.java: getFrequencies(), makeTree(), createCodes(), encode(), and decode()

## How I did it
* Wrote a PQHeap class based off of a heap we had already written for class (PQHeap.java lines 1-97)
* Filled in the methods I was asked to fill in (HuffmanCode.java lines 38-47, 55-74, 85-97, 105-111, 119-136)

## Built With
* Java

## Contributors
* Professor Kristy Gardner
* McLean Cozine
