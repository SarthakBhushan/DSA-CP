class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[]copy = nums.clone();
        Arrays.sort(copy);
        Map<Integer, List<Integer>>group = new HashMap<>();
        Map<Integer, Integer>groupId = new HashMap<>();
        Map<Integer, Integer>pos = new HashMap<>();

        int id =1;
        group.computeIfAbsent(id , k -> new ArrayList<>()).add(copy[0]);
        groupId.put(copy[0],id);
        for(int i=1;i<n;i++){
            if(copy[i]-copy[i-1]>limit)id++;

            group.computeIfAbsent(id, k -> new ArrayList<>()).add(copy[i]);
            groupId.put(copy[i],id);
        }

        for(int i=0;i<n;i++){
            int grp = groupId.get(nums[i]);
            int p = pos.getOrDefault(grp,0);

            nums[i]= group.get(grp).get(p);
            pos.put(grp,p+1);
        }
        return nums;
    }
}