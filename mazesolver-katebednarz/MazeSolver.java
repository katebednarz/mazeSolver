import java.util.*;

//=================================================
// Kate Bednarz
// Project 1: Recursive Maze Solver
// Due Date: September 13
//
// This file runs the MazeSolver program, running the point and maze classes and handing input.
//=================================================

class MazeSolver {
    
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int numberOfCases = in.nextInt();
        String blank = in.nextLine();
        for(int i = 0; i < numberOfCases; i++){
            Maze maze2 = Maze.read(in);
            Maze mazeWithWalls = new Maze(maze2.rows, maze2.columns, Maze.addWalls(maze2), maze2.start, maze2.finish);
            mazeWithWalls.findPath(maze2.start, 'z', false);
            if(mazeWithWalls.checkIfSolvable()){
                Maze.print(mazeWithWalls);
            } else {
                System.out.println();
                System.out.println("NO PATH EXISTS");
            }
            System.out.println();
        }
    }
}