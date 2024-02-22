import java.util.* ;
import java.io.*; 
public class Solution {
    public static int f(int ind,int heights[],ArrayList<Integer> dp){
        if(ind == 0){
            return 0;
        }
        if(dp.get(ind)!=-1){
            return dp.get(ind);
        }
        int left = f(ind-1,heights,dp) + Math.abs(heights[ind] - heights[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind>1){
            right = f(ind-2,heights,dp) + Math.abs(heights[ind]-heights[ind-2]);
        }
        int k =  Math.min(left,right);
        dp.set(ind,k);
        return k;
    }
    public static int frogJump(int n, int heights[]) {

        // ArrayList<Integer> dp = new ArrayList<>(n);
        // dp.add(0); // Add the initial element
        int prev1 = 0;
        int prev = 0;
        for (int ind = 1; ind <n; ind++) {
            int left = prev1 + Math.abs(heights[ind] - heights[ind - 1]);
            int right = Integer.MAX_VALUE;
            if (ind > 1) {
                right = prev + Math.abs(heights[ind] - heights[ind - 2]);
            }
            int cur = Math.min(left, right);
            prev = prev1;
            prev1 = cur;
        }
        return prev1;
    }

}