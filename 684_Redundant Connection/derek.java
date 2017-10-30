class Solution {
    // Key:
    // Union Find
    // 1. Path compression (路徑壓縮)
    public int[] findRedundantConnection(int[][] edges) {
        final int size = null != edges ? edges.length : 0;
        if (size <= 0) {
            return null;
        }
        
        int[] group = new int[size+1]; // root index
        int[] rank = new int[size+1];  // each height
        
        // Initialize
        for (int i = 0; i<= size; i++) {
            group[i] = i;
        }
        
        int p, q, pRoot, qRoot;
        for (int[] edge: edges) {
            p = edge[0];
            q = edge[1];
            
            //real root after path compression
            pRoot = find(p, group);
            qRoot = find(q, group);
            
            if (pRoot == qRoot) {
                //HIT !!!
                return edge;
            } else {
                if (rank[pRoot] == rank[qRoot]) {
                    //if the height is same, increse
                    rank[qRoot]++;
                }
                group[qRoot] = pRoot; //update new root
            }
        }
        return null;
    }
    
    private int find(int target, int[] group) {
        int tempIdx = 0;
        while (target != group[target]) {
            tempIdx = group[target];
            group[target] = group[tempIdx];
            target = group[target];
        }
        return target;
    }
}
