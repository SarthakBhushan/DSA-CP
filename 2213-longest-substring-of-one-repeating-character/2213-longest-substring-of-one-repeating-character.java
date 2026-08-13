class Solution {
    class Node{
        int len;
        int prefix;
        int suffix;
        int max;
        char leftChar;
        char rightChar;

        Node(int len, int prefix, int suffix, int max, char leftChar, char rightChar){
            this.len = len;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max= max;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[]tree;
    char[]a;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        a=s.toCharArray();
        int n = a.length;
        tree = new Node[4*n];
        build(1,0,n-1);
        int[]res = new int[queryIndices.length];
        for(int i=0;i<queryIndices.length;i++){
            int index = queryIndices[i];
            a[index]= queryCharacters.charAt(i);
            update(1,0,n-1,index);
            res[i]= tree[1].max;
        }
        return res;
    }

    void build(int node, int l, int r){
        if(l==r){
            tree[node] = new Node(1,1,1,1,a[l],a[l]);
            return;
        }
        int mid = (l+r)/2;
        build(node*2,l,mid);
        build(node*2+1,mid+1,r);
        tree[node]= merge(tree[node*2], tree[node*2+1]);
    }

    void update(int node, int l, int r, int index){
        if(l==r){
            tree[node]= new Node(1,1,1,1,a[l],a[l]);
            return;
        }
        int mid =(l+r)/2;
        if(index<=mid){
            update(node*2,l,mid,index);
        }else{
            update(node*2+1,mid+1,r,index);
        }
        tree[node] = merge(tree[node*2], tree[node*2+1]);
    }

    Node merge(Node left, Node right){
        int len = left.len+ right.len;
        int prefix = left.prefix;
        int suffix = right.suffix;
        if(left.leftChar==right.leftChar && left.prefix == left.len){
            prefix = left.len+right.prefix;
        }
        if(left.rightChar == right.rightChar && right.suffix==right.len){
            suffix = right.len+left.suffix;
        }
        int max = Math.max(left.max,right.max);
        if(left.rightChar== right.leftChar){
            max = Math.max(max,left.suffix+right.prefix);
        }
        return new Node(
            len,
            prefix,
            suffix,
            max,
            left.leftChar,
            right.rightChar
        );
    }
}