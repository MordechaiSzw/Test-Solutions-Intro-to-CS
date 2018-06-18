/**
* מועד 2012א-92-5ב
*
* @author Mordechai S. with help of others (and בס"ד)
* @version 2.0
*/
public class Test {
  //Question 1:
  public static void mirror(int[]a) 
  {
        // first print array (0 swaps)
        printArr(a,0);
        // print all the possible variations
        mirror(a, 0, a.length-1);
  }
    
  /*--------------------------------------------------
  //prints all the "mirrors" by swapping two symetric numbers
  //and then keep swaping till the middle. Then unswapping all
  //the way back and reswapping till not possible. This way we
  //cover all the options.
  */
  private static void mirror(int[]a,int i, int j) 
  {
      if(i >= j)
          return;
      //if a[i]=a[j], mirror next numbers    
      if(a[i] == a[j]){
          mirror(a, i+1, j-1);
          return;
          }
      //swap start and end
      swap(a, i, j);
      //print current mirrored array
      printArr(a,0);
      //keep mirroring until got to the middle
      mirror(a, i+1, j-1);
      //now undo last swap and mirror everything from there
      swap(a, i, j);
      mirror(a, i+1, j-1);
  }
    
  //private method to print array of int
  private static void printArr(int[]a, int i) 
  {
      if(i == a.length) {
          System.out.println();
          return;
      }
      System.out.print(a[i] + " ");
      printArr(a, i+1);
  }
  
  //private method to swap two cell values in array
  private static void swap(int[]a,int i,int j)
  {
      int temp = a[i];
      a[i] =a[j];
      a[j] = temp;
  }
  
  //----------------------------------------------------------------------------------
  //Question 2: 
  /*
  * a:
  * There are more 'c' than 'a' and all the 'a' are placed before the 'c'. Thus if we are 
  * at index i and it's 'a' (i.e we know there are at least i+1 'a'), we know there are at 
  * least (i+1)*2 'c', so we can jump to index (i+1)*2. If it's not 'a', return it. Else, 
  * jump again. 
  * Time complexity: O(log n) (because we jump in exponences of 2). Space comp.: O(1) (const. num of vars.)
  */
  public static int findBC (String s)
  {
    int i = 0;
    while(s.charAt(i) == 'a')
      i = (i+1)*2; //explained above
    return i; //there is at least 1 'c' so will give a correct answer
  }
  
  /*
  * b:
  * The method written in 2.a returns result = (i+1)*2, i is the last found 'a', and result
  * must be the index of 'b' or 'c'. All 'c' come after 'b', so if there is at least 1 'b',
  * it must be between i and result. So we can do a binary search between i and result, and return
  * index of 'b' preceded by 'a'.
  * i = (result+2)/2. Time complexity: O(log n) (binary search). Space compl.: O(1).
  */
  public static int firstB(String s)
  {
    int end = findBC(s); //O(log n)
    int start = (end+2)/2;
    int mid;
    while(start <= end)
    {
      mid = (start+end)/2;
      if(s.charAt(mid-1) == 'a')
        if(s.charAt(mid) == 'b')
          return mid;
        else if(s.charAt(mid) == 'c')
          return -1;
      if(s.charAt(mid) == 'a')
        start = mid+1;
      else //if 'b' or 'c', must be before (not first 'b')
        end = end-1;
    }
    return -1;
  }
  
  //----------------------------------------------------------------------------------
  //Question 3:
  
}
