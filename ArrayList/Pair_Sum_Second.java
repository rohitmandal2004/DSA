//Find if any pair in a sorted & rotated ArrayList has a sum equal to a given target.
//Input: arr = [11, 15, 6, 8, 9, 10], target = 16
//Output: true

import java.util.*;

public class Pair_Sum_Second {

    public static boolean pairSum(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        int breakPoint = -1;

        // Step 1: Find breakpoint
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                breakPoint = i;
                break;
            }
        }

        // Step 2: Initialize two pointers
        int lp = (breakPoint + 1) % n; // smallest element
        int rp = breakPoint;          // largest element

        // Step 3: Two pointer search
        while (lp != rp) {
            int sum = arr.get(lp) + arr.get(rp);

            if (sum == target) {
                return true;
            } else if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (rp - 1 + n) % n;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);

        int target = 16;

        boolean result = pairSum(arr, target);
        System.out.println("Is there a pair with the given sum? " + result);
    }
}