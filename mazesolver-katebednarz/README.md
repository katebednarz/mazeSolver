## Data Structures
# Project 1: Recursive Maze Solver
### Assigned: August 30
### Due: September 13 by 23:59:59
---


## Description
The purpose of this programming project is to explore recursion by writing an application that finds a path through a maze.  This programming project will also improve your software development skills, reinforce the concept of ADTs, improve your skills programming recursive functions, reading from standard input, and outputting your results to standard output.  There is no GUI associated with this program.  All input/output will be from the keyboard and terminal screen.

The maze can be represented as a 2D array of characters (array of strings).  Each point location in the maze is either empty/open to pass through (".") or filled/blocked with a barricade ("*") making it impassable.  Each location in the maze can be referenced by a point $(x,y)$.  The upper-left corner and has a location of $(1,1)$.  Your program needs to find just one path through the maze (there may be multiple valid paths).  A valid path can only pass through empty cells and may not pass through the same cell more than once.  Paths proceed from one empty cell to the next horizontally or vertically, but not diagonally.  If the program finds a path, it displays the path (and the maze) to standard output. Otherwise, it outputs a message stating that there is no valid path.


## Input
Your program will read maze data from standard input (keyboard).  You can directly enter the input from your keyboard.  However, you can make plain text files that contains separate test maze datasets.  Open a text editor and type in the test data (see example below).  You can then "redirect standard input" from a file into your program.  Here is an example of using input redirection:

```text
prompt$ java mazeapp < test1.txt
[LOTS OF OUTPUT GOES HERE]
prompt$
```

The following is the input format:
+ A integer $n$ indicating the number of maze test cases that follow.
+ A blank line.
+ Two integers $(r, c)$ representing the dimensions (rows and columns) of the maze.
+ Four integers $(s_x, s_y, f_x, f_y)$ representing the start position coordinates and finish position coordinates.
+ The maze characters consisting of $r$ rows of $c$ characters per row.
+ A blank line will separate each maze test case.

### Sample Input
```text
prompt$ cat test1.dat
3

3 3
1 1 3 3
...
...
...

9 9
1 1 9 9
..*......
*.*......
...***...
.*..**.**
..*....**
..**.*.**
...*.*.**
..****...
..******.

9 9
1 1 9 9
..*......
*.*......
...***...
.*..**.**
..*....**
..**.*.**
...*.****
..****...
..******.
prompt$
```

## Output
Output from your program will be to standard output (terminal screen).  Output from this program is plain, simple, and terse.  For each maze test case, output the solution maze if a path exists, otherwise output the message `NO PATH EXISTS`.  The output between each maze data set should be a blank line.

The path through the maze is represented by the lowercase letters `[a..z]`.  The path will start with letter `a` at position $(s_x, s_y)$.  The next position in the path will be `b`, ... and so on.  If the current location is letter `z` and the current path is not at the finish, then the next letter will begin again with letter `a`.


### Sample Output
```text
prompt$ java mazeapp < test1.dat
a..
b..
cde

ab*......
*c*......
.de***...
.*fg**.**
..*hijk**
..**.*l**
...*.*m**
..****nop
..******q

NO PATH EXISTS
prompt$
```

## Assessment, Submission, and Grading
+ This is an individual project.
+ Your program must be written in Java.
+ Your program will be tested using the terminal screen.
+ Do not assume that your program will only be tested with the example shown in this document.  Your program will be tested on other test data.  You are responsible for creating your own test data.
+ Your program must read from standard input (keyboard) and write to standard output (terminal screen).
+ The output must formatted exactly as as specified and shown in this document.
+ You must use good software design.  In this project, the design is fixed.
+ To receive full credit, you must implement a recursive solution to your `findpath()` method.  Solutions that do not implement a recursive solution for the `findpath()` method will receive a zero for the assignment.
+ Comment and document all code submitted and follow the documentation guidelines as specified by your instructor (course webpage).
+ Follow the submission guidelines and procedures.  
+ Submit your project via `git` to the GitHub Classroom by the assigned date.
+ This project is worth 100 points.


## Project Design and Programming Hints
Develop a Point class that will store a maze coordinate $(x,y)$.  The Point class should be in a separate (module) file.  It should contain at least the following methods:

+ A constructor that takes arguments $x$ and $y$.  This constructor will create a new point with the values passed to it.
+ A copy constructor that creates an object when passed another Point object.
+ A `getX()` method that returns the $x$-coordinate
+ A `getY()` method that returns the $y$-coordinate
+ A `setX()` method that sets the object with a new $x$-coordinate.
+ A `setY()` method that sets the object with a new $y$-coordinate.
+ An `isequal()` method that compares if two objects of type Point are equal.
+ A `read()` method that will read an $(x,y)$ coordinate from standard input and create a Point object.
+ A `print()` method that will write a Point object to standard output: `(x, y)`.

Develop a Maze class that will hold the data structure for a Maze.  Use a 2D array of characters or an array of strings.  The Maze class should contain at least the following methods:

+ A constructor creates a new maze initialized to rows and columns.
+ An `initialize()` method, that clears, empties, or resets your Maze data structure.
+ A `read()` method that will read the dimensions of the maze, starting point, ending point, and maze data.
+ A `print()` method that will print the actual maze to standard output.
+ A `printall()` method that will print the Maze object to standard output.  (All maze data ... used for debugging.)
+ A `findpath()` method that will attempt to find a path from the starting position to the finishing position using a recursive algorithm.

Develop a `MazeSolver` program class that will read from standard input the number of maze instances.  The main program will then read the size of the maze, starting location and finishing location.  The main program will have a maze object read the maze from standard input and then call the `findpath()` method.  The main program will either print the solution maze or print  `NO PATH EXISTS`.  
