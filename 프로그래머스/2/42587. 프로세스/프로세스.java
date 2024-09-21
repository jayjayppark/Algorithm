import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> ll = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            ll.add(new int[]{i, priorities[i]});
        }

        int answer = 0;
        while (!ll.isEmpty()) {
            int max = 0;
            int index = 0;
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i)[1] > max) {
                    max = ll.get(i)[1];
                    index = i;
                }
            }
            for (int j = 0; j < index; j++) {
                ll.offerLast(ll.pollFirst());
            }
            if (ll.pollFirst()[0] == location) {
                answer += 1;
                return answer;
            }
            answer += 1;
        }
        return answer;
    }
}