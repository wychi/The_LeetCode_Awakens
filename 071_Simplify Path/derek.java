class Solution {
    //Key:
    //1. valid file name (not in {"",".",".."})
    public String simplifyPath(String path) {
        final int strLen = null != path ? path.length() : 0;
        if (strLen <= 0) return "";
        
        Stack<String> stack = new Stack<>();
        HashSet<String> skipSet = new HashSet<>(Arrays.asList("..",".",""));
        String[] strArr = path.split("/");
        if (null == strArr) return "/";
        for (String dir: strArr) {
            if ("..".equals(dir) && !stack.isEmpty()) {
                stack.pop();
            } else if (!skipSet.contains(dir)) {
                stack.push(dir);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder resSb = new StringBuilder();
        for (String resPath : stack) {
            resSb.append("/").append(resPath);
        }
        return resSb.toString();
    }
}
