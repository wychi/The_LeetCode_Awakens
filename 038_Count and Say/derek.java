class Solution {
    public String countAndSay(int n) {
        if (n < 0) {
            return "";
        }
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        char say;
        int count = 0;
        for (int i = 1; i<n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1; j<prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
}
