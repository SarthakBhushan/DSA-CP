class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, int[]>cinema = new HashMap<>();
        for(int[]seat: reservedSeats){
            int row = seat[0];
            int col = seat[1];

            if(!cinema.containsKey(row)){
                int[]seats = new int[10];
                Arrays.fill(seats,-1);
                cinema.put(row,seats);
            }
            cinema.get(row)[col-1]=0;
        }
        int res = (n-cinema.size())*2;

        for(int[]row:cinema.values()){
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for(int j=1;j<=4;j++){
                if(row[j]==0){
                    left=false;
                    break;
                }
            }
            for(int j=3;j<=6;j++){
                if(row[j]==0){
                    middle = false;
                    break;
                }
            }
            for(int j=5;j<=8;j++){
                if(row[j]==0){
                    right = false;
                    break;
                }
            }
            if(left&&right){
                res+=2;
            }else if(left||middle||right){
                res+=1;
            }
        }
        return res;
    }
}