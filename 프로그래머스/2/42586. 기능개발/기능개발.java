import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> al = new ArrayList<>();

        int plen = progresses.length;
        if (plen == 1) {
            return new int[1];
        } else if (plen < 0) {
            return null;
        }

        int totalSum = 0;
        int quotient;
        int count = 1;
        int curProgress;

        curProgress = 100 - progresses[0];
        if (curProgress % speeds[0] != 0) {
            quotient = (curProgress / speeds[0]) + 1;
        } else {
            quotient = curProgress / speeds[0];
        }
        totalSum += quotient;

        for (int i = 1; i < plen; i++) {
            curProgress = 100 - progresses[i] - speeds[i] * totalSum;
            if (curProgress > 0) {
                if (curProgress % speeds[i] != 0) {
                    quotient = (curProgress / speeds[i]) + 1;
                } else {
                    quotient = curProgress / speeds[i];
                }
                totalSum += quotient;
                al.add(count);
                count = 1;
            } else {
                count += 1;
            }
        }
        al.add(count);
        return al.stream().mapToInt(Integer::intValue).toArray();
}
}