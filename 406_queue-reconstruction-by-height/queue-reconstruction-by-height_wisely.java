class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length < 2) return people;
        int[][] result = new int[people.length][2];
        Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                }
				return o1[1] > o2[1] ? 1 : -1;
			}
		});
        List<int[]> temp = new ArrayList<>();
        temp.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            temp.add(people[i][1], people[i]);
        }
        for (int i = 0; i < people.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}