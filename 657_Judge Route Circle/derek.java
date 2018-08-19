class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() <= 0) return true;
        int horizontalMove = 0, verticalMove = 0;
        for (char c: moves.toCharArray()) {
            if ('U' == c) verticalMove++;
            else if ('D' == c) verticalMove--;
            else if ('L' == c) horizontalMove--;
            else if ('R' == c) horizontalMove++;
        }
        return horizontalMove == 0 && verticalMove == 0;
    }
}
