class Solution {
	public int lastRemaining(int n) {
		if (n <= 2) {
			return n;
		}
		int first = 2, last = (n % 2 == 0 ? n : n -1);
		int diff = 2;
		int size = last / 2;
		boolean fromStart = false;
		while(size > 2) {
			if (size % 2 == 1) {
				first = first + diff;
				last = last - diff;
			} else {
				if (fromStart) {
					first = first + diff;
				} else {
					last = last - diff;
				}
			}
			size /= 2;
			diff *= 2;
			fromStart = !fromStart;
		}
        	return fromStart ? last : first;
    	}
}