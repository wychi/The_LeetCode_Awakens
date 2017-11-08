class Solution {
    public int hIndex(int[] citations) {

    	// 1 2 100 3 4 6  n = 6


    	// 0 1 1 1 1 0 2  
    	// 0 1 2 3 4 5 6
		int[] counts = new int[citations.length+1];
		int length = citations.length;
		for(int i=0;i<citations.length;i++) {
			if(citations[i] > length) {
				counts[length] += 1;
			} else {
				counts[citations[i]] += 1;
			}
		}

		int sum = 0;
		for(int j=length;j>=0;j--) {
			sum += counts[j];
			if(sum >= j) {
				return j;
			}
		}
		return 0;        
    }
}