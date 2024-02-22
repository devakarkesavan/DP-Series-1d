import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static int f(int ind,int k,int height[],ArrayList<Integer> dp){
        if(ind == 0){
            return 0;
        }
        int mini = Integer.MAX_VALUE;
        if(dp.get(ind)!=-1){
            return dp.get(ind);
        }
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
                int jump = f(ind-i,k,height,dp) + Math.abs(height[ind]-height[ind-i]);
                mini = Math.min(mini,jump);
            }
        }
        dp.set(ind,mini);
        return dp.get(ind);
    }
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n, -1));
        return f(n-1,k,height,dp);
    }
}