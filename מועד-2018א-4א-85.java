public class Test {
  public static int longestSlope(int [][] mat, int num) {
    return longestSlope(mat, num, 0, 0, 0);
  }
  
  private static int longestSlope(int [][] mat, int num, int r, int c, int max) {
    if (r < 0 || c < 0 || r > mat.length-1 || c < mat[r].length-1)
      return 0;
    int currSlope = currSlope(mat, num, r, c, mat[r][c], 0);
    if (currSlope > max)
      max = currSlope;
    if (c == mat[r].length-1)
      return max(max, longestSlope(mat, num, r+1, 0, max));
    return max(max, longestSlope(mat, num, r, c+1, max));
  }
  
  private static int currSlope(int [][] mat, int num, int r, int c, int curr, int counter) {
    if (r < 0 || c < 0 || r > mat.length-1 || c < mat[r].length-1)
      return 0;
    int newCurr = mat[r][c];
    if (newCurr == curr - num || r == 0 && c == 0) {
      int up = currSlope(mat, num, r-1, c, newCurr, counter+1);
      int down = currSlope(mat, num, r+1, c, newCurr, counter+1);
      int left = currSlope(mat, num, r, c-1, newCurr, counter+1);
      int right = currSlope(mat, num, r, c+1, newCurr, counter+1);
      counter = max(up, down, left, right);
    }
    return counter;
  }
  
  private static int max(int n1, int n2, int n3, int n4) {
    int max1 = max(n1, n2);
    return max(max1, max(n3, n4));
  }
  
  private static int max(int n1, int n2) {
    if (n1 > n2)
      return n1;
    return n2;
  }
}
