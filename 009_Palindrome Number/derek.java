class Solution {

	//My Solution
public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int low = 0, high = str.length()-1;
        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) return false;
            low ++;
            high--;
        }
        return true;
    }


	//Editor Solution
	//Time: log10(N)
	//Space: O(1)
    public boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x!= 0)) {
            return false;
        }
        
        int reversedNumber = 0, temp = x;
        while (temp > 0) {
            reversedNumber = reversedNumber*10 + temp%10;
            temp /= 10;
        }
        return x == reversedNumber;
    }
}
