package game;

import java.util.Scanner;

public class BattleShips {
	static Scanner input = new Scanner(System.in);
	private static int computerShips = 0;
	private static int playerShips = 0;

	public static void main(String[] args) {
		char[][] gameBoard = new char[12][16];
		int x;
		int y;
		// ocean is between [1][3] to [1][12] all the way down to [10][3] to
		// [10][12]
		setIndexes(gameBoard);
		printBoard(gameBoard);
		getUsersShips(gameBoard);
		getComputersShips(gameBoard);
		printBoard(gameBoard);

		while (!isGameOver(gameBoard)) {
			System.out.println("YOUR TURN");
			do {
				System.out.print("Enter X coordinate for shoot : ");
				x = input.nextInt() + 1;
				System.out.print("Enter Y coordinate for shoot : ");
				y = input.nextInt() + 3;
			} while (!isCoordinatesValid(gameBoard, x, y));

			whatHappened(gameBoard, x, y, '1');

			System.out.println("-------Computer's move ");
			do {
				x = (int) (Math.random() * 10) + 1;
				y = (int) (Math.random() * 10) + 3;
			} while (!isCoordinatesValidForShoot(gameBoard, x, y));

			whatHappened(gameBoard, x, y, 'C');

			printBoard(gameBoard);
			printScore();
		}
		if(computerShips == 0){
			System.out.println("Hooray!! You won the battle !");
		} else {
			System.out.println("Computer won the battle !");
		}

	}

	private static boolean isCoordinatesValidForShoot(char[][] gameBoard, int x, int y) {
		if (x < 1 || x > 10 || y < 3 || y > 12 || gameBoard[x][y] == '!' || gameBoard[x][y] == 'X' || gameBoard[x][y] == '-') {
			return false;
		}
		return true;
	}

	private static void printScore() {
		System.out.println("Your Ships : " + playerShips + "|" + "Computer Ships : " + computerShips);
		System.out.println("------------------------------------------------------------------------");
	}

	public static void whatHappened(char[][] gameBoard, int x, int y, char player) {
		char enemy = (player == '1') ? 'C' : '1';

		if (gameBoard[x][y] == player) {
			if (player == '1') {
				System.out.println("Oh no, you sunk your own ship :(");
				playerShips--;
			} else {
				System.out.println("Computer sunk its own ship");
				computerShips--;
			}
			gameBoard[x][y] = 'X';
		} else if (gameBoard[x][y] != enemy && gameBoard[x][y] != 'X' && gameBoard[x][y] != '!') {
			if (player == '1') {
				System.out.println("You missed");
			} else {
				System.out.println("Computer missed");
			}
			gameBoard[x][y] = '-';
		} else if (gameBoard[x][y] == enemy) {
			if (player == '1') {
				System.out.println("Boom! You sunk the ship!");
				computerShips--;
			} else {
				System.out.println("Boom! Computer sunk your ship!");
				playerShips--;
			}
			gameBoard[x][y] = '!';
		}
	}

	private static void getComputersShips(char[][] gameBoard) {
		int x;
		int y;
		//int shipCounter = 0;
		System.out.println("Computer is deploying ships");
		while (computerShips < 5) {
			do {
				x = (int) (Math.random() * 10) + 1;
				y = (int) (Math.random() * 10) + 3;
			} while (!isCoordinatesValidForShipPlacement(gameBoard, x, y));
			gameBoard[x][y] = 'C';
			computerShips++;
			System.out.println(computerShips + ". ship DEPLOYED");
		}
		System.out.println("-----------------------------");
	}

	private static void getUsersShips(char[][] gameBoard) {
		int x;
		int y;
		//int shipCounter = 0;
		while (playerShips < 5) {
			do {
				System.out.print("Enter X coordinate for your ship : ");
				x = input.nextInt() + 1;
				System.out.print("Enter Y coordinate for your ship : ");
				y = input.nextInt() + 3;
			} while (!isCoordinatesValidForShipPlacement(gameBoard, x, y));
			gameBoard[x][y] = '1';
			printBoard(gameBoard);
			playerShips++;
		}
	}

	private static boolean isGameOver(char[][] gameBoard) {
		if(playerShips == 0 || computerShips == 0){
			return true;
		}
		return false;
	}

	private static boolean isCoordinatesValidForShipPlacement(char[][] gameBoard, int x, int y) {
		// x += 1;
		// y += 3;
		if (x < 1 || x > 10 || y < 3 || y > 12 || gameBoard[x][y] == '1') {
			return false;
		}
		return true;
	}

	private static void printBoard(char[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (1 <= i && i <= 10 && 3 <= j && j <= 12 && gameBoard[i][j] == '1') {
					System.out.print('@');
					continue;
				}  else if (1 <= i && i <= 10 && 3 <= j && j <= 12 &&
					 gameBoard[i][j] == 'C'){
					 System.out.print(' ');
					}
				else {
					System.out.print(gameBoard[i][j]);
				}
			}
			System.out.println();
		}
	}

	private static boolean isCoordinatesValid(char[][] gameBoard, int x, int y) {
		if (x < 1 || x > 10 || y < 3 || y > 12) {
			return false;
		}
		return true;
	}

	private static void setIndexes(char[][] gameBoard) {
		// top
		gameBoard[0][3] = '0';
		gameBoard[0][4] = '1';
		gameBoard[0][5] = '2';
		gameBoard[0][6] = '3';
		gameBoard[0][7] = '4';
		gameBoard[0][8] = '5';
		gameBoard[0][9] = '6';
		gameBoard[0][10] = '7';
		gameBoard[0][11] = '8';
		gameBoard[0][12] = '9';

		// sides
		gameBoard[1][0] = '0';
		gameBoard[1][1] = ' ';
		gameBoard[1][2] = '|';
		gameBoard[2][0] = '1';
		gameBoard[2][1] = ' ';
		gameBoard[2][2] = '|';
		gameBoard[3][0] = '2';
		gameBoard[3][1] = ' ';
		gameBoard[3][2] = '|';
		gameBoard[4][0] = '3';
		gameBoard[4][1] = ' ';
		gameBoard[4][2] = '|';
		gameBoard[5][0] = '4';
		gameBoard[5][1] = ' ';
		gameBoard[5][2] = '|';
		gameBoard[6][0] = '5';
		gameBoard[6][1] = ' ';
		gameBoard[6][2] = '|';
		gameBoard[7][0] = '6';
		gameBoard[7][1] = ' ';
		gameBoard[7][2] = '|';
		gameBoard[8][0] = '7';
		gameBoard[8][1] = ' ';
		gameBoard[8][2] = '|';
		gameBoard[9][0] = '8';
		gameBoard[9][1] = ' ';
		gameBoard[9][2] = '|';
		gameBoard[10][0] = '9';
		gameBoard[10][1] = ' ';
		gameBoard[10][2] = '|';

		gameBoard[1][15] = '0';
		gameBoard[1][14] = ' ';
		gameBoard[1][13] = '|';
		gameBoard[2][15] = '1';
		gameBoard[2][14] = ' ';
		gameBoard[2][13] = '|';
		gameBoard[3][15] = '2';
		gameBoard[3][14] = ' ';
		gameBoard[3][13] = '|';
		gameBoard[4][15] = '3';
		gameBoard[4][14] = ' ';
		gameBoard[4][13] = '|';
		gameBoard[5][15] = '4';
		gameBoard[5][14] = ' ';
		gameBoard[5][13] = '|';
		gameBoard[6][15] = '5';
		gameBoard[6][14] = ' ';
		gameBoard[6][13] = '|';
		gameBoard[7][15] = '6';
		gameBoard[7][14] = ' ';
		gameBoard[7][13] = '|';
		gameBoard[8][15] = '7';
		gameBoard[8][14] = ' ';
		gameBoard[8][13] = '|';
		gameBoard[9][15] = '8';
		gameBoard[9][14] = ' ';
		gameBoard[9][13] = '|';
		gameBoard[10][15] = '9';
		gameBoard[10][14] = ' ';
		gameBoard[10][13] = '|';

		// bottom
		gameBoard[11][3] = '0';
		gameBoard[11][4] = '1';
		gameBoard[11][5] = '2';
		gameBoard[11][6] = '3';
		gameBoard[11][7] = '4';
		gameBoard[11][8] = '5';
		gameBoard[11][9] = '6';
		gameBoard[11][10] = '7';
		gameBoard[11][11] = '8';
		gameBoard[11][12] = '9';

	}
}
