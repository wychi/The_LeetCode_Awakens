class Solution {
    //Recursive
    //Time:O(N)
    //Space:O(N/26) => O(N)
    // public String convertToTitle(int n) {
    //     return 0 == n ? "" : convertToTitle((n-1)/26) + (char) ((n-1)%26 + 'A');
    // }
    
    //Iterative
    //Time:O(N)
    //Space:O(N/26)
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            n--;
            sb.append((char) ('A'+ n%26 ));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
