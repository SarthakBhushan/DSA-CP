class Solution {
    public boolean checkDivisibility(int n) {
        int sum =0;
        int prod =1;
        int store = n;
        while(n!=0){
            sum +=n%10;
            prod *= n%10;
            n/=10;
        }
        return ((store)%(sum+prod))==0;
    }
}