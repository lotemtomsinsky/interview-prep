// https://neetcode.io/problems/valid-sudoku 

import java.util.HashSet;

public class ValidSudoku {	
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
