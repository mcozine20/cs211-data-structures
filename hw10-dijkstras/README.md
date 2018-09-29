# HW10 Dijkstra’s Algorithm
Given a graph represented as an adjacency matrix, implements Dijkstra’s Algorithm to find the shortest path from one vertex to all other vertices. 

## What I was given
* Node.java: represents a vertex in the graph. Right now all Node contains is an index, a compareTo method that doesn’t do anything interesting, and a constructor that sets the index. You likely will find that you want to add more to Node.
* Heap.java: some code that you’ll recognize from earlier assignments as a heap implementation of a priority queue… The heap relies on the compareTo method in Node to give a priority ordering of Node objects, so it won’t do anything interesting until you rewrite compareTo to make it do something meaningful
* Dijkstra.java: some starter code for your Dijkstra’s algorithm implementation. Specifically right now the code does the following:
	1. Creates a new n x n array of ints, which will be an adjacency matrix representing the graph.
	2. Calls the fillRandomGraph() method to put some edges in the graph, with weights in the range 0-9. Right now each edge is created with probability 0.8 and the edge weights are selected uniformly at random.
	3. Creates an array of Node objects, one for each vertex in the graph.  
  
  <em\> Professor Kirsty Gardner
## What I had to do
* “Your job in this assignment is to implement Dijkstra’s algorithm to find the shortest path from vertex 0 (i.e., the node with index 0, which is in position 0 of the array created in the starter code) to every other vertex in the graph.” - Professor Kristy Gardner
* fill out Node.java to keep track of information I needed
* make the compareTo method in Node.java return meaningful information
* write a method called decreaseKey() in Heap.java
* write a dijkstra method and a printPath method in Dijkstra.java

## How I did it
* Added fields to Node.java and filled out the compareTo method (Node.java lines 4-6 and 9-17)
* wrote decreaseKey in Heap.java (Heap.java lines 73-87)
* Wrote a Stack.java file to make printing easy
* wrote the dijkstra and printPath methods (Dijkstra.java lines 64-138)

## Built With
Java

## Contributors
* Professor Kristy Gardner
* McLean Cozine
