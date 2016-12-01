package GravityGolfGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Board {
	
	private static final int MAX_BOARD_SIZE = 100;
	private static Board theInstance = new Board();
	private static BoardCell[][] grid;
	String csvFile;
	
	int numCols;
	int numRows;
	
	private Board() {
		grid = new BoardCell[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
	}
	
	public static Board getInstance() {
		return theInstance;
	}

	public static boolean isGameOver() {
		//I will create this method when more pars are implemented (Nick)
		//Player will win when the ball reaches a certain spot, simple condition statement
		//TO DO: Need to implement the ball
		
		return false;
	}
	
	public static void pauseGame() {
		
	}

	public void setConfigFiles(String file) {
		csvFile = file;
	}
	
	public void load(){
		
		try {
			loadBoardConfig();
		} catch (IOException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
	}
	
	private void loadBoardConfig() throws IOException {
		
		FileReader file = new FileReader(csvFile);
		BufferedReader in = new BufferedReader(file);

		String line;
		int i = 0;
		while ((line = in.readLine()) != null) {

			String[] cells = line.split(",");
			
			numCols = cells.length;
			
			for (int j = 0; j < cells.length; j++) {
				
				boolean start = false;
				boolean end = false;
				
				if (cells[j].charAt(0) == 's'){
					start = true;
				} else if (cells[j].charAt(0) == 'e') {
					end = true;
				}

				grid[i][j] = new BoardCell(i, j, start, end, cells[j].charAt(0));
			}
			i++;
		}
		numRows = i;
	}

	public BoardCell getCellAt(int i, int j) {
		return grid[i][j];
	}
}
