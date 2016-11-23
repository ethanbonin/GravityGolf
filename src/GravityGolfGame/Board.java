package GravityGolfGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Board {
	
	private static final int MAX_BOARD_SIZE = 100;
	private static Board theInstance = new Board();
	private static BoardCell[][] grid = new BoardCell[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
	String csvFile;
	
	private Board() {
		
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
	
	public void loadBoardConfig() throws FileNotFoundException {
		BufferedReader fileReader = null;

			FileReader readerTwo = new FileReader(csvFile);
			Scanner in = new Scanner(readerTwo);
			fileReader = new BufferedReader(new FileReader(csvFile));

			// This while loop detects the number of rows.
			int value = 0;
			String word = "";
			while (in.hasNextLine()) {
				word = in.nextLine();
				value++;
			}

			for (int i = 0; i < word.length(); i++) {
				word = word.replace(",", "");

			}

			int NUM_COLS = word.length();
			int NUM_ROWS = value;

			this.grid = new BoardCell[NUM_ROWS][NUM_COLS];

			int i = 0;
			int count = 0;
			String line;

			for (int j = 0; j < NUM_COLS; j++) {
				this.grid[i][j] = new BoardCell(i, j);
			}
			
			in.close();
		}

	public static BoardCell getCellAt(int i, int j) {
		return grid[i][j];
	}
}
