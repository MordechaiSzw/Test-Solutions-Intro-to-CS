/**
* מועד 2012 א 2א
*
* @author Mordechai S.
* @version 2.0
*/
public class Test {
  //Question 1:
  public static void mirror(int[]a) {
        // first print array (0 swaps)
        printArr(a,0);
        // print all the possible variations
        mirror(a, 0, a.length-1);
    }
    
    private static void mirror(int[]a,int i,
                                      int j) 
    {
        if(i >= j)
            return;
            
        if(a[i] == a[j]){
            mirror(a, i+1, j-1);
            return;
            }
        else
        swap(a, i, j);
        printArr(a,0);
        mirror(a, i+1, j-1);
        swap(a, i, j);
        mirror(a, i+1, j-1);
    }
    
    private static void printArr(int[]a, int i) {
        if(i == a.length) {
            System.out.println();
            return;
        }
        
        System.out.print(a[i] + " ");
        printArr(a, i+1);
    }
    
    private static void swap(int[]a,int i,int j){
        int temp = a[i];
        a[i] =a[j];
        a[j] = temp;
    }
}
