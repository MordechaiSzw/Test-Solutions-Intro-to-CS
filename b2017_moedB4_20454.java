public class b2017_moedB4_20454 {
	
	//Question_1
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
	
	//Question_2
	//----------------------------------------------------------------------------
	//searches num in the Ranges array. Return index or -1
	//Algorithm: 1- bisective search for possible index
	//           2- calculate (using center +/- radius) if num is in the range.
	//Time complexity: O(log n). Space complexity: O(1)
	//----------------------------------------------------------------------------
	public static int findNum (Range []rangeA, int num) {
		if (rangeA == null)
			return -1;
		//first check if num is within "absolute" range
		int last = rangeA.length-1;
		if (num < rangeA[0].getCenter() - rangeA[0].getRadius()
		   || num > rangeA[last].getCenter() + rangeA[last].getRadius())
		    return -1;
	     	//bisective search for possible Range obj. where num could be
		int hi = last, lo = 0, mid;
	    	while(lo <= hi) { // log n
			mid = (hi + lo)/2;
			if (num <= rangeA[mid].getCenter() + rangeA[mid].getRadius() 
			   && num >= rangeA[mid].getCenter() - rangeA[mid].getRadius())
				return mid;
			else if (num > rangeA[mid].getCenter() + rangeA[mid].getRadius())
				lo++;
			else if (num < rangeA[mid].getCenter() - rangeA[mid].getRadius())
				hi--;
		}//end of search - num isn't there
	    	return -1;
	}
	
}
