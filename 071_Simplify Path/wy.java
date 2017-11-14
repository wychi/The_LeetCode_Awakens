class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> folders = new LinkedList<>();
        
        int left = 0;
        int right = 0;
        int nDot = 0;
        while(right < path.length()) {
            if(path.charAt(right) == '/') {
                if(nDot == 1 && right - left == 2) {
                } else if(nDot == 2 && right - left == 3) {
                    if(!folders.isEmpty())
                        folders.removeLast();
                } else {
                    if(right > left + 1)
                        folders.add(path.substring(left, right));
                }
                nDot = 0;
                left = right;
                
            } else if(path.charAt(right) == '.') {
                nDot++;
            }
            right++;
        }
        if(nDot == 1 && right - left == 2) {
        } else if(nDot == 2 && right - left == 3) {
            if(!folders.isEmpty())
                folders.removeLast();
        } else {
            if(right > left + 1)
                folders.add(path.substring(left, right));
        }
        
        StringBuilder sb = new StringBuilder();
        if(folders.isEmpty()) {
            sb.append("/");
        } else {
            while(!folders.isEmpty()) {
            sb.append(folders.removeFirst());
        }
        }
        
        
        return sb.toString();
    }
}
