class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge: invocations){
            adj.get(edge[0]).add(edge[1]);                 //build graph
        }

        boolean[] suspicious = new boolean[n];   
        suspicious[k] = true;

        Queue<Integer>q = new LinkedList<>();             //run bfs from k to all edges
        q.offer(k);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour: adj.get(node)){
                if(!suspicious[neighbour]){
                    suspicious[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }

        for(int[]edge: invocations){                     // check incoming edge from outside
            int u = edge[0];
            int v = edge[1];
            if(!suspicious[u] && suspicious[v]){
                List<Integer>ans = new ArrayList<>();
                for(int i=0;i<n;i++){
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer>ans= new ArrayList<>();            // run all methods
        for(int i=0;i<n;i++){
            if(!suspicious[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}