class Solution {
    // [[1,4],[3,4],[1,3],[1,2],[4,5]]
    // [[3,7],[1,4],[2,8],[1,6],[7,9],[6,10],[1,7],[2,3],[8,9],[5,9]]
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] nodes = new int[n+1];
        for(int i=1;i<n+1;i++) {
            nodes[i] = i;
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int ug = find(nodes, u);
            int vg = find(nodes, v);
            if(ug != vg) {
                if(ug != u) {
                    union(nodes, u, v);
                } else {
                    union(nodes, v, u);
                }
                
            } else {
                return edge;
            }
        }
        
        return new int[] {0, 0};
    }
    
    void union(int[] nodes, int i, int j) {
        if(nodes[j] == j)
            nodes[j] = find(nodes, i);
        else {
            union(nodes, i, nodes[j]);
        }
    }
    
    int find(int[] nodes, int i) {
        if(nodes[i] == i)
            return i;
        return find(nodes, nodes[i]);
    }
}
