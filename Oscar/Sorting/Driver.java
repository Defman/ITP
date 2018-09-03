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
    private int rememberHigh;
    private int rememberLow;
    
    Driver(int n, int rHigh, int rLow){
      r = new Random();
      myArray = new int[n];   
      rememberHigh = rHigh;
      rememberLow = rLow;
    }
    
    public void mergeSortArray(){
        ob.mergeSort(GenerateRandomArray(),1,GenerateRandomArray().length-1);
    }
    
    public void insertionSortArray(){
        int[] A = GenerateRandomArray();
        ob.insertionSort(A);
        ob.printArray(A);
        

    }
    
   
    public int[] GenerateRandomArray(){
      for (int i = 0; i < myArray.length; i++) {
      myArray[i] = r.nextInt(rememberHigh)+rememberLow;
    }
        System.out.println(Arrays.toString(myArray));
        return myArray;
    }
    
    
}
