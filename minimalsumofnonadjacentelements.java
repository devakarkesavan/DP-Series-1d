import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {

	public static int findsum(int ind,ArrayList<Integer> nums,ArrayList<Integer> dp){
		 if(ind == 0){
			 return nums.get(ind);
		 }
		 if (ind < 0) {
            return 0;
        }
        if (dp.get(ind) != -1) {
            return dp.get(ind);
        }
        int pick = findsum(ind - 2, nums, dp) + nums.get(ind);
        int not_pick = 0 + findsum(ind - 1, nums, dp);
        int k = Math.max(pick, not_pick);
        dp.set(ind, k);
        return dp.get(ind);
	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n = nums.size();
    if (n == 0) return 0;
    ArrayList<Integer> dp = new ArrayList<>();
    dp.add(nums.get(0));
    if (n > 1) {
        dp.add(Math.max(nums.get(0), nums.get(1)));
    }
    for (int ind = 2; ind < n; ind++) {
        int pick = dp.get(ind - 2) + nums.get(ind);
        int not_pick = dp.get(ind - 1);
        int k = Math.max(pick, not_pick);
        dp.add(k);
    }
    return dp.get(n - 1);
	}
}