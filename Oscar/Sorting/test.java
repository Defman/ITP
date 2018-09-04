
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    //{3,5,7,9,11,17,19,23,31,33,37}
    public int BinarySearch(int[] A, int low, int high, int key){
        int mid = (low+high)/2;
        if(low>high){
        return low+1;
        }
        if(A[mid]>key){
        return BinarySearch(A,low,mid-1,key);
        }
        else if (A[mid]<key){
         return BinarySearch(A,mid+1,high,key);   
    }
        else {
        return mid+1;
        }
    }

    public int FindPos(int[] A, int key){
        int low = 0;
        int high = 1;
        int value = A[0];
        while(value < key){
            low = high;
            high = 2*high;
            value = A[high];
        }
        return BinarySearch(A,low,high,key);
    }    
}