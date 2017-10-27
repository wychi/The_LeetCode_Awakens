class Solution {
    public String simplifyPath(String path) {
        if (path.length() < 2) return "/";
        List<String> pathList = new ArrayList<>();
        path += "/";
        String name = "";
        int dotCount = 0;
        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '.') {
                dotCount++;
                name += c;
            } else if (c == '/') {
                if (dotCount == 2) {
                    if (pathList.size() > 0) pathList.remove(pathList.size() - 1);
                    name = "";
                } else if (dotCount == 1) {
                    name = "";
                }
                dotCount = 0;
                if (name.length() > 0) pathList.add(name);
                name = "";
            } else {
                dotCount = 0;
                name += c;
            }
        }
        String result = "";
        for (String t : pathList) result += ("/" + t);
        return result.length() == 0 ? "/" : result;
    }
}