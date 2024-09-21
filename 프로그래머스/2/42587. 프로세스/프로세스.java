import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public static int solution(int[] priorities, int location) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int k : priorities) {
            ad.offer(k);
        }
        Arrays.sort(priorities);

        int answer = 0;
        int size = priorities.length - 1;
        while (!ad.isEmpty()) {
            Integer a = ad.poll();
            if (a == priorities[size - answer]) {
                answer++;
                location--;
                if (location < 0) {
                    break;
                }
            } else {
                ad.offer(a);
                location--;
                if (location < 0) {
                    location = ad.size() - 1;
                }
            }
        }

        return answer;
    }
}