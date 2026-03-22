//Container With Most Water
//for give n lines on X axis, use 2 lines to form a container such that it holds maximum water. Return the maximum amount of water a container can store.
//height = [1,8,6,2,5,4,8,3,7]
//output = 49


import java.util.*;

public class Ques_one{
    // public static int storeWater(ArrayList<Integer> height){
    //     int maxwater = 0;
    //     int left = 0;
    //     int right = height.size()-1;
        
    //     //brute force approach
    //     for(int i = 0; i < height.size(); i++){
    //         for(int j = i+1; j < height.size(); j++){
    //             int ht = Math.min(height.get(i), height.get(j));
    //             int width = j - i;
    //             int currentwater = ht * width;
    //             maxwater = Math.max(maxwater, currentwater);
    //         }
    //     }
    //     return maxwater;
    // }
    
    //optimized approach(two pointer approach)
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        int left = 0;
        int right = height.size()-1;
        while(left < right){
            //calculate water area
            int ht = Math.min(height.get(left), height.get(right));
            int width = right - left;
            int currentWater = ht * width;
            maxWater = Math.max(maxWater, currentWater);

            //update the pointers
            if(height.get(left) < height.get(right)){
                left++;
            }else{
                right--;
                }
            
        }
        return maxWater;
    }


    public static void main(String args[]){
       ArrayList<Integer> height = new ArrayList<>();
         height.add(1);
         height.add(8);
         height.add(6);
         height.add(2);     
         height.add(5);
         height.add(4);
         height.add(8);
         height.add(3);
         height.add(7);

            int result = storeWater(height);
            System.out.println("The maximum amount of water a container can store is: " + result);
    }
}