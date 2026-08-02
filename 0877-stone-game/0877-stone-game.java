class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total =0;
        for(int i=0;i<n;i++){
            total += piles[i];
        }
        int[][]memo = new int[n][n];
        for(int []row: memo){
            Arrays.fill(row,-1);
        }
        return memo(0,n-1,memo,piles)>0;
    }

    public int memo(int l ,int r , int [][]memo, int[]piles){
        if(l==r)return piles[l];
        if(memo[l][r]!=-1)return memo[l][r];
        int takeLeft = piles[l] - memo(l+1,r,memo,piles);
        int takeRight = piles[r] - memo(l,r-1,memo,piles);
        return memo[l][r] = Math.max(takeLeft, takeRight);
    }
}