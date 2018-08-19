class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] asciiArr = new int[256];
        int k = 0;
        for (int i = 0; i < J.length(); i++) {
            // System.out.println("i:"+i+", ori:"+J.charAt(k)+", modify:"+(J.charAt(k)-'A'));
            asciiArr[J.charAt(k)-'A'] = 1;
            k++;
        }
        // System.out.println("a[0]:"+asciiArr[0]);
        int result = 0;
        k=0;
        for (int i = 0; i < S.length(); i++) {
            if (asciiArr[S.charAt(k++)-'A'] == 1) {
                result++;
            }
        }
        return result;
    }
}
