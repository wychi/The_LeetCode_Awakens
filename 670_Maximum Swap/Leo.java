class Solution {
    public int maximumSwap(int num) {
        char[] digit = Integer.toString(num).toCharArray();
        int count = digit.length, h = 0, l = 0;
        for (int prev = digit[0]; l < count; l++ ) {
            if (digit[l] > prev) break;
            prev = digit[l];
        }
        if (l == count) return num;
        h = l - 1;
        int max = digit[l];
        for (int i = l; i < count; i++) {
            if (max > digit[i]) continue;
            max = digit[i];
            l = i;
            while (h > 0 && digit[h-1] < max) h--;
        }
        char temp = digit[h];
        digit[h] = digit[l];
        digit[l] = temp;
        int ret = 0;
        for (char v:digit) ret = 10 * ret + (v-'0');
        return ret;
    }


    public int maximumSwap(int num) {
        int base = 1, count = 0;
        while (base <= num) {
            base *= 10;
            count++;
        }
        base/= 10;
        int[] digit = new int[count];
        for (int i = 0, k = num; i < count; i++, base/=10) {
            digit[i] = k/base;
            k -= base * digit[i];
        }
        int h = 0, l = 0;
        for (int prev = digit[0]; l < count; l++ ) {
            if (digit[l] > prev) break;
            prev = digit[l];
        }
        if (l == count) return num;
        h = l - 1;
        int max = digit[l];
        for (int i = l; i < count; i++) {
            if (max > digit[i]) continue;
            max = digit[i];
            l = i;
            while (h > 0 && digit[h-1] < max) h--;
        }
        int temp = digit[h];
        digit[h] = digit[l];
        digit[l] = temp;
        int ret = 0;
        for (int v:digit) ret = 10 * ret + v;
        return ret;
    }
}
