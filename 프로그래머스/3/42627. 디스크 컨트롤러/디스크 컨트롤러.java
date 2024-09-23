import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int curTime = 0;
        int jobLen = jobs.length;
        int count = 0;
        int jobIndex = 0;
        int answer = 0;
        
        while(count < jobLen) {
            while (jobIndex < jobLen && jobs[jobIndex][0] <= curTime) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }
            
            if (pq.isEmpty()) {
                curTime = jobs[jobIndex][0];
            } else {
                int[] temp = pq.poll();
                count++;
                curTime += temp[1];
                answer += curTime - temp[0];
            }
        }
        return answer / jobLen;
    }
}