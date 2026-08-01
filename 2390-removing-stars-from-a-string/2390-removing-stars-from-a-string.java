class Solution {
    public String removeStars(String s) {
        Stack<Character>st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch=='*'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}