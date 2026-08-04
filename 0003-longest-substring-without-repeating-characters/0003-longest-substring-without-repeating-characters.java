class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0;
        int maxLen =0;
        int r =0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        while(r<n){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;   
            }else{
                set.add(s.charAt(r));
                r++;
                maxLen = Math.max(maxLen,r-l);
            }
        }
        return maxLen;
    }
}