// Count total ways to reach from (0,0) to (n-1,m-1) in a grid. allowed moves are right and down

public class Grid_ways{
    public static int gridWays(int i, int j, int n, int m){
        // Base case
        if(i == n - 1 && j == m - 1){
            return 1;
        }
        if(i >= n || j >= m){
            return 0;
        }
        // Recursion
        int w1 = gridWays(i+1, j, n, m); // down
        int w2 = gridWays(i, j+1, n, m); // right
        return w1 + w2;
    
    }


    public static void main(String args[]){
        int n = 3, m = 3;
        System.out.println(gridWays(0,0, n, m));
    }
}