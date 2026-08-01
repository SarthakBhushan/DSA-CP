class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i)=='*'){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i = Math.max(0,i-2);
            }
        }
        return sb.toString();
    }
}