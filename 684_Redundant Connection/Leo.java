class Solution {
    public int find(int p, int[] group) {
        while(p != group[p]) {
            group[p] = group[group[p]];
            p = group[p];
        }
        return p;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] group = new int[n+1], ranks = new int[n+1];
        for (int i = 0; i <= n; i++) group[i] = i;
        for (int[] e:edges) {
            int pR = find(e[0], group);
            int qR = find(e[1], group);
            if (pR == qR) return e;
            if (ranks[pR] < ranks[qR]) {
                  group[pR] = qR;
            } else {
                if (ranks[pR] == ranks[qR]) ranks[pR]++;
                group[qR] = pR;
            }
        }
        return null;
    }    
}
