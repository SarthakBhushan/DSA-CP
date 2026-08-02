class Solution {
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        long[]prefix = new long[n+1];
        for(int i=1;i<=n;i++){
            if((nums[i-1]&1)==1)prefix[i]=prefix[i-1]+a;
            else prefix[i]= prefix[i-1]-b;
        }
        long[]sorted = prefix.clone();
        Arrays.sort(sorted);
        ArrayList<Long>values = new ArrayList<>();
        for(long x: sorted){
            if(values.isEmpty()||values.get(values.size()-1)!=x)values.add(x);
        }
        Fenwick bit = new Fenwick(values.size());
        long ans =0;
        bit.add(lowerBound(values,0L),1);
        for(int i=1;i<=n;i++){
            int idx = upperBound(values, prefix[i]);
            ans+= bit.query(idx);
            bit.add(lowerBound(values,prefix[i]),1);
        }
        return ans;
    }

        private int lowerBound(ArrayList<Long> arr, long target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l + 1;
    }

    private int upperBound(ArrayList<Long> arr, long target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    static class Fenwick{
        int[]tree;
        Fenwick(int n){
            tree = new int[n+2];
        }
        void add(int idx, int val){
            while(idx<tree.length){
                tree[idx]+=val;
                idx+=idx& -idx;
            }
        }

        int query(int idx){
            int sum =0;
            while(idx>0){
                sum+=tree[idx];
                idx-=idx & -idx;
            }
            return sum;
        }
    }
}