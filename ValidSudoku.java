import java.util.HashSet;

public class ValidSudoku {
//	public static boolean isValidSudoku(char[][] board) {
//		
//		// check rows 
//		for (char[] row : board)
//		{
//			// define the target # we're searching for 
//			for (int i = 1; i < 10; i++)
//			{
//				if (!ValidateOccurences(row, (char) ('0' + i)))
//				{
//					return false;
//				}
//			}
//		}
//		
//		// check columns
//		char[][] transposed = getColumns(board);
//		for (char[] column : transposed)
//		{
//			// define the target # we're searching for 
//			for (int i = 1; i < 10; i++)
//			{
//				if (!ValidateOccurences(column, (char) ('0' + i)))
//				{
//					return false;
//				}
//			}
//		}
//		
//		
//		// for squares
//		char[][] squares = getSquares(board);
//		for (char[] square : squares)
//		{
//			// define the target # we're searching for 
//			for (int i = 1; i < 10; i++)
//			{
//				if (!ValidateOccurences(square, (char) ('0' + i)))
//				{
//					return false;
//				}
//			}
//		}
//		
//		
//		return true;
//	 }
//	
//	public static boolean ValidateOccurences(char[] section, char value)
//	{
//		// use streams to count # occurences for the current int value 
//		int counter = (int) new String(section)
//				.chars()
//				.filter(c -> c == value)
//				.count();
//		
//		if (counter > 1)
//		{
//			return false;
//		}
//		
//		return true;
//	}
//	
//	// rotates the array so that rows become columns and vice versa
//	public static char[][] getColumns (char[][] board)
//	{
//		int rows = board.length;
//		int columns = board[0].length;
//		char[][] transposedBoard = new char[columns][rows];
//		
//		for (int i = 0; i < rows; i++)
//		{
//			for (int j = 0; j < rows; j++)
//			{
//				transposedBoard[j][i] = board[i][j];
//			}
//		}
//		
//		return transposedBoard;
//	}
//	
//	// manipulates array so all possible squares are laid out in per each row
//	public static char[][] getSquares (char[][] board)
//	{
//		int rows = board.length;
//		int columns = board[0].length;
//		char[][] squares = new char[columns][rows];
//		int squareIndex = 0;
//		
//		// for the 3 vertical sections 
//		for (int br = 0; br < 3; br++)
//		{
//			// for the 3 horizontal sections 
//			for (int bc = 0; bc < 3; bc++)
//			{
//				int index = 0;
//				for (int i = 0; i < 3; i++)
//				{
//					for (int j = 0; j < 3; j++)
//					{
//						squares[squareIndex][index++] = board[br * 3 + i][bc * 3 + j];
//					}
//				}
//				squareIndex++;
//				
//			}
//		}
//		return squares;
//	}
	
	// https://neetcode.io/problems/valid-sudoku 
	// faster and more efficient approach
	public static boolean isValidSudoku(char[][] board)
	{
		HashSet<Character>[] rows = new HashSet[9];
		HashSet<Character>[] columns = new HashSet[9];
		HashSet<Character>[] squares = new HashSet[9];
		
		for (int i = 0; i < 9; i++)
		{
			rows[i] = new HashSet<>();
			columns[i] = new HashSet<>();
			squares[i] = new HashSet<>();
		}
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				char num = board[i][j];
				// if its blank, we don't care
				if (num == '.')
				{
					continue;
				}
				
				int squareIndex = (i / 3) * 3 + (j / 3);
				if (rows[i].contains(num) || columns[j].contains(num) || squares[squareIndex].contains(num))
				{
					return false;
				}
				
				rows[i].add(num);
				columns[j].add(num);
                squares[squareIndex].add(num);
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		char[][] board1 = 
				   {{'1','2','.','.','3','.','.','.','.'},
					{'4','.','.','5','.','.','.','.','.'},
					{'.','9','8','.','.','.','.','.','3'},
					{'5','.','.','.','6','.','.','.','4'},
					{'.','.','.','8','.','3','.','.','5'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','.','.','.','.','.','2','.','.'},
					{'.','.','.','4','1','9','.','.','8'},
					{'.','.','.','.','8','.','.','7','9'}};

		boolean result = isValidSudoku(board1); // should return true
		System.out.println(result);
		
		char[][] board2 = 
				{{'1','2','.','.','3','.','.','.','.'},
				 {'4','.','.','5','.','.','.','.','.'},
				 {'.','9','1','.','.','.','.','.','3'},
				 {'5','.','.','.','6','.','.','.','4'},
				 {'.','.','.','8','.','3','.','.','5'},
				 {'7','.','.','.','2','.','.','.','6'},
				 {'.','.','.','.','.','.','2','.','.'},
				 {'.','.','.','4','1','9','.','.','8'},
				 {'.','.','.','.','8','.','.','7','9'}};

		result = isValidSudoku(board2); // should return false
		System.out.println(result);

				

	}
}
