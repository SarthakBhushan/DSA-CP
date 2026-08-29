class Solution {
    static long hash(long x){
        x += 0x9E3779B97F4A7C15L;
        x = (x ^ (x >>> 30)) * 0xBF58476D1CE4E5B9L;
        x = (x ^ (x >>> 27)) * 0x94D049BB133111EBL;
        return x ^ (x >>> 31);
    }
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        long[]prefixXor = new long[n+1];
        for(int i=0;i<n;i++){
            prefixXor[i+1]= prefixXor[i]^hash(nums[i]);
        }
        Integer[]order = new Integer[q];
        for(int i=0;i<q;i++)order[i]=i;
        Arrays.sort(order,(a,b)-> Integer.compare(queries[a][1], queries[b][1]));
        Fenwick bit = new Fenwick(n);
        HashMap<Integer, Integer>last = new HashMap<>();
        boolean[]ans = new boolean[q];
        int currentRight = -1;
        for(int queryIndex: order){
            int left = queries[queryIndex][0];
            int right = queries[queryIndex][1];

            while(currentRight<right){
                currentRight++;
                int value = nums[currentRight];
                if(last.containsKey(value)){
                    int oldPosition = last.get(value);
                    bit.update(oldPosition,-1);
                }
                bit.update(currentRight,1);
                last.put(value,currentRight);
            }
            int distinct = bit.query(right)-bit.query(left-1);
            if(distinct!=k){
                ans[queryIndex]= false;
                continue;
            }
            long xor = prefixXor[right+1]^prefixXor[left];
            ans[queryIndex]= (xor==0);
        }
        return ans;
    }
    static class Fenwick{
        int[]tree;
        Fenwick(int n){
            tree = new int[n+1];
        }
        void update(int index, int delta){
            index++;
            while(index<tree.length){
                tree[index]+=delta;
                index+= index & -index;
            }
        }
        int query(int index){
            index++;
            int sum=0;
            while(index>0){
                sum+= tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}