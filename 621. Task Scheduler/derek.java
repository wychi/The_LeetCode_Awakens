class Solution {
    //Time:O(N)
    //Space:O(1)
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[tasks.length];
        for (char c: tasks) {
            map[c-'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());//Max-Heap
        for (int taskId: map) {
            if (taskId > 0) queue.offer(taskId);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll()-1); //再去排隊一次
                    } else {
                        queue.poll(); // 取出，排入結果
                    }
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
            for (int taskId: temp) {
                queue.offer(taskId);
            }
        }
        return time;
    }
}
