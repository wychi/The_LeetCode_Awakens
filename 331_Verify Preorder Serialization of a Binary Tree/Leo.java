class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int len = nodes.length, idx = 0;
        if (len > 1 && "#".equals(nodes[0])) return false;
        int queueCount = 0;
        outer:
        while (idx < len) {
            while (!"#".equals(nodes[idx++])) {
                queueCount++;
                if (idx >= len) break outer;
            }
            if (idx >= len) break;
            while ("#".equals(nodes[idx++])) {
                queueCount--;
                if (queueCount <= 0 || idx >= len) break outer;
            }
        }
        return queueCount == 0 && idx == len;
    }
}
