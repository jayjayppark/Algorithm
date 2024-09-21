import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int k : priorities) {
            pq.add(k);
        }
        int size = priorities.length;
        int answer = 0;
        while(!pq.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }
}