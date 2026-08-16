class Solution {
    long[][][] memo;
    int[]a;
    int m;
    int startIndex;
    public long elevatorRequests(int n, int start, int[] requests) {
        List<Integer>list = new ArrayList<>();
        for(int x: requests){
            if(x!=start)list.add(x);
        }

        list.add(start);
        Collections.sort(list);

        m = list.size()-1;
        a = new int[list.size()];
        for(int i=0;i<list.size();i++){
            a[i]= list.get(i);
            if(a[i]==start){
                startIndex=i;
            }
        }
        memo = new long[a.length][a.length][2];
        for(long[][]x:memo){
            for(long[]y: x){
                Arrays.fill(y,-1);
            }
        }
        return Math.min(solve(startIndex, startIndex,0), solve(startIndex, startIndex,1));
    }

    private long solve(int left, int right, int side){
        if(left==0 && right==a.length-1){
            return 0;
        }
        if(memo[left][right][side]!=-1){
            return memo[left][right][side];
        }
        int completed = (right-left+1)-1;
        int remaining = m-completed;
        long ans = Long.MAX_VALUE;
        int current = (side==0)? a[left]: a[right];
        if(left>0){
            long distance = Math.abs((long)current-a[left-1]);
            ans = Math.min(ans, distance* remaining+ solve(left-1,right,0));
        }
        if(right<a.length-1){
            long distance = Math.abs((long)current - a[right+1]);
            ans = Math.min(ans, distance* remaining + solve(left,right+1,1));
        }
        return memo[left][right][side] = ans;
    }
}