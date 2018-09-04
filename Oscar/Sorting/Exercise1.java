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
public class Exercise1
{
    //Bevis for færrest elementer i voksende størrelse: antag at du kan slette endnu et element - derved bliver kæden et element større og vi får dermed en længste kæde, der er et element større.
    public void findLIS(int[] arr) {
        int n = arr.length;
        // Create list of list of integer
        List<List<Integer>> lis = new ArrayList<>();
        // Create as many lists as elements in arr
        for (int i = 0; i < arr.length; i++) {
            lis.add(new ArrayList<>());
        }

        //Run through arr
        for (int i = 1; i < arr.length; i++) {
            //Check for every element each element before
            for (int j = 0; j < i; j++) {
                //If element before is below given element add it to the list
                if (arr[i] > arr[j] && lis.get(i).size() < lis.get(j).size() + 1) {
                    lis.set(i, new ArrayList<>(lis.get(j)));
                    System.out.println(lis);
                }
            }
            
            lis.get(i).add(arr[i]);
        }

        List<Integer> longest = lis.get(0);
        System.out.println(longest);
        //Checks which of ALL the lis (each for every element in arr) is the longest and thus also the longest increasing list
        for (int i = 0; i < lis.size(); i++) {
            if (longest.size() < lis.get(i).size()) {
                longest = new ArrayList<>(lis.get(i));
            }
        }
        int m = longest.size();
        System.out.println(longest);
        System.out.print("Elements deleted:"+(n-m));
    }
}
