class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min = Integer.MAX_VALUE;
        int idx =-1;
        for(int i=0;i<drones.length;i++){
            int[]d = drones[i];
            int dist = Math.abs(target[0]-d[0])+ Math.abs(target[1]-d[1]);
            if(dist<=d[2] && min > dist){
                min = dist;
                idx =i;
            }
        }
        return idx;
    }
}