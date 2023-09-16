import java.util.*;

//=================================================
// Kate Bednarz
// Project 1: Recursive Maze Solver
// Due Date: September 13
//
// This file defines a maze data type, and it can be used to read in input, solve the maze, and print out output.
//=================================================
class Maze {

    // data members
    char[][] maze;
    int rows;
    int columns;
    Point start;
    Point finish;

    // member functions

    // default constructor
    Maze() {
        maze = null;
        rows = 0;
        columns = 0;
    }


    // overloaded constructor
    Maze(int r, int c, char[][] maze, Point start, Point finish) {
        this.rows = r;
        this.columns = c;
        this.maze = maze;
        this.start = start;
        this.finish = finish;
    }

    // initialize method
    public void initialize(){
        maze = null;
        rows = 0;
        columns = 0;
    }

    // read method
    public static Maze read(Scanner input){
        int numberOfRows = input.nextInt();
        int numberOfColumns = input.nextInt();
        char[][] localMaze = new char[numberOfRows][numberOfColumns];
        Point start = Point.read(input);
        Point finish = Point.read(input);
        input.nextLine();
        for(int r = 0; r < numberOfRows; r++){
            String line = input.nextLine();
            for(int c = 0; c < numberOfColumns; c++){
                localMaze[r][c] = line.charAt(c);
            }
        }
        Maze maze1 = new Maze(numberOfRows, numberOfColumns, localMaze, start, finish);
        return maze1;
    }

    // adds a border of stars around the maze
    public static char[][] addWalls(Maze curMaze){
        char[][] mazeWithWalls = new char[curMaze.maze.length + 2][curMaze.maze[0].length + 2];
        int numberOfStars = curMaze.maze[0].length + 2;
        String tempString = "*".repeat(numberOfStars);
        mazeWithWalls[0] = tempString.toCharArray();
        mazeWithWalls[mazeWithWalls.length - 1] = tempString.toCharArray();
        for(int r = 0; r < curMaze.rows; r++){
            String printString = "";
            for(int c = 0; c < curMaze.columns; c++){
                printString = printString + curMaze.maze[r][c];
            }
            String tempString2 = "*" + printString + "*";
            mazeWithWalls[r + 1] = tempString2.toCharArray();
        }
        return mazeWithWalls;
    }

    // print method - prints the maze without the borders
    public static void print(Maze maze){
        for(int i = 1; i < maze.maze.length - 1; i++){
            System.out.println();
            for(int j = 0; j < maze.columns; j++){
                System.out.print(maze.maze[i][j + 1]);
            }
        }

    }

    // printall method - prints the maze with the bornders
    public static void printall(Maze maze){
        char[][] printArray = addWalls(maze);
        for(int i = 0; i < printArray.length; i++){
            System.out.println(printArray[i]);
        }
    }


    // findpath method
    public boolean findPath(Point currentLoc, char letter, boolean done){
        int curX = currentLoc.getX();
        int curY = currentLoc.getY();
        Point tempPoint = currentLoc;
        if(currentLoc.isEqual(finish)){
            this.maze[curX][curY] = getNextLetter(letter);
            return true;
        } else {
            done = false;
            this.maze[curX][curY] = letter;
            char nextLetter = getNextLetter(letter);

            // check south direction
            if(maze[curX + 1][curY] == '.' && !done){
                tempPoint = new Point(curX + 1, curY);
                maze[curX][curY] = nextLetter;                    
                done = findPath(tempPoint, nextLetter, done);
            }
            // check east direction
            if(maze[curX][curY + 1] == '.' && !done){
                tempPoint = new Point(curX, curY + 1);
                maze[curX][curY] = nextLetter;
                done = findPath(tempPoint, nextLetter, done);
            }
            // check north direction
            if(maze[curX - 1][curY] == '.' && !done){
                tempPoint = new Point(curX - 1, curY);                    
                maze[curX][curY] = nextLetter;
                done = findPath(tempPoint, nextLetter, done);
            }
            // check west direction
            if(maze[curX][curY - 1] == '.' && !done){
                tempPoint = new Point(curX, curY - 1);
                maze[curX][curY] = nextLetter;
                done = findPath(tempPoint, nextLetter, done);
            }
            // replaces the letters filled in with dot if the maze can't be solved
            if(!done){
                maze[curX][curY] = '.';
            }
        }
        return done;
    }

    // finds the next letter in the alphabet to show progress through the maze
    private char getNextLetter(char letter){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int curLetterIndex = alphabet.indexOf(letter);
        if(curLetterIndex == alphabet.length() - 1){
            curLetterIndex = -1;
        }
        char nextLetter = alphabet.charAt(curLetterIndex + 1);
        return nextLetter;
    }

    // returns true if the maze is solvable to show what output needs to be printed
    public boolean checkIfSolvable(){
        boolean isSolvable = false;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                if(this.maze[r][c] == 'a'){
                    isSolvable = true;
                }
            }
        }
        return isSolvable;
    }
}