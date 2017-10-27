class Solution {
    public String simplifyPath(String path) {
        char[] str = path.toCharArray();
        char[] output = new char[str.length+1];
        int size = str.length, idxR = 0, idxW = 0;
        while (idxR < size) {
            while (idxR < size && str[idxR] == '/') idxR++;
            int len = idxR;
            while (len < size && str[len] != '/') len++;
            len -= idxR;
            if (0 == len) {
                idxR++;
            } else if (str[idxR] == '.' && len <= 2) {
                if (len == 1) {
                    idxR += 2;
                } else if (str[idxR+1] == '.') {
                    while (idxW > 0 && output[--idxW] != '/');
                    idxR += 3;
                }
            } else {
                output[idxW++] = '/';
                while (len-- > 0)  output[idxW++] = str[idxR++];
            }
        }
        if (idxW <= 0) output[idxW++] = '/';
        return new String(output, 0, idxW);
    }
}
