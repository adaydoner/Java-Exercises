package algorithms;

import java.util.HashSet;
import java.util.Set;

public class Sudoku2 {

	public static void main(String[] args) {
		char[][] grid = new char[][] 
				{{'.','4','.','.','.','.','.','.','.'},
			 {'.','.','4','.','.','.','.','.','.'}, 
			 {'.','.','.','1','.','.','7','.','.'}, 
			 {'.','.','.','.','.','.','.','.','.'}, 
			 {'.','.','.','3','.','.','.','6','.'}, 
			 {'.','.','.','.','.','6','.','9','.'}, 
			 {'.','.','.','.','1','.','.','.','.'}, 
			 {'.','.','.','.','.','.','2','.','.'}, 
			 {'.','.','.','8','.','.','.','.','.'}};
		System.out.println(sudoku3(grid));
	}

	private static boolean sudoku2(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				char c = grid[i][j];
				
				if(!checkRow(grid,i,c,j)) return false;
				if(!checkColumn(grid,j,c,i)) return false;
				if(!check3x3(grid,c,i,j)) return false;
				
			}
		}
		return true;
	}
	

	private static boolean checkRow(char[][] grid, int i, char c, int j) {
		if(c == '.') return true;
		for (int k = j + 1; k < grid.length; k++) {
			if(grid[i][k] == c) return false;
		}
		return true;
	}


	private static boolean checkColumn(char[][] grid, int j, char c, int i) {
		if(c == '.') return true;
		for (int k = i+1; k < grid.length; k++) {
			if(grid[k][j] == c) return false;
		}
		return true;
	}
	
	private static boolean check3x3(char[][] grid, char c, int i , int j) {
		if(c == '.') return true;
		int subGridX = (i / 3) * 3;
		int subGridY = (j / 3) * 3;
		for (int k = subGridX; k <= subGridX + 2; k++) {
			for (int l = subGridY; l <= subGridY + 2; l++) {
				if(grid[k][l] == c && k != i && l != j) return false;
			}
		}
		
		return true;
	}

	/*
	 * 00 01 02		03 04 05	06 07 08
	 * 10 11 12		13 14 15	16 17 18
	 * 20 21 22		23 24 25	26 27 28
	 * 
	 * 30 31 32		33 34 35	36 37 38
	 * 40 41 42		43 44 45	46 47 48
	 * 50 51 52		53 54 55	56 57 58
	 * 
	 * 60 61 62		63 64 65	66 67 68
	 * 70 71 72		73 74 75	76 77 78
	 * 80 81 82		83 84 85	86 87 88
	 * 
	 * sub-grids are (X,Y) -> (X+2,Y+2)
	 */

	
	private static boolean sudoku3(char[][] grid) {
	    int n = grid.length;
	    
	    Set<String> set = new HashSet<String>();
	    
	    for (int row = 0; row < n ; row++) {
	        for (int col = 0; col < n; col++) {
	            if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
	                return false;
	            if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
	                return false;
	            if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row/3 + " " + col/3))
	                return false;
	        }
	    } 
	    
	    return true;
	}
}
