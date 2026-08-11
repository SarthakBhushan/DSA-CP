class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())return "";
        HashMap<Character, Integer>map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);   //put t charcaters in hashmap first
        }
        int l=0;
        int count=0;
        int minLen = Integer.MAX_VALUE;
        int start=0;
        for(int r=0;r<s.length();r++){
            char ch= s.charAt(r);
            if(map.containsKey(ch)){        //now start putting s character if same character found increase count and reduce map freq by 1
                if(map.get(ch)>0)count++;
                map.put(ch,map.get(ch)-1);
            }
            while(count==t.length()){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    start=l;
                }
                char leftChar = s.charAt(l);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar)+1);
                    if(map.get(leftChar)>0)count--;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(start,start+minLen);
    }
}