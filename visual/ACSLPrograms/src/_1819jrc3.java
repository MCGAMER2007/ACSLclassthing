import java.util.*;


public class _1819jrc3 {
	static Scanner in;
	
	static int sRow, sCol;
	static int[][] grid;
	static int currPiece;
	
	static String path;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i = 0;i<5;i++) {
			init();
			solve();
			output();
		}
	}
	
	
	public static void init() {
		
		int r = in.nextInt();
		int c = in.nextInt();
		
		grid = new int[r][c];
		
		int s = in.nextInt();
		sRow = (s - 1) / c;
		sCol = (s - 1) % c;
		
		int n = in.nextInt();
		for(int i = 0;i<n;i++) {
			int l = in.nextInt();
			int br = (l - 1) / c;
			int bc = (l - 1) % c;
			grid[br][bc] = -1;
		}
		
		path = "";
	
		
		
		currPiece = 0;
	}
	
	public static void solve() {
		int currRow = sRow;
		int currCol = sCol;
		while(currCol < grid[0].length - 1) {
			int[] newPos = placeNext(currRow, currCol);
			currRow = newPos[0];
			currCol = newPos[1];
			path += (char)newPos[2];
		}
	}
	
	public static void output() {
		System.out.println(path);
	}
	
	public static int[] placeNext(int row, int col) {
		int[] newPos = {0, 0, 0};
		if(currPiece == 0) {
			if(canPlaceA(row, col)) {
				placeA(row, col);
				newPos[0] = row;
				newPos[1] = col + 3;
				newPos[2] = 'A';
			}
			else {
				currPiece++;
				return placeNext(row, col);
			}
		}
		else if(currPiece == 1) {
			if(canPlaceB(row, col)) {
				placeB(row, col);
				newPos[0] = row + 1;
				newPos[1] = col + 2;
				newPos[2] = 'B';
			}
			else {
				currPiece++;
				return placeNext(row, col);
			}
		}
		else {
			if(canPlaceC(row, col)) {
				placeC(row, col);
				newPos[0] = row + 2;
				newPos[1] = col + 2;
				newPos[2] = 'C';
			}
			else {
				currPiece = 0;
				return placeNext(row, col);
			}
		}
		
		currPiece ++;
		if(currPiece == 3) currPiece = 0;
		
		
		return newPos;
	}
	
	public static void placeA(int row, int col) {
		grid[row][col] = 1;
		grid[row][col + 1] = 1;
		grid[row][col + 2] = 1;
	}
	
	public static boolean canPlaceA(int row, int col) {
		return (0 <= row && row < grid.length) && (0 <= col && col < grid[0].length-2) &&
				grid[row][col] == 0 && 
				grid[row][col + 1] == 0 &&
				grid[row][col + 2] == 0;
	}
	
	public static void placeB(int row, int col) {
		grid[row][col] = 1;
		grid[row + 1][col] = 1;
		grid[row + 1][col + 1] = 1;
	}
	
	public static boolean canPlaceB(int row, int col) {
		return (0 <= row && row < grid.length - 1) && (0 <= col && col < grid[0].length - 1) &&
				grid[row][col] == 0 &&
				grid[row + 1][col] == 0 &&
				grid[row + 1][col + 1] == 0;
	}
	
	public static void placeC(int row, int col) {
		grid[row][col] = 1;
		grid[row][col + 1] = 1;
		grid[row + 1][col + 1] = 1;
		grid[row + 2][col + 1] = 1;
	}
	
	public static boolean canPlaceC(int row, int col) {
		return  (0 <= row && row < grid.length - 2) && (0 <= col && col < grid[0].length - 1) &&
				grid[row][col] == 0 && 
				grid[row][col + 1] == 0 && 
				grid[row + 1][col + 1] == 0 && 
				grid[row + 2][col + 1] == 0;
	}
}
