import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String[] st : clothes) {
            Integer al = hm.get(st[1]);
            if (al == null) {
                hm.put(st[1], 1);
            } else {
                hm.put(st[1], al + 1);
            }
        }

        return hm.values().stream().reduce(1, (a, b) -> a * (b + 1)) - 1;

//        int size = hm.size();
//        int[] clothesNum = new int[size];
//        int k = 0;
//        for (Integer i : hm.values()) {
//            clothesNum[k] = i;
//            k++;
//        }
//
//        int answer = 0;
//        for (int i = 1; i <= size; i++) {
//            for (int[] j : helpCombination(size, i)) {
//                int temp = 1;
//                for (int t : j) {
//                    temp = temp * clothesNum[t];
//                }
//                answer += temp;
//            }
//        }
//
//        return answer;

    }

    public static LinkedList<int[]> helpCombination(int n, int r) {
        LinkedList<int[]> al = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        Combination(0, n, 0, r, al, temp);
        return al;
    }

    public static void Combination(int depth, int arrLen, int next, int resultLen, LinkedList<int[]> al, LinkedList<Integer> temp) {
        if (depth == resultLen) {
            int[] tempArr = new int[resultLen];
            for (int i = 0; i < resultLen; i++) {
                tempArr[i] = temp.get(i);
            }
            al.add(tempArr);
            return;
        }

        for (int i = next; i <= arrLen - resultLen + depth; i++) {
            temp.add(i);
            Combination(depth + 1, arrLen, i + 1, resultLen, al, temp);
            temp.removeLast();
        }
    }

}