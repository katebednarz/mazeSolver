import java.util.*;

//=================================================
// Kate Bednarz
// Project 1: Recursive Maze Solver
// Due Date: September 13
//
// This file defines a point, and it can be used to read in points, print them out, find the x/y values,
// set x/y values, and determine if two points are equal.
//=================================================
class Point{

    // data members
    int x;
    int y;

    // member functions

    // default constructor
    Point(){
        x = 0;
        y = 0;
    } 

    // overloaded constructor
    Point(int x_val, int y_val){
        x = x_val;
        y = y_val;
    }

    // copy constructor
    Point(Point other){
        x = other.x;
        y = other.y;
    }


    // getX method
    public int getX(){
        return x;
    }

    // getY method
    public int getY(){
        return y;
    }


    // setX method
    public void setX(int x_value){
        x = x_value;
    }


    // setY method
    public void setY(int y_value){
        y = y_value;
    }

    // isEqual method
    public boolean isEqual(Point point){
        int x_value = point.getX();
        int y_value = point.getY();
        if(x_value == x && y_value == y){
            return true;
        } else {
            return false;
        }
    }

    // read method
    public static Point read(Scanner input){
        int x_value = input.nextInt();
        int y_value = input.nextInt();
        Point retval = new Point(x_value, y_value);
        return retval;
    }

    // print method
    public void print(){
        String retval = "(" + x + ", " + y + ")";
        System.out.println(retval);
    }
}