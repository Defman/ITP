
/**
 * Write a description of class Sort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sort 
{
    int insertionSortN;
    // instance variables - replace the example below with your own
    public static void insertionSort(int arr[]) 
    {  
        int n = arr.length;  
        for (int i = 1; i < n; i++)
        {   
            int key = arr[i];  
            int j = i-1;  

            while ( (j > -1) && ( arr [j] > key ) ) 
            {  
                arr [j+1] = arr [j];  
                j--;  
            }  
            arr[j+1] = key;
            printArray(arr);
        }  
    }
    
    public static void mergeSort(int arr[]){
        
    }
    
    static void printArray(int[] array){

        for(int i=0; i < array.length; i++)
        {  
            System.out.print(array[i] + " ");  
        } 
        System.out.println();
    }
    
}