class Solution {
    class Info {
        int rank;
        int len = 1;
        int value;
        Info(int v, int r) {
            rank = r;
            value = v;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Info> map = new HashMap<>(); //4,1,-1,2,-1,2,3
        int last = 0;
        Info[] rankToInfo = new Info[nums.length];
        for (int v:nums) {
            Info info = map.get(v);
            if (null == info) {
                info = new Info(v, last);
                map.put(v, info);
                rankToInfo[last++] = info;
            } else {
                info.len++;
                while (info.rank > 0)  {
                    Info prev = rankToInfo[info.rank-1];
                    if (prev.len >= info.len) break;
                    rankToInfo[--info.rank] = info;
                    rankToInfo[++prev.rank] = prev;
                }
            }
        }
        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ret.add(rankToInfo[i].value);
        }
        return ret;
    }
}
