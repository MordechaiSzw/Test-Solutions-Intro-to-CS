public class b2017_moedB4_20454 {
	
	// counts the number of "true regions" in a boolean matrix
	public static int countTrueReg (boolean mat[][]) {
		//calls private overloading method starting from first index
		return countTrueReg(mat, 0, 0);
	} 
	
	//private overloading method to count true region
	private static int countTrueReg (boolean [][]mat, int r, int c) {
		//base case - reached end of matrix
		if (r == mat.length - 1 && c == mat[0].length - 1) {
			if (mat[r][c] == true)
				return 1;
			return 0;
		} //end of base case
		//checking if ended to scan current row - start next row
		if (c > mat[0].length - 1) 
			return countTrueReg(mat, r+1, 0);
		//calculation - recursive calls
		if (mat[r][c] == true) {
			resetReg(mat, r, c); //reset region to false
			return 1 + countTrueReg(mat, r, c+1);
		} //end of found true
		return countTrueReg(mat, r, c+1);
	}
	
	//private recursive method to reset true region to false
	private static void resetReg (boolean[][]mat, int r, int c) {
		//checking if we are within array bounds
		if (r > mat.length - 1 || c > mat[0].length - 1 || r < 0 || c < 0)
			return;
		//base case - reached false (end of region)
		if (mat[r][c] == false)
			return;
		if (mat[r][c] == true) {
			mat[r][c] = false;
			resetReg(mat, r, c+1); //one to right
			resetReg(mat, r, c-1); //one to left
			resetReg(mat, r+1, c); //one down
			resetReg(mat, r-1, c); //one up
		}
	}
}
