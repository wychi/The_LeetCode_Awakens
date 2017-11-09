class Solution {
    public boolean isValidSerialization(String preorder) {
        
        String[] tokens = preorder.split(",");
        int n = tokens.length;
        int count = 0;
        for(int i=n-1; i>=0; i--) {
            if(tokens[i].equals("#"))
                count++;
            else {
                if(count < 2) {   
                    return false;
                }
                count -= 2;
                count++;
            }
        }
        
        return count==1;
    }
}
