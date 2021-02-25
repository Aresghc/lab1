
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name:Hongchi Guo
Student Number:215257447
Course Section:A
*/

package Assignment1;
import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
		this.row= row;
		this.column = column;
		this.map = new boolean[row][column];
	}
	public Map() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow >= 0 && startRow < row && startCol >= 0 && startCol < column && destRow >=0 && destRow <row && destCol >= 0&& destCol<column)	
		{
			if(startRow >= destRow && startCol >= destCol) 
			 return goSouthWest (startRow,  startCol, destRow, destCol , path);
			else if(startRow <= destRow && startCol >= destCol)
				return goSouthEast(startRow,startCol,destRow,destCol,path);
			else if(startRow <= destRow && startCol <= destCol)
				return goNorthEast(startRow,startCol,destRow,destCol,path);
			else
				return goNorthWest(startRow,startCol,destRow,destCol,path);
		}
			else
				throw new IllegalArgumentException();
		}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = " ";
		Map m = new Map();
		if(startRow >destRow) {
			path += "(" + (startRow-1) +"," +startCol +")";
			return (path + m.goSouthWest(startRow-1, startCol, destRow, destCol, path));
		}
		if(startCol > destCol) {
			path += "("+startRow+","+(startCol-1)+")";
			return (path + m.goSouthWest(startRow, startCol-1, destRow, destCol, path));
		}
		return path;
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = " ";
		Map m = new Map();
		if(startRow <destRow) {
			path += "(" + (startRow+1) +"," +startCol +")";
			return (path + m.goSouthEast(startRow+1, startCol, destRow, destCol, path));
		}
		if(startCol > destCol) {
			path += "("+startRow+","+(startCol-1)+")";
			return (path + m.goSouthEast(startRow, startCol-1, destRow, destCol, path));
		}
		return path;
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = " ";
		Map m = new Map();
		if(startRow <destRow) {
			path += "(" + (startRow+1) +"," +startCol +")";
			return (path + m.goNorthEast(startRow+1, startCol, destRow, destCol, path));
		}
		if(startCol < destCol) {
			path += "("+startRow+","+(startCol+1)+")";
			return (path + m.goNorthEast(startRow, startCol+1, destRow, destCol, path));
		}
		return path;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = " ";
		Map m = new Map();
		if(startRow >destRow) {
			path += "(" + (startRow-1) +"," +startCol +")";
			return (path + m.goNorthWest(startRow-1, startCol, destRow, destCol, path));
		}
		if(startCol < destCol) {
			path += "("+startRow+","+(startCol+1)+")";
			return (path + m.goNorthWest(startRow, startCol+1, destRow, destCol, path));
		}
		return path;
	}
	
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */
	
	public String findPath (int startRow, int startCol) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow+1 >= this.row || startRow < 0 || startCol+1 >= this.column || startCol < 0){
			return "("+startRow+","+startCol+") ";
		}
		if(map[this.row-startRow][startCol] == false){
			map[this.row-startRow][startCol] = true;
			return "("+startRow+","+startCol+") "+findPath(startRow+1,startCol);
		}else if (map[this.row-startRow-2][startCol] == false){
			map[this.row-startRow-1][startCol] = true;
			return "("+startRow+","+startCol+") "+findPath(startRow-1,startCol);
		}else if(map[this.row-startRow][startRow+1] == false){
			map[this.row-startRow][startCol-1] = true;
			return "("+startRow+","+startCol+") "+findPath(startRow,startCol+1);
		}else if(map[this.row-startRow][startCol-1] == false){
			map[this.row-startRow][startCol-1] = true;
			return "("+startRow+","+startCol+") "+findPath(startRow,startCol-1);
		}else {
			return " ";
		}
	}

		
} // end of class
