import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Write a description of class TØ1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TØ1
{
    public void lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            System.out.println("The array is empty - no longest acending order");
        }
        
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                System.out.println(nums[i]);
            } else {
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
                System.out.println("T:"+nums[i]);
            }
        }
        System.out.println(list);
        System.out.println("Numbers deleted:");
    }

    public int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println("M"+list.get(start));
        return list.get(start) >= target ? start : end;
    }

}
