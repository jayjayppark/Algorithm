import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] a : jobs) {
            pq2.offer(a);
        }
        int curTime = 0;
        int count = 0;
        int size = jobs.length;
        int answer = 0;
        while (count < size) {
            while (!pq2.isEmpty() && pq2.peek()[0] <= curTime) {
                pq1.offer(pq2.poll());
            }
            if (pq1.isEmpty()) {
                curTime = pq2.peek()[0];
            } else {
                int[] temp = pq1.poll();
                curTime += temp[1];
                answer += curTime - temp[0];
                count++;
            }
        }
        return answer / size;
    }
}