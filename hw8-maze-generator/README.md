# HW8 Maze Generator
This program uses Union-Find to generate a maze that prints to the console. 

## What I was given by Professor Gardner
* Cell.java: represents a square in the maze grid. Contains pointers to its four adjacent Walls, the head of a linked list, and the next Cell in the maze grid
* Wall.java: represents a wall in the maze. Contains pointers to two adjacent Cells, and a boolean visible that is true if the wall is still part of the maze and false if it isn’t.
* LLAddOnly.java: an abbreviated version of a linked list of Cell objects that only allows for adding to the list 
* MazeGenerator.java: some starter code to help generate mazes. Specifically, the code does the following:
	1. Sets up a new nxn 2-dimensional array of Cells and initializes them.
	2. Calls the getWalls() method to create an array of Walls and link adjacent Cells and Walls.
	3. Calls the printMaze() method to print out the maze.

## What I had to do
* Write a class called UnionFind to store Cell objects. It had to contain the methods makeset(), find(), and union()
* In MazeGenerator.java, write a method called createMaze to take an array of Walls and a 2-dimensional array of Cells and produce a maze from them

## How I did it
* Made the UnionFind class with the three methods she asked for (UnionFind.java lines 1-35)
* Wrote the createMaze class in MazeGenerator.java (MazeGenerator.java lines 21-62)

## Built With
* Java

## Contributors
* Professor Kristy Gardner
* McLean Cozine
