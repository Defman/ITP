
/**
 * Write a description of class Sort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sort 
{

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

    static void mergeSort(int[] array, int low, int high){
        if(low < high){
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle+1, high);
            merge(array, low, middle, high);
            printArray(array);
        }   
    }

    static void merge(int[] array, int low, int middle, int high){
        int[] helper = new int[array.length];
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        while (helperLeft <= middle && helperRight <=high) {
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;

            }else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current ++;     
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current+i] = helper[helperLeft+ i];
        }
    }

    static void printArray(int[] array){

        for(int i=0; i < array.length; i++)
        {  
            System.out.print(array[i] + " ");  
        } 
        System.out.println();
    }

}
