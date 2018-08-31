import java.util.*;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver extends Sort
{
    private Sort ob;
    private int[] myArray;
    private Random r;
    
    Driver(int n){
      r = new Random();
      myArray = new int[n];   
    }
    
    public void insertionSortArray(){
        ob.insertionSort(GenerateRandomArray());

    }
   
    public int[] GenerateRandomArray(){
      for (int i = 0; i < myArray.length; i++) {
      myArray[i] = r.nextInt();
    }
        System.out.println(Arrays.toString(myArray));
        return myArray;
    }
    
    
}
