/**
* מועד 2012א-92-5ב
*
* @author Mordechai S.
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
  
  
}
