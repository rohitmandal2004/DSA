//Find if any pair in a sorted ArrayList has a sum equal to a given target.
//Input: arr = [1, 2, 3, 4, 5, 6], target = 5
//Output: true

import java.util.*;

public class Pair_Sum_One{
    public static boolean pairSum(ArrayList<Integer> arr, int target){
        int left = 0;
        int right = arr.size() - 1;

        while(left < right){
            int currentSum = arr.get(left) + arr.get(right);
            if(currentSum == target){
                return true;
            }else if(currentSum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public static void main(String args[]){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        int target = 5;
        boolean result = pairSum(arr, target);
        System.out.println("Is there a pair with the given sum? " + result);
    }
}