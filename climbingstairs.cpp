#include <bits/stdc++.h> 
int mod = 1e9 + 7;
int fib(int n,vector<int> &dp){
    if(n<=1){
        return n;
    }
    if(dp[n]!=-1) return dp[n];

    return dp[n] = fib(n-1,dp) + fib(n-2,dp);// 2 
}
int countDistinctWays(int n) {
    //  Write your code here.
    int prev1 = 0;
    int prev = 1;
    for(int i=2;i<=n+1;i++){
        int cur = (prev + prev1)%mod;
        prev1 = prev;
        prev = cur;
    }
    return prev;
}