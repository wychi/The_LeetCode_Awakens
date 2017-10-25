class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] nodes = new int[n];
        for(int i=0; i<n; i++) {
            nodes[i] = i;
        }
        

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(M[i][j] == 1) {
                    union(nodes, i, j);
                }
            }
        }
        
        Set<Integer> groups = new HashSet<>();
        for(int i=0;i<n;i++) {
            groups.add(find(nodes, i));
        }
        
        return groups.size();
    }
    
    void union(int[] nodes, int i, int j) {
        int pi = find(nodes, i);
        int pj = find(nodes, j);
        nodes[pj] = pi;
    }
    
    int find(int[] nodes, int i) {
        if(nodes[i] == i)
            return i;
        
        return find(nodes, nodes[i]);
    }
    
}
